public class Solution {
    public String numberToWords(int num) {
        if(num == 0)    return "Zero";
        return helper(num).trim();
    }

    private String helper(int num){

        if(num >= 1000000000 ){
            return helper(num / 1000000000) + " Billion" + helper(num % 1000000000);
        }
        else if(num >= 1000000){
            return helper(num / 1000000) + " Million" + helper(num % 1000000);
        }
        else if(num >= 1000){
            return helper(num / 1000) + " Thousand" + helper(num % 1000);
        }
        else if(num >= 100){
            return helper(num / 100) + " Hundred" + helper(num % 100);
        }
        else if(num >= 10){
            if(num >= 20){
                int x = num / 10;
                switch (x){
                    case 9:
                        return " Ninety" + helper(num % 10);
                    case 8:
                        return " Eighty" + helper(num % 10);
                    case 7:
                        return " Seventy" + helper(num % 10);
                    case 6:
                        return " Sixty" + helper(num % 10);
                    case 5:
                        return " Fifty" + helper(num % 10);
                    case 4:
                        return " Forty" + helper(num % 10);
                    case 3:
                        return " Thirty" + helper(num % 10);
                    case 2:
                        return " Twenty" + helper(num % 10);
                }
            }
            else{
                int x = num % 10;
                switch (x){
                    case 9:
                        return " Nineteen";
                    case 8:
                        return " Eighteen";
                    case 7:
                        return " Seventeen";
                    case 6:
                        return " Sixteen";
                    case 5:
                        return " Fifteen";
                    case 4:
                        return " Fourteen";
                    case 3:
                        return " Thirteen";
                    case 2:
                        return " Twelve";
                    case 1:
                        return " Eleven";
                    case 0:
                        return " Ten";
                }
            }
        }
        else{
            int x = num % 10;
            switch (x){
                case 9:
                    return " Nine";
                case 8:
                    return " Eight";
                case 7:
                    return " Seven";
                case 6:
                    return " Six";
                case 5:
                    return " Five";
                case 4:
                    return " Four";
                case 3:
                    return " Three";
                case 2:
                    return " Two";
                case 1:
                    return " One";
                case 0:
                    return "";
            }
        }
        return "";
    }
}
