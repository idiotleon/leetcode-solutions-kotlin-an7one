package com.idiotleon.leetcode.lvl2.lc0199

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
@Suppress(UNUSED)
class Solution0Bfs {
    fun rightSideView(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        if (root == null) {
            return ans
        }

        val queue = ArrayDeque<TreeNode>().also {
            it.addLast(root)
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()

                val value = cur.`val`

                if (sz == size - 1) {
                    ans.add(value)
                }

                cur.left?.let { queue.addLast(it) }
                cur.right?.let { queue.addLast(it) }
            }
        }

        return ans
    }
}