package com.isjig.rsa;

import java.math.BigInteger;
import java.util.Random;

public class RSA 
{
    private RSA() {}

    public static BigInteger encrypt(PublicKey pub, BigInteger m)
    { 
        return m.modPow(pub.getE(), pub.getN());
    }
    
    public static BigInteger decrypt(PrivateKey pri, BigInteger c)
    {
        return c.modPow(pri.getD(), pri.getN());
    }
    
    public static Key[] generateKeys(int bitLength) 
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
        
        Key[] pubPri = {new PublicKey(n,e), new PrivateKey(n,d)};
        return pubPri;
    }
    
    public static void main(String[] args){
        
       System.out.println("Generating keys...");
       Key[] pubPri = generateKeys(4096);
       System.out.println("Encrypting message...");
       BigInteger plainText = new BigInteger("123456789");
       BigInteger cipherText = encrypt((PublicKey)pubPri[0],plainText);
       System.out.println("Decrypting message...");
       BigInteger decryptedText = decrypt((PrivateKey)pubPri[1],cipherText);
       System.out.println(plainText + "\n" + cipherText + "\n" + decryptedText);
       
       
        
        
    }
}
