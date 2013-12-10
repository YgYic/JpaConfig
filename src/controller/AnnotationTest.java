package controller;
import javax.swing.*;
import java.awt.event.*;
public class AnnotationTest{
	private JFrame mainWin = new JFrame("使用注解绑定事件监听器");
	//使用注解为OK按钮绑定事件监听器
	@ActionListenerFor(listener = "OkListener")
	private JButton ok = new JButton("确定");
	
	//使用注解为Cancel按钮绑定事件监听器
	@ActionListenerFor(listener = "CancelListener")
	private JButton cancel = new JButton("取消");

	public void init(){
		//初始化界面的方法
		JPanel jp = new JPanel();
		jp.add(ok);
		jp.add(cancel);
		mainWin.add(jp);
		ActionListenerInstaller.processAnnotations(this);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	public static void main(String[] args){
		new AnnotationTest().init();
	}
}

//定义OK按钮的事件监听器实现类
	class OkListener implements ActionListener{
		public void actionPerformed(ActionEvent evt){
			JOptionPane.showMessageDialog(null, "单击确认按钮");
		}
	}
//定义Cancel按钮的事件监听器实现类
	class CancelListener implements ActionListener{
		public void actionPerformed(ActionEvent evt){
			JOptionPane.showMessageDialog(null, "单击了取消按钮");
		}
	}