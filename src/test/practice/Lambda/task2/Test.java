package test.practice.Lambda.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static test.practice.Thread.task.Thread3.list;

public class Test {
    public static void main(String[] args) {

        //map
        int [] arr1 = new int[10];
        List<Integer> list1 = new ArrayList<>();
        fillArr(arr1);
        fillList(list1);
        System.out.println(list1);
        System.out.println(Arrays.toString(arr1));
        arr1 = Arrays.stream(arr1).map(a -> a*2).toArray();
        list1 =  list1.stream().map(a -> a*2).collect(Collectors.toList());
        System.out.println(list1);
        System.out.println(Arrays.toString(arr1));

        //filter
        int [] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();
        fillArr(arr2);
        fillList(list2);
        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a % 2 == 0).toList();
        System.out.println(list2);
        System.out.println(Arrays.toString(arr2));

        //foreach
        int [] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();
        fillArr(arr3);
        fillList(list3);
        Arrays.stream(arr3).forEach(System.out::println);
        list3.forEach(System.out::println);
        System.out.println(list3);
        System.out.println(Arrays.toString(arr3));

        //reduce
        int [] arr4 = new int[10];
        List<Integer> list4 = new ArrayList<>();
        fillArr(arr4);
        fillList(list4);
        int sum = Arrays.stream(arr4).reduce(Integer::sum).getAsInt();
        String sum2 = list.stream().reduce((acc, b) -> acc + b).get();
        System.out.println(sum);
        System.out.println(sum2);
    }
    private static  void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i+1;
        }
    }
    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i+1);
        }
    }
}
