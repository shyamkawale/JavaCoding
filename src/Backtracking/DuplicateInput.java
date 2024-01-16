package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class DuplicateInput {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> Output_UniqueSet_RepetitionAllowed(int[] arr, int index, int target, List<Integer> list){
        if(target == 0 && !res.contains(list)){
            res.add(new ArrayList<>(list));
        }
        if(target <= 0){
            return res;
        }
        for(int i=index; i<arr.length; i++) {
                list.add(arr[i]);
                Output_UniqueSet_RepetitionAllowed(arr, i, target-arr[i], list);
                list.removeLast();
        }
        return res;
    }

    public List<List<Integer>> Output_UniqueSet_RepetitionNotAllowed(int[] arr, int index, int target, List<Integer> list) {
        if(target == 0 && !res.contains(list)){
            res.add(new ArrayList<>(list));
        }
        if(target <= 0){
            return res;
        }
        for(int i=index; i<arr.length; i++) {
            if(!list.contains(arr[i])) {
                list.add(arr[i]);
                Output_UniqueSet_RepetitionNotAllowed(arr, i, target - arr[i], list);
                list.removeLast();
            }
        }
        return res;
    }

    public List<List<Integer>> Output_DuplicateSet_RepetitionAllowed(int[] arr, int target, List<Integer> list) {
        if(target == 0 && !res.contains(list)){
            res.add(new ArrayList<>(list));
        }
        if(target <= 0){
            return res;
        }
        for(int i=0; i<arr.length; i++) {
                list.add(arr[i]);
                Output_DuplicateSet_RepetitionAllowed(arr, target - arr[i], list);
                list.removeLast();
        }
        return res;
    }

    public List<List<Integer>> Output_DuplicateSet_RepetitionNotAllowed(int[] arr, int target, List<Integer> list) {
        if(target == 0 && !res.contains(list)){
            res.add(new ArrayList<>(list));
        }
        if(target <= 0){
            return res;
        }
        for(int i=0; i<arr.length; i++) {
            if(!list.contains(arr[i])) {
                list.add(arr[i]);
                Output_DuplicateSet_RepetitionNotAllowed(arr,target - arr[i], list);
                list.removeLast();
            }
        }
        return res;
    }

    // not correct result
    public List<List<Integer>> Output_Permutations(int[] arr, int index, List<Integer> list) {
        if(index == arr.length - 1 && !res.contains(list)){
            res.add(new ArrayList<>(list));
        }
        if(index >= arr.length - 1){
            return res;
        }
        for(int i=0; i<arr.length; i++){
            if(!list.contains(arr[i])) {
                list.add(arr[i]);
                Output_Permutations(arr, i, list);
                list.removeLast();
            }
        }
        return res;
    }

    public List<List<Integer>> Output_Subsets(int[] arr, int index, List<Integer> list) {
        if(index >= arr.length - 1){
            return res;
        }
        for(int i=0; i<arr.length; i++){
            if(!list.contains(arr[i])) {
                list.add(arr[i]);
                if(!res.contains(list)) {
                    res.add(new ArrayList<>(list));
                }
                Output_Subsets(arr, i, list);
                list.removeLast();
            }
        }
        return res;
    }
}
