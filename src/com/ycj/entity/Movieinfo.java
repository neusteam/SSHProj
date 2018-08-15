package com.ycj.entity;

import java.util.Date;

/**
 * Movieinfo entity. @author MyEclipse Persistence Tools
 */

public class Movieinfo implements java.io.Serializable {

	// Fields

	private Integer movieId;
	private String moviename;
	private Date date;
	private String director;
	private String actor;
	private String type;
	private String country;
	private String language;
	private String picture;
	private Float average;
	private String moviedescribe;

	// Constructors

	/** default constructor */
	public Movieinfo() {
	}

	/** minimal constructor */
	public Movieinfo(String moviename) {
		this.moviename = moviename;
	}

	/** full constructor */
	public Movieinfo(String moviename, Date date, String director, String actor, String type, String country,
			String language, String picture, Float average, String moviedescribe) {
		this.moviename = moviename;
		this.date = date;
		this.director = director;
		this.actor = actor;
		this.type = type;
		this.country = country;
		this.language = language;
		this.picture = picture;
		this.average = average;
		this.moviedescribe = moviedescribe;
	}

	// Property accessors

	public Integer getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMoviename() {
		return this.moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return this.actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Float getAverage() {
		return this.average;
	}

	public void setAverage(Float average) {
		this.average = average;
	}

	public String getMoviedescribe() {
		return this.moviedescribe;
	}

	public void setMoviedescribe(String moviedescribe) {
		this.moviedescribe = moviedescribe;
	}

	@Override
	public String toString() {
		return "{\"movieId\":\"" + movieId + "\",\"moviename\":\"" + moviename + "\",\"date\":\"" + date
				+ "\",\"director\":\"" + director + "\",\"actor\":\"" + actor + "\",\"type\":\"" + type
				+ "\",\"country\":\"" + country + "\",\"language\":\"" + language + "\",\"picture\":\"" + picture
				+ "\",\"average\":\"" + average + "\",\"moviedescribe\":\"" + moviedescribe + "\"}";
	}

}