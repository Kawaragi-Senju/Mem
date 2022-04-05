package module;

public class ModuleWithoutBig {
    public static void main(String[] args) {
        System.out.println(addition(getRandom(), getRandom(), getRandom()));
        System.out.println(subtraction(getRandom(), getRandom(), getRandom()));
        System.out.println(multiplication(getRandom(), getRandom(), getRandom()));
        System.out.println(divide(getRandom(), getRandom(), getRandom()));
        System.out.println(additiveInversion(getRandom(), getRandom(), getRandom()));
        System.out.println(exponentiation(getRandom(), getRandom(), getRandom()));
        System.out.println(multiInversion(getRandom(), getRandom(), getRandom()));
    }

    public static long getRandom(){
        return (long) ((Math.random() * (100)) + 0);
    }

    private static boolean addition(long x, long y, long mod){
        long left = (x + y) % mod;
        long right = ((x % mod) + (y % mod)) % mod;
        return left == right;
    }
    private static boolean subtraction(long x, long y, long mod){
        long left = (x - y) % mod;
        long right = ((x % mod) - (y % mod)) % mod;
        return left == right;
    }
    private static boolean multiplication(long x, long y, long mod){
        long left = (x * y) % mod;
        long right = ((x % mod) * (y % mod)) % mod;
        return left == right;
    }
    private static boolean divide(long x, long y, long mod){
        long left = (x / y) % mod;
        long right = ((x % mod) / (y % mod)) % mod;
        return left == right;
    }
    private static boolean additiveInversion(long x, long y, long mod){
        long left = (x + y) % mod;
        long right = 0;
        return left == right;
    }
    private static boolean multiInversion(long x, long y, long mod){
        long left = (x * y) % mod;
        long right = 1 % mod;
        return left == right;
    }
    private static boolean exponentiation(long x, long y, long mod){
        long left = (long) (Math.pow(x, y) % mod);
        long right = (long) (Math.pow((x % mod), y) % mod);
        return left == right;
    }
}