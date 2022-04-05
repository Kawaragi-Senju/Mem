package ChineseTheorem;

import java.math.BigInteger;
import java.util.Scanner;

public class ChineseT {
    public static void main(String[] args) {

        System.out.println("Сколько чисел m?");

        var scanner = new Scanner(System.in);
        var m = scanner.nextInt();

        BigInteger[] integersOfm = new BigInteger[m];
        BigInteger[] integersOfc = new BigInteger[m];

        for (int i = 0; i < m; i++) {
            System.out.println("Напечатайте m" + (i+1));
            integersOfm[i] = scanner.nextBigInteger();
            System.out.println("Напечатайте c" + (i+1));
            integersOfc[i] = scanner.nextBigInteger();
        }

        int m1 = 12, m2 = 8, m3 = 5;
        int c1 = 10, c2 = 6, c3 = 2;

        if (!numbersCanDivideOnlyOneAndThemSelf(integersOfm) && !numbersCanDivideOnlyOneAndThemSelf(integersOfc)){

        }

        int M = findM(integersOfm);
        int[] Mis = findMis(integersOfm, M);
        int[] Ys = findYs(Mis, integersOfm);

        assertYs(Ys);

        int x0 = findX0(Mis, Ys, integersOfc);

        System.out.println(x0);

        while (x0 > M){
            x0 = x0 - M;
        }
        System.out.println("X === " + x0 + "(mod" + M + ")");

    }

    private static int findX0(int[] mis, int[] ys, BigInteger[] integersOfc) {

        int result = 0;

        for (int i = 0; i < mis.length; i++) {
            result += mis[i] * ys[i] * integersOfc[i].intValue();
        }
        return result;
    }
    private static void assertYs(int[] ys) {

        for (int y : ys) {
            assert y != 0;
        }

    }

    private static int[] findYs(int[] mis, BigInteger[] integersOfm) {

        int[] result = new int[mis.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = findY(mis[i], integersOfm[i].intValue());
        }
        return result;
    }

    private static int[] findMis(BigInteger[] integersOfm, int M) {

        int[] result = new int[integersOfm.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = M / integersOfm[i].intValue();
        }
        return result;
    }

    private static int findM(BigInteger[] integers) {
        int result = 1;
        for (int j = 0; j < integers.length; j++) {
            result = result * integers[j].intValue();
        }
        return result;
    }

    private static int findY(int M, int m) {
        for (int i = 1; i < m; i++) {
            if (((M * i) - 1) % m == 0)
                return i;
        }
        return 0;
    }
    private static boolean numbersCanDivideOnlyOneAndThemSelf(BigInteger[] integers) {
        for (BigInteger bigInteger : integers) {
            for (int i = 2; i < bigInteger.intValue(); i++) {
                if (bigInteger.intValue() % i == 0)
                    return false;
            }
        }
        return true;
    }

    private static int[] mergeArrays(int[] integersm, int[] integersc) {

        int lengthM = integersm.length;
        int lengthC = integersc.length;
        int[] result = new int[lengthM + lengthC];

        System.arraycopy(integersm, 0, result, 0, lengthM);
        System.arraycopy(integersc, 0, result, lengthM, lengthC);
        return result;
    }
}

