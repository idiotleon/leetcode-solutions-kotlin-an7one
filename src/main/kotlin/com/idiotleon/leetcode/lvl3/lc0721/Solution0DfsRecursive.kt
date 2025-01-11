package com.idiotleon.leetcode.lvl3.lc0721

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/accounts-merge/
 *
 * Time Complexity:     O(V + E) ~ O()
 * Space Complexity:    O(V + E) ~ O()
 *
 * Reference:
 * https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC++-Union-Find/241144
 */
@Suppress(UNUSED)
class Solution0DfsRecursive {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val graph = HashMap<String, HashSet<String>>()
        val emailToName = HashMap<String, String>()

        for (account in accounts) {
            val name = account[0]
            val size = account.size

            for (idx in 1 until size) {
                // required, especially in the situation where there is only one email after the name
                graph.getOrPut(account[idx]) { HashSet() }
                emailToName[account[idx]] = name

                if (idx > 1) {
                    val u = account[idx - 1]
                    val v = account[idx]
                    graph.getOrPut(u) { HashSet() }.add(v)
                    graph.getOrPut(v) { HashSet() }.add(u)
                }
            }
        }

        val ans = mutableListOf<List<String>>()
        val seen = HashSet<String>()
        for ((email, _) in graph) {
            if (!seen.add(email)) {
                continue
            }

            val res = mutableListOf<String>()
            dfs(email, seen, res, graph)
            res.sort()
            res.add(0, emailToName[res[0]]!!)
            ans.add(res)
        }

        return ans
    }

    private fun dfs(
        cur: String, seen: HashSet<String>, res: MutableList<String>, graph: HashMap<String, HashSet<String>>
    ) {
        res.add(cur)

        graph[cur]?.let {
            for (next in it) {
                if (!seen.add(next)) {
                    continue
                }
                dfs(next, seen, res, graph)
            }
        }
    }
}