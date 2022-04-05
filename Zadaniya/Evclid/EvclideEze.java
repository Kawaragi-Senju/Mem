package Evclid;

public class EvclideEze {
    public static int Ev(int m, int n) {
        int r = 0;
        while (n != 0){
            r = m %n;
            m = n;
            n = r;
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(Ev(10,28));
    }
}
