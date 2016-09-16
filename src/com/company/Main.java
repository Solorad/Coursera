package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("QuickSort.txt"));
        List<Integer> list = new ArrayList<>();
        while(sc.hasNextLine()) {
            list.add(sc.nextInt());
        }
        long compareNum = quickSort(list, 0, list.size());
        System.out.println(compareNum);
    }

    private static long quickSort(List<Integer> list, int from, int to) {
        if (to <= from) {
            return 0;
        }
        long result = to - from - 1;
        int pivot = partitiate(list, from, to);
        result += quickSort(list, from, pivot);
        result += quickSort(list, pivot + 1, to);
        return result;
    }

    private static int partitiate(List<Integer> list, int from, int to) {
        Integer pivotValue = list.get(to - 1);
        int i = to - 1;
        for (int j = from; j < to; j++) {
            Integer curValue = list.get(j);
            if (curValue < pivotValue) {
                swap(list, i, j);
                i++;
            }
        }
        swap(list, from, i - 1);
        return i - 1;
    }

    private static void swap(List<Integer> list, int i, int j) {
        try {
            Integer tmp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, tmp);
        } catch (Exception e) {
            System.out.println("here");
        }
    }

    private static int getPivot(int from, int to) {
        return from;
    }
}
