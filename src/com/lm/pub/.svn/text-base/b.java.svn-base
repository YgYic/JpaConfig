/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.lm.pub;

import java.security.MessageDigest;

public class b
{

    public b()
    {
    }

    public static String a(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < abyte0.length; i++)
            stringbuffer.append(a(abyte0[i]));

        return stringbuffer.toString();
    }

    private static String a(byte byte0)
    {
        int i = byte0;
        if(i < 0)
            i = 256 + i;
        int j = i / 16;
        int k = i % 16;
        return (new StringBuilder()).append(a[j]).append(a[k]).toString();
    }

    public static String a(String s)
    {
        String s1 = null;
        try
        {
            s1 = new String(s);
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            s1 = a(messagedigest.digest(s1.getBytes()));
        }
        catch(Exception exception) { }
        return s1;
    }

    private static final String a[] = {
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
        "a", "b", "c", "d", "e", "f"
    };

}


/*
	DECOMPILATION REPORT

	Decompiled from: D:\workspace20100111\new_pmp\WebContent\WEB-INF\lib\lmpub1.0.jar
	Total time: 31 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/