package com.isjig.pgp.rsa;

import java.math.BigInteger;

public class PrivateKey extends Key
{
    private BigInteger n;
    private BigInteger d;
    
    public PrivateKey(BigInteger n, BigInteger d)
    {
        this.n = n; this.d = d;
    }

    public BigInteger getN() { return n; }

    public BigInteger getD() { return d; }
    
    @Override
    public String toString()
    {
        return null;
    }
}
