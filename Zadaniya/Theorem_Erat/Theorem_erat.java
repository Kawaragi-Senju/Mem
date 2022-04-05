package Theorem_Erat;

import java.util.ArrayList;
import java.util.List;

public class Theorem_erat {
    static class PrimePair {
        Integer prime;
        Integer lastCrossed;

        PrimePair(Integer prime, Integer lastCrossed) {
            this.prime = prime;
            this.lastCrossed = lastCrossed;
        }
    }

    private List<PrimePair> primes;

    private Theorem_erat() {
        primes = new ArrayList<>();
        primes.add(new PrimePair(2, 2));
        primes.add(new PrimePair(3, 3));
    }

    private void fillNPrimes(int n) {
        while (primes.size()<n) {
            addNextPrime();
        }
    }

    private void addNextPrime() {
        int candidate = primes.get(primes.size()-1).prime + 2;
        for (int i = 1; i < primes.size(); i++) {
            PrimePair p = primes.get(i);
            while (p.lastCrossed < candidate) {
                p.lastCrossed += p.prime;
            }
            if (p.lastCrossed == candidate) {
                //restart
                candidate+=2;
                i=-1;
            }
        }
        System.out.println(candidate);
        primes.add(new PrimePair(candidate, candidate));
    }

    public static void main(String[] args) {
        Theorem_erat test = new Theorem_erat();
        test.fillNPrimes(1000);
    }
}