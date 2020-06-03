package com.zzp.imitate.baidu.controller;

import com.zzp.imitate.baidu.domain.News;
import com.zzp.imitate.baidu.service.NewsService;
import com.zzp.imitate.baidu.vo.NewsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <标题>
 * <p>
 *  //TODO
 *  NewsController.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/6/2 19:03
 * @see  NewsController
 **/
@RequestMapping("/news")
@RestController
@Slf4j
@CrossOrigin(origins = "*",maxAge = 3600)
public class NewsController {
    @Resource
    private NewsService newsService;

    @GetMapping("/suggest")
    public List<NewsVo> queryString(String prefix){
        var newsLists =  newsService.queryNewsTitle(prefix);
        log.info(newsLists.toString());
        return newsLists;
    }

    @GetMapping("/text")
    public List<News> queryKeyWord(String kw){
        return newsService.queryNewsLists(kw);
    }
}
