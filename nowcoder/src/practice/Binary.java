package practice;

public class Binary {

    public static int weishu(int a) {
        int count = 0;
        while (a != 1) {
            a = a / 2;
            count++;
        }
        return count + 1;
    }

    public static int[] fun(int a, int b) {
        // 1. 按位运算符 | & << >>
        int count_a = weishu(a);// 位数
        int count_b = weishu(b);
        int[] a_count = new int[count_a];
        int[] b_count = new int[count_b];
        int[] c_count = new int[count_a + count_b];
        for (int i = count_a - 1; i >= 0; i--) {
            // (int)Math.pow(2, i-1));
            if ((a & ((int) Math.pow(2, count_a - i - 1))) == Math.pow(2, count_a - i - 1))

            a_count[i] = 1;
            else {
                a_count[i] = 0;
            }

        }
        for (int i = count_b - 1; i >= 0; i--) {
            if ((b & (int) Math.pow(2, count_b - i - 1)) == (Math.pow(2, count_b - i - 1))) b_count[i] = 1;
            else {
                b_count[i] = 0;
            }

        }
        if (count_a > count_b) {
            for (int j = count_a - 1; j >= 0; j--) {
                if (j >= count_b) {

                    c_count[j] = a_count[j];
                } else {
                    if (a_count[j] == b_count[j]) c_count[j] = 0;
                    else c_count[j] = 1;
                }

            }
        } else {
            for (int j = count_b - 1; j >= 0; j--) {
                if (j >= count_a) {

                    c_count[j] = b_count[j];
                } else {
                    if (b_count[j] == a_count[j]) c_count[j] = 0;
                    else c_count[j] = 1;
                }

            }
        }
        return c_count;
    }

    public static void main(String[] args) {
        int[] a = fun(1, 2);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i]);
    }
}
