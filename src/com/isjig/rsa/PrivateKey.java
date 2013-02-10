package com.isjig.rsa;

import java.math.BigInteger;

public class PrivateKey 
{
    private BigInteger d;
    private BigInteger e;
    
    public PrivateKey(BigInteger d, BigInteger e)
    {
        this.d = d; this.e = e;
    }

    public BigInteger getD() { return d; }

    public BigInteger getE() { return e; }
}
