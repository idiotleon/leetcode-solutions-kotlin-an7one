package com.idiotleon.leetcode.lvl3.lc0169

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/majority-element/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * the description of the problem guarantees that there always will be a majority element
 *
 * Reference:
 * https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
 */
@Suppress(UNUSED)
class SolutionApproach1LinearScan {
    fun majorityElement(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) {
            return 0
        }

        val nNums = nums.size
        val numToFreq = HashMap<Int, Int>(nNums)

        for (num in nums) {
            numToFreq[num] = 1 + (numToFreq[num] ?: 0)
            if (numToFreq[num]!! > nNums / 2) {
                return num
            }
        }

        return Int.MAX_VALUE
    }
}