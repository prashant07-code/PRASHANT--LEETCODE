
class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        String vowels = "";
        for (int i = 0; i < arr.length; i++) {
            if ("aeiouAEIOU".indexOf(arr[i]) != -1) {
                vowels += arr[i];
            }
        }
        int j = vowels.length() - 1;

        for (int i = 0; i < arr.length; i++) {
            if ("aeiouAEIOU".indexOf(arr[i]) != -1) {
                arr[i] = vowels.charAt(j);
                j--;
            }
        }

        return new String(arr);
    }
}
