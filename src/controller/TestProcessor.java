package controller;
import java.lang.reflect.*;
public class TestProcessor{
	public static void process(String clazz) throws ClassNotFoundException{
		int passed = 0;
		int failed = 0;
		//遍历clazz对象的所有方法
		for(Method m: Class.forName(clazz).getMethods()){
			//如果包含@Testable标记注解
			if(m.isAnnotationPresent(Testable.class)){
				try{
					//调用m方法
					m.invoke(null);
					//passed加1
					passed++;
				}catch(Exception e){
					System.out.println("方法" + m + "运行失败，异常: " + e.getCause() + "\n");
					failed++;
				}
			}
		}
		//统计测试结果
		System.out.println("共运行了: " + (passed+failed) + "个方法，其中: \n 成功了:" 
			+ passed + "个， \n 失败了: " + failed + "个！\n");
	}
}