class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = n - 1; i >= 0; i--) {

            int[] cnt = freq.clone();
            boolean ok = true;

            // Build prefix equal to target
            for (int j = 0; j < i; j++) {
                int idx = target.charAt(j) - 'a';
                cnt[idx]--;
                if (cnt[idx] < 0) {
                    ok = false;
                    break;
                }
            }

            if (!ok) continue;

            int cur = target.charAt(i) - 'a';

            // Find smallest greater character
            int bigger = -1;
            for (int c = cur + 1; c < 26; c++) {
                if (cnt[c] > 0) {
                    bigger = c;
                    break;
                }
            }

            if (bigger == -1) continue;

            StringBuilder ans = new StringBuilder();

            ans.append(target.substring(0, i));

            ans.append((char) ('a' + bigger));
            cnt[bigger]--;

            for (int c = 0; c < 26; c++) {
                while (cnt[c]-- > 0) {
                    ans.append((char) ('a' + c));
                }
            }

            return ans.toString();
        }

        return "";
    }
}