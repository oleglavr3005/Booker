package com.epam.task.database.model;

import com.epam.task.database.model.enums.SocialNetwork;
import com.epam.task.database.model.enums.UserStatus;
import com.epam.task.database.model.enums.UserType;
import com.epam.task.database.transformers.DataBaseField;

public class User {
	@DataBaseField(fieldName = "user_id")
	private int id;
	@DataBaseField(fieldName = "first_name")
	private String firstName;
	@DataBaseField(fieldName = "last_name")
	private String lastName;
	@DataBaseField(fieldName = "e_mail")
	private String email;
	@DataBaseField(fieldName = "password")
	private String password;
	@DataBaseField(fieldName = "type")
	private UserType type; //enum
	@DataBaseField(fieldName = "is_banned")
	private boolean isBanned;
	@DataBaseField(fieldName = "confirm_code")
	private String confirmCode;
	@DataBaseField(fieldName = "status")
	private UserStatus status; //enum
	@DataBaseField(fieldName = "phone_number")
	private String phoneNumber;
	@DataBaseField(fieldName = "img")
	private String image;
	@DataBaseField(fieldName = "social_network")
	private SocialNetwork socialNetwork; //enum
	@DataBaseField(fieldName = "social_network_id")
	private String socialNetworkId;
	public User(int id, String firstName, String lastName, String email, String password, String type,
			boolean isBanned, String confirmCode, String status, String phoneNumber, String image,
			String socialNetwork, String socialNetworkId) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.type = type == null ? null : UserType.valueOf(type);
		this.isBanned = isBanned;
		this.confirmCode = confirmCode;
		this.status = status == null ? null : UserStatus.valueOf(status);
		this.phoneNumber = phoneNumber;
		this.image = image;
		this.socialNetwork = socialNetwork == null ? null : SocialNetwork.valueOf(socialNetwork);
		this.socialNetworkId = socialNetworkId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type == null ? null : UserType.valueOf(type);
	}
	public boolean isBanned() {
		return isBanned;
	}
	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}
	public String getConfirmCode() {
		return confirmCode;
	}
	public void setConfirmCode(String confirmCode) {
		this.confirmCode = confirmCode;
	}
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status == null ? null : UserStatus.valueOf(status);
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public SocialNetwork getSocialNetwork() {
		return socialNetwork;
	}
	public void setSocialNetwork(String socialNetwork) {
		this.socialNetwork = socialNetwork == null ? null : SocialNetwork.valueOf(socialNetwork);
	}
	public String getSocialNetworkId() {
		return socialNetworkId;
	}
	public void setSocialNetworkId(String socialNetworkId) {
		this.socialNetworkId = socialNetworkId;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", type=" + type + ", isBanned=" + isBanned + ", confirmCode="
				+ confirmCode + ", status=" + status + ", phoneNumber=" + phoneNumber + ", image=" + image
				+ ", socialNetwork=" + socialNetwork + ", socialNetworkId=" + socialNetworkId + "]";
	}
	
}
