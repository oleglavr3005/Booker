package com.softserve.edu.rs.data.users;

interface IPersonUser {
	IAccountUser setPerson(IPerson person);
}

interface IAccountUser {
	IBuildUser setAccount(IAccount account);
}

interface IBuildUser {
	IUserExt build();
}

public class User implements IPersonUser, IAccountUser, IBuildUser, IUserExt {

	private IPerson person;
	private IAccount account;
	private IAddress address;
	private IPassport passport;
	
	private User(){
		this.address = Address.get();
		this.passport = Passport.get();
	}
	
	// Delete
//	public User(Person person, Account account, Address adress, Passport passport) {
//		this.person = person;
//		this.account = account;
//		this.adress = adress;
//		this.passport = passport;
//	}

	// static factory - - - - - - - - - -
	
	public static IPersonUser get() {
		return new User();
	}

	// set - - - - - - - - - -

//	public IFirstname setPerson() {
//		return Person.get();
//	}
	
	public IAccountUser setPerson(IPerson person) {
		this.person = person;
		return this;
	}

	public IBuildUser setAccount(IAccount account) {
		this.account = account;
		return this;
	}

	public IUserExt build() {
		return this;
	}

	public IUserExt setAddress(Address address) {
		this.address = address;
		return this;
	}

	public IUserExt setPassport(Passport passport) {
		this.passport = passport;
		return this;
	}

	// get - - - - - - - - - -

	public IPerson getPerson() {
		return person;
	}

	public IAccount getAccount() {
		return account;
	}

	public IAddress getAddress() {
		return address;
	}

	public IPassport getPassport() {
		return passport;
	}

}
