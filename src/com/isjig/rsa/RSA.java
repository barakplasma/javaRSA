package com.isjig.rsa;

import java.math.BigInteger;
import java.util.Random;

public class RSA 
{
    private RSA() {}

    public static BigInteger encrypt(BigInteger m, BigInteger n, BigInteger e) { return m.modPow(e, n); }
    
    public static BigInteger decrypt(BigInteger c, BigInteger n, BigInteger d) { return c.modPow(d, n); }

    public static BigInteger[] generateKeys(int bitLength) 
    {
        BigInteger p, q, n, phiOfN, e, d;
        p = BigInteger.probablePrime(bitLength, new Random());
        q = BigInteger.probablePrime(bitLength, new Random());
        n = p.multiply(q);
        // phiOfN = (p - 1)(q - 1)
        phiOfN =
                (p.subtract(new BigInteger("1"))).multiply(q.subtract(new BigInteger("1")));
        do {
            e = BigInteger.probablePrime(8, new Random());
        } while (e.compareTo(phiOfN) < 0 && (phiOfN.mod(e)).compareTo(BigInteger.ZERO) == 0);
        d = e.modInverse(phiOfN);
        BigInteger[] keys = {n,e,d};
        return keys;
    }
}
