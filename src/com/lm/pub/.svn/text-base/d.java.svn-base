/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.lm.pub;

import java.io.*;

public class d extends FileInputStream
{

    public d(File file)
        throws FileNotFoundException
    {
        super(file);
        a = 0L;
    }

    public d(FileDescriptor filedescriptor)
    {
        super(filedescriptor);
        a = 0L;
    }

    public d(String s)
        throws FileNotFoundException
    {
        super(s);
        a = 0L;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        int i = super.read(abyte0);
        if(i == -1)
            return -1;
        if(a == 0L)
        {
            if(i > 0)
                abyte0[0] = 80;
            if(i > 1)
                abyte0[1] = 75;
        } else
        if(a == 1L && i > 0)
            abyte0[0] = 75;
        a += i;
        return i;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        int k = super.read(abyte0, i, j);
        if(k == -1)
            return -1;
        if(a == 0L)
        {
            if(k > 0)
                abyte0[0] = 80;
            if(k > 1)
                abyte0[1] = 75;
        } else
        if(a == 1L && k > 0)
            abyte0[0] = 75;
        a += k;
        return k;
    }

    public long skip(long l)
        throws IOException
    {
        a += l;
        return super.skip(l);
    }

    long a;
}


/*
	DECOMPILATION REPORT

	Decompiled from: D:\workspace20100111\new_pmp\WebContent\WEB-INF\lib\lmpub1.0.jar
	Total time: 32 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/