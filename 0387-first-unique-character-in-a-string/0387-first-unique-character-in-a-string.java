class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hs = new HashMap<>();
        
        for ( int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hs.put(ch , hs.getOrDefault(ch, 0)+1);

        }
    for (int i=0; i<s.length(); i++){
        char ch = s.charAt(i);
        if(hs.get(ch) == 1){
            return i;
        }
    }
    return -1;
    }
}