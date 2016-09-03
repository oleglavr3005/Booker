package com.epam.task.database.model;

public class Conveniences {
	private boolean wiFi;
	private boolean shower;
	private boolean parking;
	private boolean condition;
	private boolean pool;
	private boolean gym;
	private boolean balcony;
	public Conveniences(boolean wiFi, boolean shower, boolean parking, boolean condition, boolean pool, boolean gym,
			boolean balcony) {
		super();
		this.wiFi = wiFi;
		this.shower = shower;
		this.parking = parking;
		this.condition = condition;
		this.pool = pool;
		this.gym = gym;
		this.balcony = balcony;
	}
	public boolean isWiFi() {
		return wiFi;
	}
	public void setWiFi(boolean wiFi) {
		this.wiFi = wiFi;
	}
	public boolean isShower() {
		return shower;
	}
	public void setShower(boolean shower) {
		this.shower = shower;
	}
	public boolean isParking() {
		return parking;
	}
	public void setParking(boolean parking) {
		this.parking = parking;
	}
	public boolean isCondition() {
		return condition;
	}
	public void setCondition(boolean condition) {
		this.condition = condition;
	}
	public boolean isPool() {
		return pool;
	}
	public void setPool(boolean pool) {
		this.pool = pool;
	}
	public boolean isGym() {
		return gym;
	}
	public void setGym(boolean gym) {
		this.gym = gym;
	}
	public boolean isBalcony() {
		return balcony;
	}
	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}
	@Override
	public String toString() {
		return "Conveniences [wiFi=" + wiFi + ", shower=" + shower + ", parking=" + parking + ", condition=" + condition
				+ ", pool=" + pool + ", gym=" + gym + ", balcony=" + balcony + "]";
	}
}
