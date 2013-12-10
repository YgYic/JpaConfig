package controller;
import java.lang.reflect.*;
import javax.swing.*;
import java.awt.event.*;
public class ActionListenerInstaller{
	//处理注释的方法，其中obj是包含注释的对象
	public static void processAnnotations(Object obj){
		try{
			//获取obj对象的类
			Class<? extends Object> c1 = obj.getClass();
			//获取指定的obj对象的所有Field, 并遍历每个Field
			for(Field f: c1.getDeclaredFields()){
				//将指定obj设置成可自由访问的，避免private的Field不可访问
				f.setAccessible(true);
				//获取指定Field的、ActionListenerFor类型的注释
				ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
				if(a != null && a instanceof AbstractButton){
					//获取a注释里的元数据listener
					Class<?> listenerClazz = Class.forName(a.listener());
					//使用反射来创建listener类的对象
					ActionListener a1 = (ActionListener)listenerClazz.newInstance();
					//获取f Field实际对应的对象
					AbstractButton ab = (AbstractButton)f.get(obj);
					//为ab对象添加事件监听器
					ab.addActionListener(a1);
				}
			}
			}catch(Exception e){
				e.printStackTrace();
			}
	}
}