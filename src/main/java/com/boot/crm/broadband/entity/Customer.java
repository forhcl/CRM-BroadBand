package com.boot.crm.broadband.entity;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
/**
 * 客户持久化类
 */
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer cust_id;         // 客户编号
	@NotBlank(message = "客户名称不能为空")
	private String cust_name;        // 客户名称
	private String cust_major;       //客户专业
	private String cust_level;       //客户级别
	private Integer cust_create_id;  // 创建人id
	private String cust_linkman;     // 联系人
	private String cust_phone;       // 固定电话
	private String cust_mobile;      // 移动电话
	private String cust_zipcode;     // 邮政编码
	private String cust_address;     // 联系地址
	private Date cust_createtime;    // 创建时间

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_major() {
		return cust_major;
	}

	public void setCust_major(String cust_major) {
		this.cust_major = cust_major;
	}

	public String getCust_level() {
		return cust_level;
	}

	public void setCust_level(String cust_level) {
		this.cust_level = cust_level;
	}

	public Integer getCust_create_id() {
		return cust_create_id;
	}

	public void setCust_create_id(Integer cust_create_id) {
		this.cust_create_id = cust_create_id;
	}

	public String getCust_linkman() {
		return cust_linkman;
	}

	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

	public String getCust_zipcode() {
		return cust_zipcode;
	}

	public void setCust_zipcode(String cust_zipcode) {
		this.cust_zipcode = cust_zipcode;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public Date getCust_createtime() {
		return cust_createtime;
	}

	public void setCust_createtime(Date cust_createtime) {
		this.cust_createtime = cust_createtime;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"cust_id=" + cust_id +
				", cust_name='" + cust_name + '\'' +
				", cust_major='" + cust_major + '\'' +
				", cust_level='" + cust_level + '\'' +
				", cust_create_id=" + cust_create_id +
				", cust_linkman='" + cust_linkman + '\'' +
				", cust_phone='" + cust_phone + '\'' +
				", cust_mobile='" + cust_mobile + '\'' +
				", cust_zipcode='" + cust_zipcode + '\'' +
				", cust_address='" + cust_address + '\'' +
				", cust_createtime=" + cust_createtime +
				'}';
	}
}
