package com.isjig.pgp.rsa;

import java.math.BigInteger;

public class PublicKey extends Key
{
    private BigInteger n;
    private BigInteger e;

    public PublicKey(BigInteger n, BigInteger e)
    {
       this.n = n; this.e = e; 
    }

    public BigInteger getN() { return n; }

    public BigInteger getE() { return e; }
    
    @Override
    public String toString()
    {
        return null;
    }
}
