package com.zzp.imitate.baidu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * newsVo
 * <p>
 *  //TODO
 *  NewsVo.java
 * </p>
 * @version v1.0.0
 * @author 佐斯特勒
 * @date 2020/6/2 18:42
 * @see  NewsVo
 **/
@Data
@AllArgsConstructor
public class NewsVo implements Serializable {

    private static final long serialVersionUID = -3704530505566266889L;
    private String tags;
}
