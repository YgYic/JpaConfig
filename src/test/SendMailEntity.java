package test;

import java.io.Serializable;

/**
 * @author huang.die
 * �ʼ�����send_mail ʵ����
 */
public class SendMailEntity implements Serializable {

	private static final long serialVersionUID = 6569351829726862569L;
	
	private int 	mail_sn;
	private String	content;
	private int 	status;
	private String 	url;
	private String	inserttime;
	private String	title;
	private String	mail;
	private String	personal;
	private int		send_type;
	private String	send_time;
	private int		result;
	private int		priority;
	
	public int getMail_sn() {
		return mail_sn;
	}
	public void setMail_sn(int mail_sn) {
		this.mail_sn = mail_sn;
	}
	
	/**
	 * �ʼ���Ҫ���� 
	 */
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * �ʼ�״̬��������� 
	 */
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	/**
	 * �����ʼ��ķ�����url 
	 */
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * ����ʱ�� 
	 */
	public String getInserttime() {
		return inserttime;
	}
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}
	
	/**
	 * �ʼ����� 
	 */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Ŀ������ 
	 */
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * �ʼ�����
	 */
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
	}
	
	/**
	 * �������� 
	 */
	public int getSend_type() {
		return send_type;
	}
	public void setSend_type(int send_type) {
		this.send_type = send_type;
	}
	
	/**
	 * ����ʱ�� 
	 */
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	
	/**
	 * ����״̬���Ƿ�ɹ��� 
	 */
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	/**
	 * 
	 */
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	

}
