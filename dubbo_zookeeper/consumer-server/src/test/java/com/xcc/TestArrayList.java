package com.xcc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xuhe
 * @PackageName:com.xcc
 * @ClassName:TestArrayList
 * @Description:
 * @data 2022/6/15 22:56
 */
public class TestArrayList {
    public static void main(String[] args) {
        //testArrayList();
        testCopyOnWriteArrayList();
    }

    private static void testCopyOnWriteArrayList() {

        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<Integer>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(2);
        numbers.add(23);
        Iterator<Integer> it = numbers.iterator();
        Collections.unmodifiableCollection(numbers);
        numbers.add(12);
        while(it.hasNext()) {
            Integer i = it.next();
            if(i < 10) {
                numbers.add(i+1);
                System.out.println(numbers);
            }
        }
        System.out.println(numbers);
        Collection numbers2 = Collections.unmodifiableCollection(numbers);
        Iterator<Integer> it2 = numbers2.iterator();
        Collections.unmodifiableCollection(numbers2);
        numbers2.add(12);
        while(it2.hasNext()) {
            Integer i = it2.next();
            if(i < 10) {
                numbers.add(i+1);
                System.out.println(numbers2);
            }
        }
        System.out.println(numbers2);
    }

    private static void testArrayList(){

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(8);
        numbers.add(2);
        numbers.add(23);
        Iterator<Integer> it = numbers.iterator();
        while(it.hasNext()) {
            Integer i = it.next();
            if(i < 10) {
/*
                it.remove();  // 删除小于 10 的元素
*/
                numbers.add(i+1);
                System.out.println(numbers);
            }
        }
        System.out.println(numbers);
    }
}
