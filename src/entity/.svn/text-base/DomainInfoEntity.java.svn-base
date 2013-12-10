package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author huang.die
 */
@Entity
@Table(name="domain_info")
public class DomainInfoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int domain_sn;
	
	@Column(name="domain_id",nullable=false, length=32)
	private String domain_id; //商户网站的ID号
	
	@Column(name="domain_name",nullable=false, length=80)
	private String domain_name; //商户网站的名称
	
	@Column(name="domain_desc",nullable=false, length=30)
	private String domain_desc; //商户网站的描述
	
	@Column(name="domain_ip",nullable=false, length=100)
	private String domain_ip; //商户网站的IP地址，最多支持5个IP
	
	@Column(name="domain_key",nullable=false, length=32)
	private String domain_key;   //商户网站的密钥
	
	@Column(name="insert_time",nullable=false, length=19)
	private Date insert_time; //添加的时间
	
	@Column(name="update_time",nullable=false, length=19)
	private Date update_time; //最后更新的时间
	
	public void setDomain_sn(int domain_sn) {
		this.domain_sn = domain_sn;
	}
	public int getDomain_sn() {
		return domain_sn;
	}
	public void setDomain_id(String domain_id) {
		this.domain_id = domain_id;
	}
	public String getDomain_id() {
		return domain_id;
	}
	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}
	public String getDomain_name() {
		return domain_name;
	}
	public void setDomain_desc(String domain_desc) {
		this.domain_desc = domain_desc;
	}
	public String getDomain_desc() {
		return domain_desc;
	}
	public void setDomain_ip(String domain_ip) {
		this.domain_ip = domain_ip;
	}
	public String getDomain_ip() {
		return domain_ip;
	}
	public void setDomain_key(String domain_key) {
		this.domain_key = domain_key;
	}
	public String getDomain_key() {
		return domain_key;
	}
	public void setInsert_time(Date insert_time) {
		this.insert_time = insert_time;
	}
	public Date getInsert_time() {
		return insert_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}

}
