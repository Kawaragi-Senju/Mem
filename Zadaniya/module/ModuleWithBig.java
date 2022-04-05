package module;

import java.math.BigInteger;

public class ModuleWithBig {
    public static void main(String[] args) {
        System.out.println(addition(getRandom(), getRandom(), getRandom()));
        System.out.println(subtraction(getRandom(), getRandom(), getRandom()));
        System.out.println(multiplication(getRandom(), getRandom(), getRandom()));
        System.out.println(divide(getRandom(), getRandom(), getRandom()));
        System.out.println(additiveInversion(getRandom(), getRandom(), getRandom()));
        System.out.println(multiInversion(getRandom(), getRandom(), getRandom()));
        System.out.println(exponentiation(getRandom(), getRandom(), getRandom()));
    }
    private static BigInteger getRandom(){
        return BigInteger.valueOf((long)((Math.random() * (100)) + 0));
    }
    private static boolean addition(BigInteger x, BigInteger y, BigInteger mod){
        BigInteger left = BigInteger.valueOf((x.longValue() + y.longValue()) % mod.longValue());
        BigInteger right = BigInteger.valueOf(((x.longValue() % mod.longValue()) + (y.longValue() % mod.longValue())) % mod.longValue());
        return left.equals(right);
    }
    private static boolean subtraction(BigInteger x, BigInteger y, BigInteger mod){
        BigInteger left = BigInteger.valueOf((x.longValue() - y.longValue()) % mod.longValue());
        BigInteger right = BigInteger.valueOf(((x.longValue() % mod.longValue()) - (y.longValue() % mod.longValue())) % mod.longValue());
        return left.equals(right);
    }
    private static boolean multiplication(BigInteger x, BigInteger y, BigInteger mod){
        BigInteger left =  BigInteger.valueOf((x.longValue() * y.longValue()) % mod.longValue());
        BigInteger right =  BigInteger.valueOf(((x.longValue() % mod.longValue()) * (y.longValue() % mod.longValue())) % mod.longValue());
        return left.equals(right);
    }
    private static boolean divide(BigInteger x, BigInteger y, BigInteger mod){
        BigInteger left =  BigInteger.valueOf((x.longValue() / y.longValue()) % mod.longValue());
        BigInteger right =  BigInteger.valueOf(((x.longValue() % mod.longValue()) / (y.longValue() % mod.longValue())) % mod.longValue());
        return left.equals(right);
    }
    public static boolean additiveInversion(BigInteger x, BigInteger y, BigInteger mod){
        BigInteger left =  BigInteger.valueOf((x.longValue() + y.longValue()) % mod.longValue());
        BigInteger right =  BigInteger.valueOf(0);
        return left.equals(right);
    }
    public static boolean multiInversion(BigInteger x, BigInteger y, BigInteger mod){
        BigInteger left = BigInteger.valueOf( (x.longValue() * y.longValue()) % mod.longValue());
        BigInteger right = BigInteger.valueOf( 1 % mod.longValue());
        return left.equals(right);
    }
    private static boolean exponentiation(BigInteger x, BigInteger y, BigInteger mod){
        BigInteger left =  BigInteger.valueOf((long) (Math.pow(x.longValue(), y.longValue()) % mod.longValue()));
        BigInteger right =  BigInteger.valueOf((long) (Math.pow((x.longValue() % mod.longValue()), y.longValue()) % mod.longValue()));
        return left.equals(right);
    }
}

