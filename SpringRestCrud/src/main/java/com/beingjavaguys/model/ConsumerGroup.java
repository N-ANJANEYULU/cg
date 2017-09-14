package com.beingjavaguys.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "consumer_groups")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ConsumerGroup implements Serializable {
	private static long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "consumergroup_id")
	private Integer consumergroupid;

	@Column(name = "consumer_id")
	private Integer consumerid;

	@Column(name = "brand")
	private String brand;

	@Column(name = "Mbu")
	private String mbu;

	@Column(name = "region")
	private String region;

	@Column(name = "hc_ID")
	private Integer hcid;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "Group_ID")
	private Integer groupid;

	@Column(name = "Member_NO")
	private Integer memberNo;

	@Column(name = "Create_Dt")
	private Date createDt;

	@Column(name = "Create_ID")
	private Integer createid;

	public Integer getConsumergroupid() {
		return consumergroupid;
	}

	public void setConsumergroupid(Integer consumergroupid) {
		this.consumergroupid = consumergroupid;
	}



	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getConsumerid() {
		return consumerid;
	}

	public void setConsumerid(Integer consumerid) {
		this.consumerid = consumerid;
	}

	public String getMbu() {
		return mbu;
	}

	public void setMbu(String mbu) {
		this.mbu = mbu;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getHcid() {
		return hcid;
	}

	public void setHcid(Integer hcid) {
		this.hcid = hcid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Integer getCreateid() {
		return createid;
	}

	public void setCreateid(Integer createid) {
		this.createid = createid;
	}


}