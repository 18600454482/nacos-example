package com.xiaoy.dubbo.provider.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: Xiaoy
 * @Description:
 * @Date: Created in 16:31 2019/3/18
 * @Modified By:
 */
public class BeansUtils {
    /**
     * 单个bean转换
     * @param orig
     * @param tClass
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> T convert(U orig, Class<T> tClass){
        try {
            T bean = tClass.newInstance();
            BeanUtils.copyProperties(bean , orig);
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 多个bean转换
     * @param orig
     * @param tClass
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> List<T> convert(List<U> orig, Class<T> tClass){
        return orig.stream()
                .map(item -> convert(item, tClass))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
