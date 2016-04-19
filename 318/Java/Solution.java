public class Solution {
    public int maxProduct(String[] words) {
        int[] map = new int[words.length];
        int counter = 0;
        /*
            construct the map
         */
        for(String each : words){
            int len = each.length();
            for(int i = 0; i < len; ++i){
                map[counter] |= 1 << (each.codePointAt(i) - 97);
            }
            counter++;
        }
        int re = 0;
        for(counter = 0; counter < words.length - 1; ++counter){
            for(int i = counter + 1; i < words.length; ++i){
                if((map[counter] & map[i]) != 0){
                    continue;
                }
                int temp = words[i].length() * words[counter].length();
                re = re >= temp ? re : temp;
            }
        }

        return re;
    }
}
