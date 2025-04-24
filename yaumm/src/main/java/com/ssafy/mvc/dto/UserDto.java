package com.ssafy.mvc.dto;

public class UserDto {
    private String userId;
    private String password;
    private int age;
    private float heightCm;
    private float weightKg;
    private String goal; // ENUM('disease_care', 'diet', 'bulk_up')

    public UserDto() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
		
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeightCm() {
		return heightCm;
	}

	public void setHeightCm(float heightCm) {
		this.heightCm = heightCm;
	}

	public float getWeightKg() {
		return weightKg;
	}

	public void setWeightKg(float weightKg) {
		this.weightKg = weightKg;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}
    
    // Getter & Setter
}
