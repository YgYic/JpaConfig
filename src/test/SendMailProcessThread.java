package test;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.jscape.inet.http.Http;
import com.jscape.inet.http.HttpParameter;
import com.jscape.inet.http.HttpRequest;
import com.jscape.inet.http.HttpResponse;

public class SendMailProcessThread implements Runnable{
	public static void main(String[] args){
		new Thread(new SendMailProcessThread()).start();
	}
	
	@Override
	public void run() {
		while(true){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String mailTime = sdf.format(new Date());
			int totalMail = 0;
			System.out.println("start send mail :" + mailTime);
			try {
				while(true){
					List<SendMailEntity> sendMailList = queryMails(mailTime);
					if (null == sendMailList || sendMailList.size() == 0) {
						break;
					}
					totalMail += sendMailList.size();
					for (SendMailEntity sendMailEntity : sendMailList) {
						if (SendMailProcessThread.sendSMS(sendMailEntity)) {
							System.out.println("Send Mail success to " + sendMailEntity.getMail());
							updateSendMail(sendMailEntity.getMail_sn(), 0);
						}else{
							System.out.println("Send Mail failure to " + sendMailEntity.getMail());
							updateSendMail(sendMailEntity.getMail_sn(), 1);
						}
					}
				}
				System.out.println("send mail end. total:" + totalMail);
			} catch (SQLException e) {
				e.printStackTrace();
				continue;
			}finally{
				try {
					TimeUnit.SECONDS.sleep(600);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public static boolean sendSMS(SendMailEntity sendMailEntity) {
		String message = sendMailEntity.getContent();
		try {
			message = URLEncoder.encode(message,"GBK");
			Http httpsend = new Http();
			HttpRequest httpRequest = new HttpRequest(sendMailEntity.getUrl()+"?message="+message, "POST");
			httpRequest.addParameter(new HttpParameter("title", sendMailEntity.getTitle()));
			httpRequest.addParameter(new HttpParameter("personal", sendMailEntity.getPersonal()));
			httpRequest.addParameter(new HttpParameter("toAddr", sendMailEntity.getMail()));
			HttpResponse httpResponse = httpsend.getResponse(httpRequest);
			String body = httpResponse.getBody();
			if (body.equals("true")) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private void updateSendMail(int mail_sn, int result) throws SQLException {
		Connection conn52 = null;
		ResultSet rs = null;
		try {
			String sql = "UPDATE send_mail SET status=1, send_time=NOW(), result=? WHERE mail_sn=?"; 
			conn52 = getConnection();
			PreparedStatement stmt = conn52.prepareStatement(sql);
			stmt.setInt(1, result);
			stmt.setInt(2, mail_sn);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw new SQLException();
		}finally{
			if (null != rs) {
				rs.close();
			}
			try {
				conn52.close();
			}catch(Exception e) {
			}
		}
	}
	
	public List<SendMailEntity> queryMails(String mailTime) throws SQLException{
		List<SendMailEntity> sendMailList = new ArrayList<SendMailEntity>();
		Connection conn52 = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT mail_sn, content, status, url, inserttime, title, mail, personal, " +
					"send_type, send_time, result, priority FROM send_mail WHERE status = 0 AND inserttime<?" +
					"ORDER BY priority DESC LIMIT 0,100"; 
			conn52 = getConnection();
			PreparedStatement stmt = conn52.prepareStatement(sql);
			stmt.setString(1, mailTime);
			rs = stmt.executeQuery();
			while (rs.next()) {
				SendMailEntity entity = new SendMailEntity();
				entity.setMail_sn(rs.getInt("mail_sn"));
				entity.setContent(iso2gbk(rs.getString("content")));
				entity.setStatus(rs.getInt("status"));
				entity.setUrl(rs.getString("url"));
				entity.setInserttime(rs.getString("inserttime"));
				entity.setTitle(iso2gbk(rs.getString("title")));
				entity.setMail(iso2gbk(rs.getString("mail")));
				entity.setPersonal(iso2gbk(rs.getString("personal")));
				entity.setSend_type(rs.getInt("send_type"));
				entity.setSend_time(rs.getString("send_time"));
				entity.setResult(rs.getInt("result"));
				entity.setPriority(rs.getInt("priority"));
				sendMailList.add(entity);
			}
			return sendMailList;
		} catch (Exception e) {
			throw new SQLException();
		}finally{
			if (null != rs) {
				rs.close();
			}
			try {
				conn52.close();
			}catch(Exception e) {
			}
		}
	}
	
	public Connection getConnection() throws SQLException{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			String url = "jdbc:mysql://211.100.12.52:3306/smslog?useUnicode=true&amp;characterEncoding=ISO8859_1&amp;relaxAutoCommit=true&amp;&zeroDateTimeBehavior=convertToNull";
			return DriverManager.getConnection(url, "pay102", "z1f7r3");
//			String url = "jdbc:mysql://localhost:3306/smslog?useUnicode=true&amp;characterEncoding=ISO8859_1&amp;relaxAutoCommit=true&amp;&zeroDateTimeBehavior=convertToNull";
//			return DriverManager.getConnection(url, "root", "z1f7r3");
		} catch (Exception e) {
			throw new SQLException();
		}
	}
	
	public String iso2gbk(String str){
		try{
			return new String (str.getBytes("ISO8859_1"),"GBK");
		}catch (Exception e) {
			return str;
		}
	}

}
