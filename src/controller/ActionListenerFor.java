package controller;
import java.lang.annotation.*;
//ʹ��JDK��Ԫ����Annotation: Retention
@Retention(RetentionPolicy.RUNTIME)
	
//ʹ��JDK��Ԫ����Annotation: Target
@Target(ElementType.FIELD)

//����һ�����ע�ͣ��������κγ�Ա�����������ɴ���Ԫ����
public @interface ActionListenerFor{
	String listener();
}