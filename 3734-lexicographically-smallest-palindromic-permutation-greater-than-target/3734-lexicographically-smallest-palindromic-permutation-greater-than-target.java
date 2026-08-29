class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int half = n / 2;

        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // Check palindrome possibility
        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1)
            return "";

        // Number of characters available in left half
        int[] halfCnt = new int[26];

        for (int i = 0; i < 26; i++) {
            halfCnt[i] = cnt[i] / 2;
        }

        /*
         * First try to make LEFT exactly equal
         * to target's first half.
         */
        char[] left = new char[half];

        int i = 0;

        while (i < half) {
            int c = target.charAt(i) - 'a';

            if (halfCnt[c] == 0)
                break;

            left[i] = (char) ('a' + c);
            halfCnt[c]--;
            i++;
        }

        /*
         * Case 1:
         * We matched the whole left half.
         */
        if (i == half) {

            String ans = build(left, mid);

            if (ans.compareTo(target) > 0)
                return ans;

            /*
             * Need to increase some previous character.
             */
            for (i = half - 1; i >= 0; i--) {

                int cur = left[i] - 'a';
                halfCnt[cur]++;

                for (int c = cur + 1; c < 26; c++) {

                    if (halfCnt[c] > 0) {

                        left[i] = (char) ('a' + c);
                        halfCnt[c]--;

                        fillSmallest(left, i + 1, halfCnt);

                        return build(left, mid);
                    }
                }
            }

            return "";
        }

        /*
         * Case 2:
         * We couldn't match target at position i.
         *
         * Try the smallest character greater than target[i].
         */
        int need = target.charAt(i) - 'a';

        for (int c = need + 1; c < 26; c++) {

            if (halfCnt[c] > 0) {

                left[i] = (char) ('a' + c);
                halfCnt[c]--;

                fillSmallest(left, i + 1, halfCnt);

                return build(left, mid);
            }
        }

        /*
         * No greater character at this position.
         * Backtrack.
         */
        for (i = i - 1; i >= 0; i--) {

            int cur = left[i] - 'a';
            halfCnt[cur]++;

            for (int c = cur + 1; c < 26; c++) {

                if (halfCnt[c] > 0) {

                    left[i] = (char) ('a' + c);
                    halfCnt[c]--;

                    fillSmallest(left, i + 1, halfCnt);

                    return build(left, mid);
                }
            }
        }

        return "";
    }

    private void fillSmallest(
            char[] left,
            int start,
            int[] cnt
    ) {
        int idx = start;

        for (int c = 0; c < 26; c++) {
            while (cnt[c] > 0) {
                left[idx++] = (char) ('a' + c);
                cnt[c]--;
            }
        }
    }

    private String build(char[] left, char mid) {

        StringBuilder ans = new StringBuilder();

        // Left
        for (char c : left) {
            ans.append(c);
        }

        // Middle
        if (mid != 0) {
            ans.append(mid);
        }

        // Right
        for (int i = left.length - 1; i >= 0; i--) {
            ans.append(left[i]);
        }

        return ans.toString();
    }
}