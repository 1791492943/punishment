package com.punishment;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<Long> longs = new ArrayList<>();
        longs.add(1L);
        longs.add(2L);
        longs.add(3L);
        List<Long> longs1 = generateCombinations(longs);
        System.out.println(longs1);
    }
    private static List<Long> generateCombinations(List<Long> nums) {
        List<Long> result = new ArrayList<>();
        generate(nums, 0, 0L, result);
        return result;
    }

    private static void generate(List<Long> nums, Integer index, Long current, List<Long> result) {
        if (index == nums.size()) {
            if (current != 0) {
                result.add(current);
            }
            return;
        }

        // 不包含当前数字的情况
        generate(nums, index + 1, current, result);

        // 包含当前数字的情况
        generate(nums, index + 1, current * 10 + nums.get(index), result);
    }
}
