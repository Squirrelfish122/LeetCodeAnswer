package com.hyman.zhh.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hyman.zhh at 2020/5.
 * <p>
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution3 {


    /**
     * 方法一：滑动窗口
     * 思路和算法
     * <p>
     * 我们先用一个例子来想一想如何在较优的时间复杂度内通过本题。
     * <p>
     * 我们不妨以示例一中的字符串 abcabcbb 为例，找出从每一个字符开始的，不包含重复字符的最长子串，那么其中最长的那个字符串即为答案。
     * 对于示例一中的字符串，我们列举出这些结果，其中括号中表示选中的字符以及最长的字符串：
     * <p>
     * 以 (a)bcabcbb 开始的最长字符串为 (abc)abcbb；
     * 以 a(b)cabcbb 开始的最长字符串为 a(bca)bcbb；
     * 以 ab(c)abcbb 开始的最长字符串为 ab(cab)cbb；
     * 以 abc(a)bcbb 开始的最长字符串为 abc(abc)bb；
     * 以 abca(b)cbb 开始的最长字符串为 abca(bc)bb；
     * 以 abcab(c)bb 开始的最长字符串为 abcab(cb)b；
     * 以 abcabc(b)b 开始的最长字符串为 abcabc(b)b；
     * 以 abcabcb(b) 开始的最长字符串为 abcabcb(b)。
     * <p>
     * 发现了什么？如果我们依次递增地枚举子串的起始位置，那么子串的结束位置也是递增的！这里的原因在于，假设我们选择字符串中的第 k 个字符作为
     * 起始位置，并且得到了不包含重复字符的最长子串的结束位置为 r_k。那么当我们选择第 k+1 个字符作为起始位置时，首先从 k+1 到 r_k的字符
     * 显然是不重复的，并且由于少了原本的第 k 个字符，我们可以尝试继续增大 r_k，直到右侧出现了重复字符为止。
     * <p>
     * 这样以来，我们就可以使用「滑动窗口」来解决这个问题了：
     * <p>
     * 我们使用两个指针表示字符串中的某个子串（的左右边界）。其中左指针代表着上文中「枚举子串的起始位置」，而右指针即为上文中的 r_k；
     * <p>
     * 在每一步的操作中，我们会将左指针向右移动一格，表示 我们开始枚举下一个字符作为起始位置，然后我们可以不断地向右移动右指针，但需要保证这两个指针
     * 对应的子串中没有重复的字符。在移动结束后，这个子串就对应着 以左指针开始的，不包含重复字符的最长子串。我们记录下这个子串的长度；
     * <p>
     * 在枚举结束后，我们找到的最长的子串的长度即为答案。
     * <p>
     * 判断重复字符
     * <p>
     * 在上面的流程中，我们还需要使用一种数据结构来判断 是否有重复的字符，常用的数据结构为哈希集合（即Java 中的 HashSet）。在左指针向右移动的
     * 时候，我们从哈希集合中移除一个字符，在右指针向右移动的时候，我们往哈希集合中添加一个字符。
     * <p>
     * 至此，我们就完美解决了本题。
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(N)，其中 N 是字符串的长度。左指针和右指针分别会遍历整个字符串一次。
     * <p>
     * 空间复杂度：O(∣Σ∣)，其中 Σ 表示字符集（即字符串中可以出现的字符），∣Σ∣ 表示字符集的大小。在本题中没有明确说明字符集，因此可以默认为
     * 所有 ASCII 码在 [0, 128)内的字符，即 ∣Σ∣=128。我们需要用到哈希集合来存储出现过的字符，而字符最多有 ∣Σ∣ 个，因此空间复杂度为 O(∣Σ∣)。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int result = 1;
        int rIndex = 1;
        set.add(s.charAt(0));
        for (int i = 0; i < n; i++) {
            while (rIndex < n && !set.contains(s.charAt(rIndex))) {
                set.add(s.charAt(rIndex));
                rIndex++;
            }
            result = Math.max(result, rIndex - i);
            set.remove(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abcabcbb"));
    }
}
