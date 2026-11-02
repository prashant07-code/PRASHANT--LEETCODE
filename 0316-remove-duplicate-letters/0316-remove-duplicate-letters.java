class Solution {
    public String removeDuplicateLetters(String s) {
     int map [] = new int[26];
     int lastidx[] = new int [26];
     Stack <Character> st = new Stack<>();    
     for (int i=0; i<s.length(); i++){
        char current = s.charAt(i);
        lastidx[current -'a'] = i;
        }
       for (int i= 0; i<s.length(); i++){
         char current = s.charAt(i);
         if(map[current- 'a'] == 1){
            continue;
         }

          while (!st.isEmpty() && current < st.peek() && lastidx[st.peek() - 'a'] > i) {
                char removed = st.pop();
                map[removed - 'a'] = 0;
            }

            st.push(current);
            map[current - 'a'] = 1;
        }
            StringBuilder result = new StringBuilder();
           for (int i = 0; i < st.size(); i++) {
             result.append(st.get(i));
      }
        return result.toString();
       
    }
}