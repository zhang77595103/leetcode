public class Solution {
    public String getHint(String secret, String guess) {
        int sec[] = new int[10];
        int gue[] = new int[10];
        int buffs = 0;
        int cows = 0;
        int len = secret.length();
        int i = 0;
        

        while(i < len){
            boolean flag1 = false, flag2 = false;
            if(secret.charAt(i) == guess.charAt(i)){
                buffs++;
            }
            else{
                if(sec[guess.charAt(i) - '0'] != 0) {
                    sec[guess.charAt(i) - '0']--;
                    flag1 = true;
                    cows++;
                }
                if(gue[secret.charAt(i) - '0'] != 0 ) {
                    gue[secret.charAt(i) - '0']--;
                    flag2 = true;
                    cows++;
                }
                    if(!flag1) gue[guess.charAt(i) - '0']++;
                    if(!flag2) sec[secret.charAt(i) - '0']++;
            }
            i++;
        }
        String re = "" + buffs + "A" + cows + "B";
        return re;
    }
}
