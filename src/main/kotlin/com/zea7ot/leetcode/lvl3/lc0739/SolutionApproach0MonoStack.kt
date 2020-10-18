/**
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Time Complexity:     O(`totalT`)
 * Space Complexity:    O(`totalT`)
 *
 * to maintain a "non-increasing" stack
 * 1. the elements of the stack are indexes, instead of values
 * 2. the values in the given array, accessed by those indexes, are in non-increasing order
 */
package com.zea7ot.leetcode.lvl3.lc0739

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    class Solution {
        fun dailyTemperatures(T: IntArray): IntArray {

            val totalT = T.size
            val stack = LinkedList<Int>()

            val ans = IntArray(totalT) { 0 }

            var idx = 0
            while (idx < totalT) {
                while (stack.isNotEmpty() && T[idx] > T[stack.peek()]) {
                    val prevIdx = stack.pop()
                    ans[prevIdx] = (idx - prevIdx)
                }

                stack.push(idx)
                ++idx
            }

            // ba values, this can be omitted
            while (stack.isNotEmpty()) {
                ans[stack.pop()] = 0
            }

            return ans
        }
    }
}