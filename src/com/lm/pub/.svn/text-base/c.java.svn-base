/*jadclipse*/// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.

package com.lm.pub;

import java.io.*;

public class c
{

    public c()
    {
    }

    private static byte[] _mthif(byte abyte0[])
    {
        int i = abyte0.length % 3;
        byte abyte1[];
        if(i == 0)
            abyte1 = new byte[(4 * abyte0.length) / 3];
        else
            abyte1 = new byte[4 * (abyte0.length / 3 + 1)];
        int j = abyte0.length - i;
        int j1 = 0;
        for(int i2 = 0; j1 < j; i2 += 4)
        {
            int k = abyte0[j1] & 255;
            int l = abyte0[j1 + 1] & 255;
            int i1 = abyte0[j1 + 2] & 255;
            abyte1[i2] = a[k >>> 2 & 63];
            abyte1[i2 + 1] = a[(k << 4 | l >>> 4) & 63];
            abyte1[i2 + 2] = a[(l << 2 | i1 >>> 6) & 63];
            abyte1[i2 + 3] = a[i1 & 63];
            j1 += 3;
        }

        switch(i)
        {
        case 1: // '\001'
            int i3 = abyte0[abyte0.length - 1] & 255;
            int k1 = i3 >>> 2 & 63;
            int j2 = i3 << 4 & 63;
            abyte1[abyte1.length - 4] = a[k1];
            abyte1[abyte1.length - 3] = a[j2];
            abyte1[abyte1.length - 2] = 61;
            abyte1[abyte1.length - 1] = 61;
            break;

        case 2: // '\002'
            int j3 = abyte0[abyte0.length - 2] & 255;
            int k3 = abyte0[abyte0.length - 1] & 255;
            int l1 = j3 >>> 2 & 63;
            int k2 = (j3 << 4 | k3 >>> 4) & 63;
            int l2 = k3 << 2 & 63;
            abyte1[abyte1.length - 4] = a[l1];
            abyte1[abyte1.length - 3] = a[k2];
            abyte1[abyte1.length - 2] = a[l2];
            abyte1[abyte1.length - 1] = 61;
            break;
        }
        return abyte1;
    }

    private static byte[] a(byte abyte0[])
    {
        byte abyte1[];
        if(abyte0[abyte0.length - 2] == 61)
            abyte1 = new byte[(abyte0.length / 4 - 1) * 3 + 1];
        else
        if(abyte0[abyte0.length - 1] == 61)
            abyte1 = new byte[(abyte0.length / 4 - 1) * 3 + 2];
        else
            abyte1 = new byte[(abyte0.length / 4) * 3];
        int i = 0;
        for(int j = 0; i < abyte0.length - 4; j += 3)
        {
            byte byte0 = _fldif[abyte0[i]];
            byte byte4 = _fldif[abyte0[i + 1]];
            byte byte8 = _fldif[abyte0[i + 2]];
            byte byte11 = _fldif[abyte0[i + 3]];
            abyte1[j] = (byte)(byte0 << 2 | byte4 >> 4);
            abyte1[j + 1] = (byte)(byte4 << 4 | byte8 >> 2);
            abyte1[j + 2] = (byte)(byte8 << 6 | byte11);
            i += 4;
        }

        if(abyte0[abyte0.length - 2] == 61)
        {
            byte byte1 = _fldif[abyte0[abyte0.length - 4]];
            byte byte5 = _fldif[abyte0[abyte0.length - 3]];
            abyte1[abyte1.length - 1] = (byte)(byte1 << 2 | byte5 >> 4);
        } else
        if(abyte0[abyte0.length - 1] == 61)
        {
            byte byte2 = _fldif[abyte0[abyte0.length - 4]];
            byte byte6 = _fldif[abyte0[abyte0.length - 3]];
            byte byte9 = _fldif[abyte0[abyte0.length - 2]];
            abyte1[abyte1.length - 2] = (byte)(byte2 << 2 | byte6 >> 4);
            abyte1[abyte1.length - 1] = (byte)(byte6 << 4 | byte9 >> 2);
        } else
        {
            byte byte3 = _fldif[abyte0[abyte0.length - 4]];
            byte byte7 = _fldif[abyte0[abyte0.length - 3]];
            byte byte10 = _fldif[abyte0[abyte0.length - 2]];
            byte byte12 = _fldif[abyte0[abyte0.length - 1]];
            abyte1[abyte1.length - 3] = (byte)(byte3 << 2 | byte7 >> 4);
            abyte1[abyte1.length - 2] = (byte)(byte7 << 4 | byte10 >> 2);
            abyte1[abyte1.length - 1] = (byte)(byte10 << 6 | byte12);
        }
        return abyte1;
    }

