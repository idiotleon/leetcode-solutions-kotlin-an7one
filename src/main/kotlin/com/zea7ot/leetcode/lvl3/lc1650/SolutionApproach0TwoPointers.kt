/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/discuss/932914/Java-in-6-lines
 */
package com.zea7ot.leetcode.lvl3.lc1650

class SolutionApproach0TwoPointers {
    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
        var curP = p
        var curQ = q

        while (curP != curQ) {
            curP = if (curP == null) q else curP.parent
            curQ = if (curQ == null) p else curQ.parent
        }

        return curP
    }
}