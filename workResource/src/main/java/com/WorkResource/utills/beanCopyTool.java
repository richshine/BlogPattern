package com.WorkResource.utills;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.stream.Collectors;

public class beanCopyTool {
    public static <V> V copyBean(Object source, Class<V> clazz) {
        V result = null;
        try {
            Constructor<V> constructor = clazz.getConstructor();
            result = constructor.newInstance();
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static <O, V> List<V> copyBeanList(List<O> list, Class<V> clazz) {
        List<V> collect = list.stream().
                map(item -> copyBean(item, clazz)).
                collect(Collectors.toList());
        return collect;
    }
}
