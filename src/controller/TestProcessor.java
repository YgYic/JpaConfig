package controller;
import java.lang.reflect.*;
public class TestProcessor{
	public static void process(String clazz) throws ClassNotFoundException{
		int passed = 0;
		int failed = 0;
		//����clazz��������з���
		for(Method m: Class.forName(clazz).getMethods()){
			//�������@Testable���ע��
			if(m.isAnnotationPresent(Testable.class)){
				try{
					//����m����
					m.invoke(null);
					//passed��1
					passed++;
				}catch(Exception e){
					System.out.println("����" + m + "����ʧ�ܣ��쳣: " + e.getCause() + "\n");
					failed++;
				}
			}
		}
		//ͳ�Ʋ��Խ��
		System.out.println("��������: " + (passed+failed) + "������������: \n �ɹ���:" 
			+ passed + "���� \n ʧ����: " + failed + "����\n");
	}
}