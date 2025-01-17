package com.idiotleon.summary.byAlgorithm.sort.quickSort.quickSelect

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.random.Random

/**
 * @author: Leon
 *
 * Time Complexity:
 *  Best:       O(`nNums`)
 *  Average:    O(`nNums`)
 *  Worst:      O(`nNums` ^ 2)
 *
 * `k` is 0-indexed
 */
@Suppress(UNUSED)
class QuickSelectWithRandomPivot {
    fun quickSelect(lo: Int, hi: Int, k: Int, nums: IntArray): Int {
        if (lo <= hi) {
            val pivot = partition(lo, hi, nums)
            return when {
                // to go left/low
                pivot > k -> quickSelect(lo, pivot - 1, k, nums)
                // to go right/high
                pivot < k -> quickSelect(pivot + 1, hi, k, nums)
                else -> nums[k]
            }
        }

        return Int.MIN_VALUE
    }

    private fun partition(lo: Int, hi: Int, nums: IntArray): Int {
        val idxPivot = lo + Random.nextInt(hi - lo + 1)
        swap(idxPivot, hi, nums)

        var idxStart = lo
        for (idx in idxStart until hi) {
            if (nums[idx] > nums[hi]) {
                swap(idxStart, idx, nums)
                ++idxStart
            }
        }

        swap(idxStart, hi, nums)
        return idxStart
    }

    private fun swap(i: Int, j: Int, nums: IntArray) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}