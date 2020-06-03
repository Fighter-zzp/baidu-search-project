package com.zzp.imitate.baidu.mapper;

import com.zzp.imitate.baidu.domain.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.MyMapper;

import javax.management.Query;
import java.util.List;

/**
 * NewsMapper
 * <p>
 *  //TODO
 *  NewsMapper.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/6/2 18:01
 * @see  NewsMapper
 **/
@Mapper
public interface NewsMapper extends MyMapper<News> {
    /**
     * 查询
     * @param queryString .
     * @return .
     */
    @Select("select tags from news where tags like concat('%',#{queryString},'%')")
    List<News> queryByLikeTags(String queryString);
}