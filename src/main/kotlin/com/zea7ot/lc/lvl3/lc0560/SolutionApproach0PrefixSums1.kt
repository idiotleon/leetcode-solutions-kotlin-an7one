/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * References:
 *  https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-%2B-HashMap
 *  https://leetcode.com/problems/subarray-sum-equals-k/discuss/301242/General-summary-of-what-kind-of-problem-can-cannot-solved-by-Two-Pointers
 *
 *  about `preifxSums.put(0, 1)`;
 *  https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-+-HashMap/416171
 *  https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106/Java-Solution-PreSum-+-HashMap/238328
 */
package com.zea7ot.lc.lvl3.lc0560

import com.zea7ot.lc.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0PrefixSums1 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val prefixSums = hashMapOf(0 to 1)

        var count = 0
        var sum = 0

        for (num in nums) {
            sum += num

            prefixSums[sum - k]?.let { count += it }
            prefixSums[sum] = (prefixSums[sum] ?: 0) + 1
        }

        return count
    }
}