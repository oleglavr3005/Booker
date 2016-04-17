package com.softserve.edu.rs.data.users;

interface ILogin {
	IPassword setLogin(String login);
}

interface IPassword {
	IRole setPassword(String password);
}

interface IRole {
	IStatus setRole(String role);
}

interface IStatus {
	ICommunity setStatus(String status);
}

interface ICommunity {
	IBuildAccount setCommunity(String community);
}

interface IBuildAccount {
	IAccountExt build();
}

public class Account implements ILogin, IPassword, IRole, IStatus, ICommunity, IBuildAccount, IAccountExt {

	private String login;
	private String password;
	private String role;
	private String status;
	private String community;
	private String data;
	private String registerNumber;
	private String registratorNumber;
	private String volumeNumber;

	private Account() {
		this.data = new String();
	}

	// Delete
	// public Account(String login, String password, String community, String
	// data) {
	// this.login = login;
	// this.password = password;
	// this.community = community;
	// this.data = data;
	// }

	// static factory - - - - - - - - - -
	
	public static ILogin get() {
		return new Account();
	}

	// set - - - - - - - - - -

	public IPassword setLogin(String login) {
		this.login = login;
		return this;
	}

	public IRole setPassword(String password) {
		this.password = password;
		return this;
	}

	public IStatus setRole(String role) {
		this.role = role;
		return this;
	}

	public ICommunity setStatus(String status) {
		this.status = status;
		return this;
	}

	public IBuildAccount setCommunity(String community) {
		this.community = community;
		return this;
	}

	public IAccountExt build() {
		return this;
	}

	public IAccountExt setData(String data) {
		this.data = data;
		return this;
	}

	public IAccountExt setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
		return this;
	}

	public IAccountExt setRegistratorNumber(String registratorNumber) {
		this.registratorNumber = registratorNumber;
		return this;
	}

	public IAccountExt setVolumeNumber(String volumeNumber) {
		this.volumeNumber = volumeNumber;
		return this;
	}
	
	// get - - - - - - - - - -

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getStatus() {
		return status;
	}

	public String getCommunity() {
		return community;
	}

	public String getData() {
		return data;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public String getRegistratorNumber() {
		return registratorNumber;
	}

	public String getVolumeNumber() {
		return volumeNumber;
	}

}
