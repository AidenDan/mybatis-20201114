package com.mybatis;

import org.junit.Test;

import java.util.*;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-11-15 01:55:29
 */
public class DemoTest {

    @Test
    public void testTreeSet(){
        // TreeSet去重复元素，保留顺序
        List<String> list = Arrays.asList("hello", "hello", "m", "h", "11", "11", "gh", "gh");
        System.err.println("list:::"+list);
//        TreeSet<String> treeSet = new TreeSet<>(list);
////        List<String> list1 = new ArrayList<>();
////        list1.addAll(treeSet);
////        System.err.println("list1:::"+list1);
        Set<String> set = new LinkedHashSet<>(list);
        System.err.println("set:::"+set);
    }
}
