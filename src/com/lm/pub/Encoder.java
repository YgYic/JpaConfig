/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.lm.pub;

import java.io.IOException;
import java.io.InputStream;


// Referenced classes of package com.lm.pub:
//            b, c, a

public class Encoder
{

    public Encoder()
    {
    }

    public static String MD5Encode(String s)
    {
        return b.a(s);
    }

    public static boolean decodeToFile(String s, String s1)
    {
        return c._mthif(s, s1);
    }

    public static String decodeToString(String s)
    {
        return c.a(s);
    }

    public static boolean decodeImageToFile(String s, String s1)
    {
        return com.lm.pub.a.a(s, s1);
    }

    public static InputStream decodeImageToInputStream(String s)
        throws IOException
    {
        return com.lm.pub.a.a(s);
    }

    private static final byte a[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };

}


/*
	DECOMPILATION REPORT

	Decompiled from: D:\workspace20100111\new_pmp\WebContent\WEB-INF\lib\lmpub1.0.jar
	Total time: 109 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/