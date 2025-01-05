package Comparator;

import java.util.*;

public class Comparator {
    public static void main(String[] args) {
        Integer[] arr1 = {1,4,3,2,5};
        sortIntegerArray(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr = {3,4,2,1,5};
        sortIntArray(arr);
        System.out.println(Arrays.toString(arr));

        Character[] charr = {'a', 'c', 'd', 'b'};
        sortCharArray(charr);
        System.out.println(Arrays.toString(charr));

        int[][] matrix = {{1,2}, {4,5}, {3,1}, {3,4}};
        sortMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));

        List<Integer> list = Arrays.asList(3,2,1);
        sortList(list);
        System.out.println(list);

        // does not maintain order
        Map<Integer, String> map = new HashMap<>(){{
            put(2, "Two");
            put(1, "One");
        }};
        System.out.println(map);

        //does not maintain order
        Set<Integer> set = new HashSet<>(Arrays.asList(1,3,2));
        System.out.println(set);

        String str = "hello-world";
        sortString(str);


    }

    private static void sortString(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
    }

    private static void sortCharArray(Character[] charr) {
        Arrays.sort(charr, new java.util.Comparator<Character>(){
            @Override
            public int compare(Character c1, Character c2) {
                return c1-c2;
            }
        });
    }

    private static void sortIntegerArray(Integer[] arr) {
        Arrays.sort(arr, new java.util.Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
    }

    private static void sortIntArray(int[] arr) {
        Arrays.sort(arr);
    }

    private static void sortList(List<Integer> list) {
        Collections.sort(list, new java.util.Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
    }

    private static void sortMatrix(int[][] matrix) {
        Arrays.sort(matrix, new java.util.Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
    }
}
