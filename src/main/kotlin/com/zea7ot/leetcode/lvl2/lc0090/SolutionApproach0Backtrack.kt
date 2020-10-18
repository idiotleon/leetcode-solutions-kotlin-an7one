/**
 * https://leetcode.com/problems/subsets-ii/
 *
 * Time Complexity:     O(N * 2 ^ N) + O(N * lg(N)) ~ O(N * 2 ^ 2)
 *  `ans.add(new ArrayList<Integer>(intermediate));` is of O(N)
 *
 * Space Complexity:    O(N *  (2 ^ N))
 *
 * References:
 *  https://medium.com/@vasanths294/permutation-combination-subset-time-complexity-eca924e00071
 */
package com.zea7ot.leetcode.lvl2.lc0090

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val paths: MutableList<MutableList<Int>> = arrayListOf()
        // sanity check
        if (nums.isEmpty()) return paths

        nums.sort()
        val path = arrayListOf<Int>()

        backtrack(0, path, nums, paths)

        return paths
    }

    private fun backtrack(startIdx: Int,
                          path: MutableList<Int>,
                          nums: IntArray,
                          paths: MutableList<MutableList<Int>>) {
        val sizeN = nums.size
        paths.add(path.toMutableList())

        for (i in startIdx until sizeN) {
            if (i != startIdx && nums[i - 1] == nums[i]) continue
            path.add(nums[i])
            backtrack(i + 1, path, nums, paths)
            path.remove(path.last())
        }
    }
}