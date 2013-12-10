/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.lm.pub;

import java.io.*;
import java.util.zip.ZipInputStream;

// Referenced classes of package com.lm.pub:
//            d

public class a
{

    public a()
    {
    }

    public static boolean a(String s, String s1)
    {
        try
        {
            d d1 = new d(new File(s));
            ZipInputStream zipinputstream = new ZipInputStream(d1);
            zipinputstream.getNextEntry();
            BufferedInputStream bufferedinputstream = new BufferedInputStream(zipinputstream);
            File file = new File(s1);
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(fileoutputstream, 2048);
            byte abyte0[] = new byte[2048];
            int i;
            while((i = bufferedinputstream.read(abyte0, 0, 2048)) != -1) 
                bufferedoutputstream.write(abyte0, 0, i);
            bufferedoutputstream.flush();
            bufferedoutputstream.close();
            bufferedinputstream.close();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return true;
    }

    public static InputStream a(String s)
        throws IOException
    {
        d d1 = new d(new File(s));
        ZipInputStream zipinputstream = new ZipInputStream(d1);
        zipinputstream.getNextEntry();
        return zipinputstream;
    }

    static final int a = 2048;
}


/*
	DECOMPILATION REPORT

	Decompiled from: D:\workspace20100111\new_pmp\WebContent\WEB-INF\lib\lmpub1.0.jar
	Total time: 31 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/