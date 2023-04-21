package ru.vvikhlyaev.leet.solutions.completed;

import java.util.*;

/**
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.
 *
 * There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 *
 * Implement the ru.vvikhlyaev.leet.solutions.completed.Solution class:
 *
 * ru.vvikhlyaev.leet.solutions.completed.Solution() Initializes the object of the system.
 * String encode(String longUrl) Returns a tiny URL for the given longUrl.
 * String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.
 *
 *
 * Example 1:
 *
 * Input: url = "https://leetcode.com/problems/design-tinyurl"
 * Output: "https://leetcode.com/problems/design-tinyurl"
 *
 * Explanation:
 * ru.vvikhlyaev.leet.solutions.completed.Solution obj = new ru.vvikhlyaev.leet.solutions.completed.Solution();
 * string tiny = obj.encode(url); // returns the encoded tiny url.
 * string ans = obj.decode(tiny); // returns the original url after decoding it.
 *
 *
 * Constraints:
 *
 * 1 <= url.length <= 104
 * url is guranteed to be a valid URL.
 */
public class Solution0535 {
    private static final Map<String, String> cache = new HashMap<>();
    private static final Random random = new Random();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (true) {
            String tiny = getTiny();
            if (!cache.containsKey(tiny)) {
                cache.put(tiny, longUrl);
                return tiny;
            }
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return cache.get(shortUrl);
    }

    private static String getTinyurlTemplate() {
        return "http://example.com/%s";
    }

    private static String getTiny() {
        char[] chars = new char[5];
        for (int i = 0; i < 5; i++)
            chars[i] = (char) random.nextInt(128);
        return getTinyurlTemplate().formatted(Arrays.toString(chars));
    }

    public static void main(String[] args) {
        check("https://leetcode.com/problems/design-tinyurl");
    }

    private static void check(String val) {
        Solution0535 codec = new Solution0535();
        String shortUrl = codec.encode(val);
        String decodedUrl = codec.decode(shortUrl);
        if (!val.equals(decodedUrl)) {
            System.out.println("val = " + val);
            System.out.println("shortUrl = " + shortUrl);
            System.out.println("decodedUrl = " + decodedUrl);
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