    private static byte[] _mthfor(String s)
    {
        boolean flag = false;
        byte abyte0[];
        if(s.charAt(s.length() - 2) == '=')
        {
            int i = (s.length() / 4) * 3 + 1;
            abyte0 = new byte[(s.length() / 4) * 3 + 1];
        } else
        if(s.charAt(s.length() - 1) == '=')
        {
            int j = (s.length() / 4) * 3 + 2;
            abyte0 = new byte[(s.length() / 4) * 3 + 2];
        } else
        {
            int k = (s.length() / 4 + 1) * 3;
            abyte0 = new byte[(s.length() / 4 + 1) * 3];
        }
        int l = 0;
        for(int i1 = 0; l < s.length() - 4; i1 += 3)
        {
            byte byte0 = _fldif[s.charAt(l)];
            byte byte4 = _fldif[s.charAt(l + 1)];
            byte byte8 = _fldif[s.charAt(l + 2)];
            byte byte11 = _fldif[s.charAt(l + 3)];
            abyte0[i1] = (byte)(byte0 << 2 | byte4 >> 4);
            abyte0[i1 + 1] = (byte)(byte4 << 4 | byte8 >> 2);
            abyte0[i1 + 2] = (byte)(byte8 << 6 | byte11);
            l += 4;
        }

        if(s.charAt(s.length() - 2) == '=')
        {
            byte byte1 = _fldif[s.charAt(s.length() - 4)];
            byte byte5 = _fldif[s.charAt(s.length() - 3)];
            abyte0[abyte0.length - 1] = (byte)(byte1 << 2 | byte5 >> 4);
        } else
        if(s.charAt(s.length() - 1) == '=')
        {
            byte byte2 = _fldif[s.charAt(s.length() - 4)];
            byte byte6 = _fldif[s.charAt(s.length() - 3)];
            byte byte9 = _fldif[s.charAt(s.length() - 2)];
            abyte0[abyte0.length - 2] = (byte)(byte2 << 2 | byte6 >> 4);
            abyte0[abyte0.length - 1] = (byte)(byte6 << 4 | byte9 >> 2);
        } else
        {
            byte byte3 = _fldif[s.charAt(s.length() - 4)];
            byte byte7 = _fldif[s.charAt(s.length() - 3)];
            byte byte10 = _fldif[s.charAt(s.length() - 2)];
            byte byte12 = _fldif[s.charAt(s.length() - 1)];
            abyte0[abyte0.length - 3] = (byte)(byte3 << 2 | byte7 >> 4);
            abyte0[abyte0.length - 2] = (byte)(byte7 << 4 | byte10 >> 2);
            abyte0[abyte0.length - 1] = (byte)(byte10 << 6 | byte12);
        }
        return abyte0;
    }

    private static String _mthif(String s)
    {
        byte abyte0[] = s.getBytes();
        byte abyte1[] = _mthif(abyte0);
        try
        {
            return new String(abyte1, "8859_1");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception)
        {
            return null;
        }
    }

    public static String _mthint(String s)
    {
        Object obj = null;
        String s1 = "";
        int i = (int)(new File(s)).length();
        byte abyte0[] = new byte[i];
        try
        {
            FileInputStream fileinputstream = new FileInputStream(s);
            fileinputstream.read(abyte0, 0, i);
        }
        catch(IOException ioexception) { }
        if(abyte0 != null)
            try
            {
                s1 = new String(_mthif(abyte0), "8859_1");
            }
            catch(UnsupportedEncodingException unsupportedencodingexception) { }
        else
            s1 = null;
        return s1;
    }

    public static boolean _mthif(String s, String s1)
    {
        Object obj = null;
        byte abyte0[] = _mthfor(s);
        System.out.println(new String(abyte0));
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(s1);
            fileoutputstream.write(abyte0, 0, abyte0.length);
            return true;
        }
        catch(IOException ioexception)
        {
            return false;
        }
    }

    public static String a(String s)
    {
        String s1 = "";
        s1 = new String(_mthfor(s));
        return s1;
    }

    public static String _mthdo(String s)
    {
        String s1 = _mthif(s);
        return s1;
    }

    public static boolean a(String s, String s1)
    {
        boolean flag = false;
        String as[] = s.split("\n");
        if(as != null && as.length > 0)
        {
            StringBuffer stringbuffer = new StringBuffer();
            for(int i = 0; as != null && i < as.length; i++)
                stringbuffer.append(as[i]);

            _mthif(stringbuffer.toString(), s1);
            flag = true;
        }
        return flag;
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
    private static final byte _fldif[];

    static 
    {
        _fldif = new byte[128];
        for(int i = 65; i <= 90; i++)
            _fldif[i] = (byte)(i - 65);

        for(int j = 97; j <= 122; j++)
            _fldif[j] = (byte)((j - 97) + 26);

        for(int k = 48; k <= 57; k++)
            _fldif[k] = (byte)((k - 48) + 52);

        _fldif[43] = 62;
        _fldif[47] = 63;
    }
}


/*
	DECOMPILATION REPORT

	Decompiled from: D:\workspace20100111\new_pmp\WebContent\WEB-INF\lib\lmpub1.0.jar
	Total time: 47 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/