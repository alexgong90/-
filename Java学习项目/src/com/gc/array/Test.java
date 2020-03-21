package com.gc.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        a();
        /*try {
            new Object().wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
   private static void a() {
       int[] arr = {1,2,3,4,5,6,7};
       int step = 1;
       int value = 0;
       for (int i = 0; i < arr.length; i++) {
           if (value == step) {
               System.out.println(i);
               step ++;
               value = 0;
           }
           value++;
           System.out.println(arr[i]);

       }
   }
    private static int[] getTop2SubArray(int[] array) {
        //O(n)
        List<Integer> indexOfSubArray = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int maxSize = 0;
        int secMaxSize = 0;
        int top1Index = 0;
        int top2Index = 0;
        int minIndex = 0;
        int maxIndex = 0;
        int lastElement = Integer.MIN_VALUE;
        int top1max = Integer.MIN_VALUE;
        int top2max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                lastElement = array[i];
                continue;
            }
            int element = array[i];


            if (element < lastElement) {
                map.put(list1.size(), list1);
                list1.clear();
                if (list1.size() < maxSize && list1.size() > secMaxSize) {
                    list2.clear();
                    list2.addAll(list1);
                    secMaxSize = list2.size();
                }

                if (list1.size() > maxSize) {
                    maxSize = list1.size();
                }
            }
            list1.add(element);
            lastElement = element;
        }
        System.out.println("list2 = " + list2.toString());
        System.out.println("map = " + map.toString());



        top2Index = findTop2Sub(array, indexOfSubArray);
        int startIndex,endIndex;
        startIndex = top2Index;

        int indexOfIndex = indexOfSubArray.indexOf(top2Index)+1;
        if (indexOfIndex >= indexOfSubArray.size()) {
            endIndex = array.length;
        } else {
            endIndex = indexOfSubArray.get(indexOfIndex);
        }
        System.out.println("indexOfIndex = "+indexOfIndex + "indexOfSubArray = "+ indexOfSubArray.toString());

        System.out.println("startIndex = "+startIndex + "endIndex = "+ endIndex);

        int[] result = new int[endIndex - startIndex];
        int index = 0;
        for (int i = startIndex; i < endIndex; i++) {
            result[index++] = array[i];
        }

        return result;
    }

    private static int findTop2Sub(int[] array, List<Integer> indexOfSubArray) {
        System.out.println(indexOfSubArray.toString());
        int cur,next;
        int topSize;
        int top2Index,top1Index;
        top1Index = top2Index = 0;
        topSize = 0;
        for (int i = 0; i < indexOfSubArray.size(); i++) {
            cur = indexOfSubArray.get(i);
            if (i + 1 < indexOfSubArray.size()) {
                next = indexOfSubArray.get(i + 1);
            } else {
                next = array.length -1;
            }
            int size = next - cur;
            System.out.println(
                    "next = "+next +
                            " cur = "+ cur +
                            " size" +size +
                            " topSize"+topSize);

            if (size > topSize) {
                topSize = size;
                top2Index = top1Index;
                top1Index = i;
            }
        }
        System.out.println("top2Index"+top2Index);
        return top2Index;
    }
}
