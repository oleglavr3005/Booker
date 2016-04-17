package com.softserve.edu.rs.data;

public class Coordinate {
	 private int degrees;
	 private  int minutes;
	 public int getDegrees() {
		return degrees;
	}
	public void setDegrees(int degrees) {
		this.degrees = degrees;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public double getSeconds() {
		return seconds;
	}
	public void setSeconds(double seconds) {
		this.seconds = seconds;
	}

	private double seconds;
	  Coordinate(Coordinate coord){
		  degrees=coord.degrees;
		  minutes=coord.minutes;
		  seconds=coord.seconds;  
	  }
	  public Coordinate(int d,int m,double e){
		  degrees=d;
		  minutes=m;
		  seconds=e;  
	  }
	  
	  Coordinate(float deg){
		  degrees=(int)deg;
		  minutes=(int)((deg-degrees)*60);
		  seconds=deg*3600%60;  
	  }
	  
	  public double toDouble(){
		  return degrees+(double)minutes/60+seconds/3600;
	  }
	  
	  public String toString(){
		  return  Double.toString(degrees+(double)minutes/60+seconds/3600);
	  }
}
