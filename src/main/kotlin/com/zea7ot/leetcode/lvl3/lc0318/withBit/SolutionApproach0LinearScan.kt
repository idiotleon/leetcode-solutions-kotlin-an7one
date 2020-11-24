/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 *
 * Time Complexity:     O(`nWords` ^ 2)
 * Space Complexity:    O(`nWords`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-product-of-word-lengths/discuss/76959/JAVA-Easy-Version-To-Understand!!!!!!!!!!!!!!!!!/80790
 */
package com.zea7ot.leetcode.lvl3.lc0318.withBit

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun maxProduct(words: Array<String>): Int {
        val nWords = words.size

        val set = IntArray(nWords) { 0 }
        for (idx in words.indices) {
            for (ch in words[idx]) {
                set[idx] = set[idx] or (1 shl (ch - 'a'))
            }
        }

        var max = 0
        for (lo in words.indices) {
            for (hi in lo + 1 until nWords) {
                if ((set[lo] and set[hi]) == 0) {
                    max = maxOf(max, words[lo].length * words[hi].length)
                }
            }
        }

        return max
    }
}