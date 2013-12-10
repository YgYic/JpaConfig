package test;

public class XTest {
	public static int T = 1;
	public static int T1 = 1;
	enum T2{T,T1};
	/**
	 * @throws Exception
	 *             <p>
	 *             Title: main
	 *             </p>
	 *             <p>
	 *             Description: TODO
	 *             </p>
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		// int a = 7;
		// System.out.println(a>>2);
		// Encoder.decodeToFile("DFDASDKDKLD=","D:\\text.txt");
		// XTest xt = new XTest();
		// Calendar calendar = Calendar.getInstance();
		// try {
		// System.out.println(xt.method()+calendar.get(Calendar.DAY_OF_MONTH));
		// // throw new ArithmeticException();
		// } catch (Exception e) {
		// System.out.println("有异常！");
		// }
		// System.out.println(xt.method()+" "+calendar.get(Calendar.DAY_OF_MONTH));
		// for (int i = 0; i < 10; i++) {
		// }
//		System.out.println("stmp.116".indexOf("111"));
//		System.out.println(XTest.T2.T);
		
	}

	public static boolean hasLength(String str) {
		return (str != null && str.length() > 0);
	}
	
	public static String trimWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}
		StringBuffer buf = new StringBuffer(str);
		while (buf.length() > 0 && Character.isWhitespace(buf.charAt(0))) {
			buf.deleteCharAt(0);
		}
		while (buf.length() > 0 && Character.isWhitespace(buf.charAt(buf.length() - 1))) {
			buf.deleteCharAt(buf.length() - 1);
		}
		return buf.toString();
	}
	
	public int method2() {
		return method();
	}

	public int method3() {
		return method2();
	}

	public int method4() {
		return method3();
	}

	public int method() throws ArithmeticException {
		// try {
		// @SuppressWarnings("unused")
		// InputStream is = new FileInputStream(new File(""));
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// }finally{
		// System.out.println("dddd");
		// }
		// return 0;
		try {
			System.out.println(10 / 0);
			return 0;
		} catch (Exception e) {
			System.out.println("除数不能为0");
			throw new ArithmeticException();
		} finally {
			System.out.println("执行完成");
			/*
			 * try { System.out.println(1/0); } catch (Exception e2) { throw new
			 * ArithmeticException(); }
			 */
		}
	}

}
