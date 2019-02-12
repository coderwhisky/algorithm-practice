package org.buaa.nlp.cj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/11/3.
 */
public class _39_CombinationSum {
    private static List<List<Integer>> ser = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> tmpres = new ArrayList<Integer>();
        help(candidates, 0, target, tmpres);
        return ser;
    }
    public static void help(int[] candidates, final int index, final int target, List<Integer> tmpres) {
        if (target == 0) {
            ser.add(tmpres);
        }
        for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
            if (i == 0 || candidates[i] != candidates[i-1]) {
                tmpres.add(candidates[i]);
                help(candidates, i, target-candidates[i], tmpres);
                tmpres.remove(tmpres.size()-1);
            }
        }
    }
}
