package Recursion;

public class Basic {
    
    public static void main(String[] args){

        Basic basic = new Basic();
        //System.out.println(basic.printRec(2));
        String str = "abbcbba";
        // System.out.println(basic.checkPalind(str,0, str.length()-1));
        int num = 9987;
        System.out.println(basic.sumOfDigits(num));

        int ropeLength = 5;
        int a = 2;
        int b = 1;
        int c = 5;

        System.out.println(basic.findMaxRopeCuts(ropeLength,a,b,c));
    }

    int printRec(int n){
        if(n == 1)
            return n;

        return n + printRec(n-1);

    }

    boolean checkPalind(String str, int i, int j){

        if(str.length() == 0 || i > j )
            {
                return true;
            }
        if(str.charAt(i) != str.charAt(j)){
            return false;
        }else{
            return checkPalind(str,i+1,j-1);
        }
    }

    int sumOfDigits(int num){
        if(num < 10)
            return num;
        return num % 10 + sumOfDigits(num/10);
    }

    int findMaxRopeCuts(int len, int a, int b, int c){
        
        /*
        n = 5, a= 2, b = 3, c = 1 
        -----
        -- -- -
        --- --
        - - - - -
        */
        if(len <= 0){
            return 0;
        }

        findMaxRopeCuts(len-a, a, b, c);
        return 0;
    }
}
