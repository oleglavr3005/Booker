package com.softserve.edu.rs.data.users;

public class Address implements IAddress {

	private String city;
	private String region;
	private String district;
	private String street;
	private String building;
	private String flat;
	private String postcode;

	public Address(){
		this.city = new String();
		this.region = new String();
		this.district = new String();
		this.street = new String();
		this.building = new String();
		this.flat = new String();
		this.postcode = new String();
	}
	
	// Delete
//	public Address(String city, String region, String district, String street, String building, String flat,
//			String postcode) {
//		this.city = city;
//		this.region = region;
//		this.district = district;
//		this.street = street;
//		this.building = building;
//		this.flat = flat;
//		this.postcode = postcode;
//	}

	// static factory - - - - - - - - - -
	
	public static Address get() {
		return new Address();
	}

	// set - - - - - - - - - -

	public Address setCity(String city) {
		this.city = city;
		return this;
	}

	public Address setRegion(String region) {
		this.region = region;
		return this;
	}

	public Address setDistrict(String district) {
		this.district = district;
		return this;
	}

	public Address setStreet(String street) {
		this.street = street;
		return this;
	}

	public Address setBuilding(String building) {
		this.building = building;
		return this;
	}

	public Address setFlat(String flat) {
		this.flat = flat;
		return this;
	}

	public Address setPostcode(String postcode) {
		this.postcode = postcode;
		return this;
	}

	// get - - - - - - - - - -

	public String getCity() {
		return city;
	}

	public String getRegion() {
		return region;
	}

	public String getDistrict() {
		return district;
	}

	public String getStreet() {
		return street;
	}

	public String getBuilding() {
		return building;
	}

	public String getFlat() {
		return flat;
	}

	public String getPostcode() {
		return postcode;
	}

}
