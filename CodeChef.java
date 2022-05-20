
import java.awt.*;
import java.io.*;
import java.util.*;
import java.math.*;
import java.sql.*;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.*;



class Codechef{
    public static boolean checkSameDigits(int n)
    {
        // Find the last digit
        int digit = n % 10;

        while (n != 0) {

            int current_digit = n % 10;
           n=n/10;
            if (current_digit != digit) {
                return false;
            }
        }
        return true;
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