package com.ycj.entity;

import java.util.Date;

/**
 * Actorinfo entity. @author MyEclipse Persistence Tools
 */

public class Actorinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String actorname;
	private String sex;
	private Date birth;
	private String hometown;
	private String occupation;
	private String actordescribe;
	private String url;

	// Constructors

	/** default constructor */
	public Actorinfo() {
	}

	/** full constructor */
	public Actorinfo(String actorname, String sex, Date birth, String hometown, String occupation, String actordescribe,
			String url) {
		this.actorname = actorname;
		this.sex = sex;
		this.birth = birth;
		this.hometown = hometown;
		this.occupation = occupation;
		this.actordescribe = actordescribe;
		this.url = url;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActorname() {
		return this.actorname;
	}

	public void setActorname(String actorname) {
		this.actorname = actorname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getHometown() {
		return this.hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getActordescribe() {
		return this.actordescribe;
	}

	public void setActordescribe(String actordescribe) {
		this.actordescribe = actordescribe;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"actorname\":\"" + actorname + "\",\"sex\":\"" + sex + "\",\"birth\":\"" + birth
				+ "\",\"hometown\":\"" + hometown + "\",\"occupation\":\"" + occupation + "\",\"actordescribe\":\""
				+ actordescribe + "\",\"url\":\"" + url + "\"}";
	}

}