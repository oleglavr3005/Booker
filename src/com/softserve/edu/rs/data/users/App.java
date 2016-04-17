package com.softserve.edu.rs.data.users;

public class App {

	public static void main(String[] args) {
		// 1 using constructor
		//Person person = new Person("as","asa","qwe","sds","wswe");
		//
		// 2 using sets
		//Person person = new Person();
		//person.setFirstname("ass");
		//person.setLastname("asda");
		//person.setEmail("sds");
		//
		//person.setMiddlename("ass");
		//person.setPhonenumber("zdadas");
		//
		// 3 Fluent interface
		//Person person = new Person()
		//		.setFirstname("firstname")
		//		.setLastname("lastname")
		//		.setEmail("email");
		//person.setMiddlename("middlename")
		//	.setPhonenumber("phonenumber");
		//
		// 4 Use static factory
		//Person person = Person.get()
		//		.setFirstname("firstname")
		//		//.setLastname("lastname")
		//		.setEmail("email");
		//person.setMiddlename("middlename")
		//	.setPhonenumber("phonenumber");
		//
		// 4 Use builder
		IPerson person = Person.get()
				.setFirstname("firstname")
				.setLastname("lastname")
				.setEmail("email")
				.build();
		((Person)person).setMiddlename("middlename")
			.setPhonenumber("phonenumber");
		//
//		User user = User.get().setPerson()
//				.setFirstname("firstname")
//				.setLastname("lastname")
//				.setEmail("email")
//				.build();
		IUser user = User.get()
				.setPerson(
						Person.get()
							.setFirstname("firstname")
							.setLastname("lastname")
							.setEmail("email")
							.build()
							.setMiddlename("middlename")
						)
				.setAccount(
						Account.get()
							.setLogin("login")
							.setPassword("password")
							.setRole("")
							.setStatus("")
							.setCommunity("community")
							.build()
							.setData("data")
						)
				.build();
		((Address)(user.getAddress())).setCity("city").setDistrict("dis");
	}
	
}
