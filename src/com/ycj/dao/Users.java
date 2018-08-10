package com.ycj.dao;

import java.util.Date;


/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String username;
     private String password;
     private Integer status;
     private String sex;
     private Integer phonenumber;
     private String email;
     private String city;
     private Date birth;
     private String url;


    // Constructors

    /** default constructor */
    public Users() {
    }

	/** minimal constructor */
    public Users(String username, String password, Integer status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }
    
    /** full constructor */
    public Users(String username, String password, Integer status, String sex, Integer phonenumber, String email, String city, Date birth, String url) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.sex = sex;
        this.phonenumber = phonenumber;
        this.email = email;
        this.city = city;
        this.birth = birth;
        this.url = url;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPhonenumber() {
        return this.phonenumber;
    }
    
    public void setPhonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public Date getBirth() {
        return this.birth;
    }
    
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"username\":\"" + username + "\",\"password\":\"" + password
				+ "\",\"status\":\"" + status + "\",\"sex\":\"" + sex + "\",\"phonenumber\":\"" + phonenumber
				+ "\",\"email\":\"" + email + "\",\"city\":\"" + city + "\",\"birth\":\"" + birth + "\",\"url\":\""
				+ url + "\"}";
	}
   








}