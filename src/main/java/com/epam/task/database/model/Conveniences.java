package com.epam.task.database.model;

public class Conveniences {
	private boolean WiFi;
	private boolean Shower;
	private boolean Parking;
	private boolean Condition;
	private boolean Pool;
	private boolean Gym;
	private boolean Balcony;
	
	public Conveniences(boolean WiFi, boolean Shower, boolean Parking, boolean Condition, boolean Pool,
			boolean Gym, boolean Balcony) {
		super();
		this.WiFi = WiFi;
		this.Shower = Shower;
		this.Parking = Parking;
		this.Condition = Condition;
		this.Pool = Pool;
		this.Gym = Gym;
		this.Balcony = Balcony;
	}
	
	public boolean isWiFi() {
		return WiFi;
	}
	public void setWiFi(boolean WiFi) {
		this.WiFi = WiFi;
	}
	public boolean isShower() {
		return Shower;
	}
	public void setShower(boolean Shower) {
		this.Shower = Shower;
	}
	public boolean isParking() {
		return Parking;
	}
	public void setParking(boolean Parking) {
		this.Parking = Parking;
	}
	public boolean isCondition() {
		return Condition;
	}
	public void setCondition(boolean Condition) {
		this.Condition = Condition;
	}
	public boolean isPool() {
		return Pool;
	}
	public void setPool(boolean Pool) {
		this.Pool = Pool;
	}
	public boolean isGym() {
		return Gym;
	}
	public void setGym(boolean Gym) {
		this.Gym = Gym;
	}
	public boolean isBalcony() {
		return Balcony;
	}
	public void setBalcony(boolean Balcony) {
		this.Balcony = Balcony;
	}

	@Override
	public String toString() {
		return "Conveniences [WiFi=" + WiFi + ", Shower=" + Shower + ", Parking=" + Parking + ", Condition=" + Condition
				+ ", Pool=" + Pool + ", Gym=" + Gym + ", Balcony=" + Balcony + "]";
	}
}
