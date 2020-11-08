/**
 * https://leetcode.com/problems/custom-sort-string/
 *
 * Time Complexity:     O(`lenT`)
 * Space Complexity:    O(`lenT`)
 *
 * References:
 *  https://leetcode.com/problems/custom-sort-string/discuss/116615/JavaPython-3-one-Java-10-liner-Python-6-liner-and-2-liner-solutions-w-comment
 */
package com.zea7ot.leetcode.lvl2.lc0791

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0CountingSort {
    fun customSortString(S: String, T: String): String {
        // not used
        // val lenT = T.length

        val freqs = IntArray(26) { 0 }
        for (ch in T) ++freqs[ch - 'a']

        val builder = StringBuilder()
        for (ch in S) {
            while (--freqs[ch - 'a'] >= 0) {
                builder.append(ch)
            }
        }

        for (ch in 'a'..'z') {
            while (--freqs[ch - 'a'] >= 0) {
                builder.append(ch)
            }
        }

        return builder.toString()
    }
}