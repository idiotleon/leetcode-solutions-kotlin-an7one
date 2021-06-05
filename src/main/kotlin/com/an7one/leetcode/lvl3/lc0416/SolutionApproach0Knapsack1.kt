/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Time Complexity:     O(`nNums` * `sumAll`)
 * Space Complexity:    O(`sumAll`)
 *
 * the characteristic of Knapsack problems is that
 *  its time and space complexity is highly related
 *  to the range, in this case the "volume", of the actual problem
 *
 * References:
 *  https://youtu.be/r6I-ikllNDM
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-416-partition-equal-subset-sum/
 */
package com.an7one.leetcode.lvl3.lc0416

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Knapsack1 {
    fun canPartition(nums: IntArray): Boolean {
        // not used
        // val nNums = nums.size

        val sumAll = nums.sum()
        if (sumAll % 2 == 1) return false

        val dp = BooleanArray(sumAll + 1) { idx -> idx == 0 }

        for (num in nums) {
            for (sum in sumAll downTo 0) {
                if (dp[sum]) {
                    dp[num + sum] = true
                }
            }

            if (dp[sumAll / 2]) return true
        }

        return false
    }
}