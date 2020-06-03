package com.zzp.imitate.baidu.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
/**
 * News
 * <p>
 *  //TODO
 *  News.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/6/2 18:42
 * @see  News
 **/
@Data
@Table(name = "news")
public class News implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    @Column(name = "content")
    private String content;

    @Column(name = "tags")
    private String tags;

    private static final long serialVersionUID = 1L;
}