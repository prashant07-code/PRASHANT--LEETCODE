class Solution {
    public int[] separateDigits(int[] nums) {
        int count = 0;

        for (int num : nums) {
            count += String.valueOf(num).length();
        }

        int[] result = new int[count];
        int index = 0;

        for (int num : nums) {
            String str = String.valueOf(num);

            for (int i = 0; i < str.length(); i++) {
                result[index] = str.charAt(i) - '0';
                index++;
            }
        }

        return result;
    }
}