package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsequence(int index, List<Integer> output, List<Integer> input) {
        if (index == input.size()) {
            return new ArrayList<>(List.of(new ArrayList<>(output)));
        }
        output.add(input.get(index));
        List<List<Integer>> subsequences = subsequence(index + 1, output, input);
        output.remove(output.size() - 1);
        subsequences.addAll(subsequence(index + 1, output, input));
        return subsequences;
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(3, 1, 2);
        List<Integer> output = new ArrayList<>();
        Solution solution = new Solution();
        List<List<Integer>> result = solution.subsequence(0, output, input);
        System.out.println(result);
    }
}

