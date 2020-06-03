package com.zzp.imitate.baidu.service.impl;

import com.zzp.imitate.baidu.domain.News;
import com.zzp.imitate.baidu.mapper.NewsMapper;
import com.zzp.imitate.baidu.service.NewsService;
import com.zzp.imitate.baidu.vo.NewsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <标题>
 * <p>
 * //TODO
 * NewsServiceImpl.java
 * </p>
 *
 * @author 佐斯特勒
 * @version v1.0.0
 * @date 2020/6/2 18:46
 * @see NewsServiceImpl
 **/
@Service
@Slf4j
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<NewsVo> queryNewsTitle(String queryString) {
        var newsVoLists = new ArrayList<NewsVo>();
        var opsForSet = redisTemplate.opsForSet();
        var newsVoSet = opsForSet.members(queryString);
        var op = Optional.ofNullable(newsVoSet);
        op.filter(n -> n.size() > 0).ifPresentOrElse(
                n -> {
                    n.stream().map(tag -> (NewsVo) tag).forEach(newsVoLists::add);
                    log.info("查询redis");
                },
                () -> newsMapper.queryByLikeTags(queryString)
                        .stream()
                        .map(news -> findKeyWord(news.getTags(), queryString))
                        .forEach(list -> {
                            list.forEach(e1 -> {
                                var newsVo = new NewsVo(e1);
                                newsVoLists.add(newsVo);
                                opsForSet.add(queryString, newsVo);
                            });
                            log.info("数据插入");
                        }));
        return newsVoLists;
    }

    @Override
    public List<News> queryNewsLists(String keyWord) {
        var e = new Example(News.class);
        e.createCriteria()
                .andLike("tags", "%"+keyWord+"%");
        return newsMapper.selectByExample(e)
                .stream()
                .peek(news -> {
                    news.setTitle(processWord(news.getTitle(), keyWord));
                    news.setContent(processWord(news.getContent(), keyWord));
                }).collect(Collectors.toList());
    }

    private String processWord(String source, String word) {
        if (source.contains(word)){
            var cw = "<span style='color: red'>" + word +
                    "</span>";
            return source.replaceAll(word, cw);
        }
        return source;
    }

    /**
     * 匹配关键词获取tags
     *
     * @param tags    .
     * @param keyWord .
     * @return .
     */
    private List<String> findKeyWord(String tags, String keyWord) {
        var arrays = tags.split(",");
        return Stream.of(arrays)
                .filter(w -> w.contains(keyWord))
                .collect(Collectors.toList());
    }

}
