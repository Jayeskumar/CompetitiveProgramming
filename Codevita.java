import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
class Codechef3{
    public static boolean checkSameDigits(int n)
    {
        int length = ((int)Math.log10(n)) + 1;

        int m = ((int)Math.pow(10, length) - 1)
                / (10 - 1);
        m*= n % 10;


        if (m== n)
            return true;

        return false;
    }


    public static void main(String args[])
            throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int count = 0;
            for(int i = 1; i <= n; i++){
                if(checkSameDigits(i)){
                    count++;
                }

            }
            System.out.println(count);
        }

    }

}