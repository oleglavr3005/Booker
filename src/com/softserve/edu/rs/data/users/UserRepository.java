package com.softserve.edu.rs.data.users;

public final class UserRepository {
    private static volatile UserRepository instance = null;

	private UserRepository() {
	}
	
    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    // TODO
	//public IUser getAdmin()
	//public IUser getRegistrator()
	//public IUser getCommissioner()
	//public IUser getCoOwner()
	//public IUser getNewUser()
	//
	//public List<IUser> getAdminDB()
	
	public IUser getAdmin() {
		// TODO Read from file
		return User.get()
					.setPerson(Person.get()
									.setFirstname("Адміністратор")
									.setLastname("Адміністратор")
									.setEmail("admin@admin.com")
									.build()
									.setMiddlename("Адміністратор")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
									.setLogin("admin")
									.setPassword("admin")
									.setRole("Адміністратор")
									.setStatus("Активний")
									.setCommunity("Україна")
									.build()
									.setData("")
									.setRegisterNumber("0")
									.setRegistratorNumber("0")
									.setVolumeNumber("0")
							)
					.build()
					.setAddress(Address.get()
							.setRegion("Львівська")
							.setDistrict("Галицький")
							.setCity("Львів")
							.setStreet("Вітовського")
							.setBuilding("48")
							.setFlat("31")
							.setPostcode("00000")
							)
					.setPassport(Passport.get()
							.setSeria("AA")
							.setNumber("00000")
							.setPublished("Народом України")
							);
	}
	public IUser getRegistrator() {
		// TODO Read from file
		return User.get()
					.setPerson(Person.get()
									.setFirstname("Пилип")
									.setLastname("Караган")
									.setEmail("rex@hh.ua")
									.build()
									.setMiddlename("Петрович")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
									.setLogin("rex123")
									.setPassword("rex123")
									.setRole("Регістратор")
									.setStatus("Активний")
									.setCommunity("Україна")
									.build()
									.setData("")
									.setRegisterNumber("0")
									.setRegistratorNumber("35445345")
									.setVolumeNumber("35445345")
							)
					.build()
					.setAddress(Address.get()
							.setRegion("Львівська")
							.setDistrict("Шевченківський")
							.setCity("Львів")
							.setStreet("Мазепи")
							.setBuilding("12")
							.setFlat("4")
							.setPostcode("")
							)
					.setPassport(Passport.get()
							.setSeria("КА")
							.setNumber("343553")
							.setPublished("Народом України")
							);
	}

	public IUser getCommissioner() {
		// TODO Read from file
		return User.get()
					.setPerson(Person.get()
									.setFirstname("Андрій")
									.setLastname("Іванов")
									.setEmail("andr@gmail.com")
									.build()
									.setMiddlename("Петрович")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
									.setLogin("commissioner")
									.setPassword("commissioner")
									.setRole("Адміністратор")
									.setStatus("Активний")
									.setCommunity("Україна")
									.build()
									.setData("")
									.setRegisterNumber("0")
									.setRegistratorNumber("0")
									.setVolumeNumber("0")
							)
					.build()
					.setAddress(Address.get()
							.setRegion("Киівська")
							.setDistrict("Троєщина")
							.setCity("Львів")
							.setStreet("Стрийська")
							.setBuilding("43")
							.setFlat("43")
							.setPostcode("34345")
							)
					.setPassport(Passport.get()
							.setSeria("КС")
							.setNumber("43545")
							.setPublished("Львівським")
							);
	}

	public IUser getEmpty() {
		// TODO Read from file
		return User.get()
					.setPerson(Person.get()
									.setFirstname("")
									.setLastname("")
									.setEmail("")
									.build()
									.setMiddlename("")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
									.setLogin("")
									.setPassword("")
									.setRole("")
									.setStatus("")
									.setCommunity("")
									.build()
									.setData("")
									.setRegisterNumber("")
									.setRegistratorNumber("")
									.setVolumeNumber("")
							)
					.build()
					.setAddress(Address.get()
							.setRegion("")
							.setDistrict("")
							.setCity("")
							.setStreet("")
							.setBuilding("")
							.setFlat("")
							.setPostcode("")
							)
					.setPassport(Passport.get()
							.setSeria("")
							.setNumber("")
							.setPublished("")
							);
	}
	
}
