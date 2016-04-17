package com.softserve.edu.rs.data.users;

public class Passport implements IPassport {

	private String seria;
	private String number;
	private String published;

	public Passport() {
		this.seria = new String();
		this.number = new String();
		this.published = new String();
	}
	
	public Passport(String seria, String number, String published) {
		this.seria = seria;
		this.number = number;
		this.published = published;
	}

	// static factory - - - - - - - - - -
	
	public static Passport get() {
		return new Passport();
	}

	// set - - - - - - - - - -

	public Passport setSeria(String seria) {
		this.seria = seria;
		return this;
	}

	public Passport setNumber(String number) {
		this.number = number;
		return this;
	}

	public Passport setPublished(String published) {
		this.published = published;
		return this;
	}

	// get - - - - - - - - - -

	public String getSeria() {
		return seria;
	}

	public String getNumber() {
		return number;
	}

	public String getPublished() {
		return published;
	}

}
