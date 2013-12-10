package controller;
public class RunTests{
	public static void main(String[] args){
		//¥¶¿ÌMyTest¿‡
		try{
			TestProcessor.process("MyTest");
		}catch(ClassNotFoundException e){
			System.out.println("e");
		}
	}
}