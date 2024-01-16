package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {
    public static void main(String[] args) {
        int[] distinctNums = {2, 3, 4};
        int[] duplicateNums = {4, 2, 3, 2, 3};
        int target = 7;

        System.out.println("*** Input: DISTINCT numbers ***");
        executeDistinctInputMethods(distinctNums, target);

        System.out.println("*** Input: Duplicate numbers ***");
        executeDuplicateInputMethods(duplicateNums, target);
    }

    private static void executeDuplicateInputMethods(int[] duplicateNums, int target) {
        DuplicateInput obj = new DuplicateInput();

        System.out.println("1) Output: Unique Set with Repetition Allowed: ");
        int[] arr1 = duplicateNums.clone();
        Arrays.sort(arr1);
        List<List<Integer>> res1 = obj.Output_UniqueSet_RepetitionAllowed(arr1, 0, target, new ArrayList<>());
        System.out.println(res1);
        System.out.println();

        obj.res.clear();

        System.out.println("2) Output: Unique Set with Repetition Not Allowed: ");
        int[] arr2 = duplicateNums.clone();
        Arrays.sort(arr2);
        List<List<Integer>> res2 = obj.Output_UniqueSet_RepetitionNotAllowed(arr2, 0, target, new ArrayList<>());
        System.out.println(res2);
        System.out.println();

        obj.res.clear();

        System.out.println("3) Output: Duplicate Set with Repetition Allowed: ");
        List<List<Integer>> res3 = obj.Output_DuplicateSet_RepetitionAllowed(duplicateNums, target, new ArrayList<>());
        System.out.println(res3);
        System.out.println();

        obj.res.clear();

        System.out.println("4) Output: Duplicate Set with Repetition Not Allowed: ");
        List<List<Integer>> res4 = obj.Output_DuplicateSet_RepetitionNotAllowed(duplicateNums, target, new ArrayList<>());
        System.out.println(res4);
        System.out.println();

        obj.res.clear();

        System.out.println("5) Output: Permutations: ");
        int[] arr5 = duplicateNums.clone();
        Arrays.sort(arr5);
        List<List<Integer>> res5 = obj.Output_Permutations(arr5, 0, new ArrayList<>());
        System.out.println(res5);
        System.out.println();

        obj.res.clear();

        System.out.println("6) Output: Subsets: ");
        List<List<Integer>> res6 = obj.Output_Subsets(duplicateNums, 0, new ArrayList<>());
        System.out.println(res6);
        System.out.println();

        obj.res.clear();

    }

    public static void executeDistinctInputMethods(int[] distinctNums, int target){
        DistinctInput obj = new DistinctInput();

        System.out.println("1) Output: Unique Set with Repetition Allowed: ");
        List<List<Integer>> res1 = obj.Output_UniqueSet_RepetitionAllowed(distinctNums, 0, target, new ArrayList<>());
        System.out.println(res1);
        System.out.println();

        obj.res.clear();

        System.out.println("2) Output: Unique Set with Repetition Not Allowed: ");
        List<List<Integer>> res2 = obj.Output_UniqueSet_RepetitionNotAllowed(distinctNums, 0, target, new ArrayList<>());
        System.out.println(res2);
        System.out.println();

        obj.res.clear();

        System.out.println("3) Output: Duplicate Set with Repetition Allowed: ");
        List<List<Integer>> res3 = obj.Output_DuplicateSet_RepetitionAllowed(distinctNums, target, new ArrayList<>());
        System.out.println(res3);
        System.out.println();

        obj.res.clear();

        System.out.println("4) Output: Duplicate Set with Repetition Not Allowed: ");
        List<List<Integer>> res4 = obj.Output_DuplicateSet_RepetitionNotAllowed(distinctNums, target, new ArrayList<>());
        System.out.println(res4);
        System.out.println();

        obj.res.clear();

        System.out.println("5) Output: Permutations: ");
        List<List<Integer>> res5 = obj.Output_Permutations(distinctNums, new ArrayList<>());
        System.out.println(res5);
        System.out.println();

        obj.res.clear();

        System.out.println("6) Output: Subsets: ");
        List<List<Integer>> res6 = obj.Output_Subsets(distinctNums, new ArrayList<>());
        System.out.println(res6);
        System.out.println();

        obj.res.clear();

    }
}
