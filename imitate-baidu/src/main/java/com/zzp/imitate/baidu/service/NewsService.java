package com.zzp.imitate.baidu.service;

import com.zzp.imitate.baidu.domain.News;
import com.zzp.imitate.baidu.vo.NewsVo;

import java.util.List;

/**
 * NewsService
 * <p>
 *  //TODO
 *  NewsService.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/6/2 18:02
 * @see  NewsService
 **/
public interface NewsService {
    /**
     * 查询新闻标题
     * @param queryString 关键消息
     * @return  {@link List<NewsVo>}
     */
    List<NewsVo> queryNewsTitle(String queryString);

    /**
     * 获取新闻
     * @param keyWord .
     * @return .
     */
    List<News> queryNewsLists(String keyWord);
}
