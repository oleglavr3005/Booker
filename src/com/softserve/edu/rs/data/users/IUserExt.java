package com.softserve.edu.rs.data.users;

public interface IUserExt extends IUser {

	IUserExt setAddress(Address address);
	
	IUserExt setPassport(Passport passport);
	
}
