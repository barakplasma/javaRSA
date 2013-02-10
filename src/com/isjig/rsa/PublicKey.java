package com.isjig.rsa;

import java.math.BigInteger;

public class PublicKey
{
    private BigInteger n;
    private BigInteger e;

    public PublicKey(BigInteger n, BigInteger e)
    {
       this.n = n; this.e = e; 
    }

    public BigInteger GetN() { return n; }

    public BigInteger GetE() { return e; }
}
