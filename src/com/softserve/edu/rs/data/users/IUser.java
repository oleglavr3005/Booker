package com.softserve.edu.rs.data.users;

public interface IUser {

	IPerson getPerson();

	IAccount getAccount();

	IAddress getAddress();

	IPassport getPassport();
	
}
