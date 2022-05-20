import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.List;



class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    //gcd
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    //lcm
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    //mod
    static int mod(int a, int b) {
        return (a % b + b) % b;
    }

    //seive
    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }

    public static double angle(int hour, int minute) {
        if (hour < 0 || minute < 0) {
            return -1;
        }
        if (hour == 12) {
            hour = 0;
        }
        if (minute == 60) {
            minute = 0;
            hour += 1;
        }
        double hourAngle = (hour * 60 + minute) * 0.5;
        double minAngle = minute * 6;
        double bwAngle = Math.abs(hourAngle - minAngle);
        return (Math.min(360 - bwAngle, bwAngle));
    }

    public static long down(long a) {
        long p = 1;
        while (a > 0) {
            p *= a;
            a--;
        }
        return p;
    }

    public static long up(long a, long b) {
        if (b == 0)
            return 0;
        return down(a) / (down(a - b) * down(b)) + up(a, b - 1);
    }


    public static int maxii(int x, int y) {
        return x > y ? x : y;
    }

    public static void printPrimeFactors(long n) {
        while (n % 2 == 0) {
            System.out.print("2 ");
            n = n / 2;
        }
        long i;
        for (i = 3; i <= Math.sqrt(n); i = i + 2) {
            while (n % i == 0) {
                System.out.print(i);
                System.out.print(" ");
                n = n / i;
            }
        }
        if (n > 2) System.out.print(n);
    }

    public static int fact(int n) {
        int result = 1;
        for (int i = 1; i < n; i++) {
            result = result * i;
        }
        return result;
    }


    public static int max(int x, int y) {
        return x > y ? x : y;
    }

    static int a[][] = new int[50][50];

    public static void del(int i, int j, int s, int f, int r, int c) {
        int k, l;
        if (s == 0) {
            for (k = 0; k < r; k++)
                for (l = j; l < c; l++)
                    a[k][l] = f - 1;
        } else {
            for (k = i; k < r; k++)
                for (l = 0; l < c; l++)
                    a[k][l] = f - 1;
        }
    }

    public static int rsum(int i, int j, int r, int c) {
        int k, l, s = 0;
        for (k = 0; k < i; k++)
            for (l = 0; l < c; l++)
                s += a[k][l];
        return s;
    }

    public static int csum(int i, int j, int r, int c) {
        int k, l, s = 0;
        for (k = 0; k < r; k++)
            for (l = 0; l < j; l++)
                s += a[k][l];
        return s;
    }

    static int ans = 0;

    static int dfs(int ar[][], int x, int y, int cur, int n, int m) {
        int mx = -1;
        if (0 < x && ar[x - 1][y] < ar[x][y]) mx = max(mx, ar[x - 1][y]);
        if (0 < y && ar[x][y - 1] < ar[x][y]) mx = max(mx, ar[x][y - 1]);
        if (y < m - 1 && ar[x][y + 1] < ar[x][y]) mx = max(mx, ar[x][y + 1]);
        if (x < n - 1 && ar[x + 1][y] < ar[x][y]) mx = max(mx, ar[x + 1][y]);

        if (0 < x && ar[x - 1][y] == mx)
            dfs(ar, x - 1, y, cur + 1, n, m);
        if (0 < y && ar[x][y - 1] == mx)
            dfs(ar, x, y - 1, cur + 1, n, m);
        if (y < m - 1 && ar[x][y + 1] == mx)
            dfs(ar, x, y + 1, cur + 1, n, m);
        if (x < n - 1 && ar[x + 1][y] == mx)
            dfs(ar, x + 1, y, cur + 1, n, m);

        ans = max(ans, cur + 1);
        return ans;
    }

    public static long factorial(long n) {
        return ((n == 1) || (n == 0)) ? 1 : n * factorial(n - 1);
    }





}