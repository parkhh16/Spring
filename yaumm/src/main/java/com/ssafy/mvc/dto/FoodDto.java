package com.ssafy.mvc.dto;

public class FoodDto {
    private String foodCode;
    private String foodName;
    private float energyKcal;
    private float proteinG;
    private float fatG;
    private float carbohydrateG;
    private float sugarG;
    private float fiberG;
    private float calciumMg;
    private float ironMg;
    private float phosphorusMg;
    private float potassiumMg;
    private float sodiumMg;
    private float vitaminAUg;
    private float vitaminCMg;
    private float vitaminDUg;
    private float cholesterolMg;
    private float saturatedFatG;
    private float transFatG;
    private float vitaminB12Ug;

    // 기본 생성자
    public FoodDto() {}
    

	public String getFoodCode() {
		return foodCode;
	}


	public void setFoodCode(String foodCode) {
		this.foodCode = foodCode;
	}


	public String getFoodName() {
		return foodName;
	}


	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}


	public float getEnergyKcal() {
		return energyKcal;
	}


	public void setEnergyKcal(float energyKcal) {
		this.energyKcal = energyKcal;
	}


	public float getProteinG() {
		return proteinG;
	}


	public void setProteinG(float proteinG) {
		this.proteinG = proteinG;
	}


	public float getFatG() {
		return fatG;
	}


	public void setFatG(float fatG) {
		this.fatG = fatG;
	}


	public float getCarbohydrateG() {
		return carbohydrateG;
	}


	public void setCarbohydrateG(float carbohydrateG) {
		this.carbohydrateG = carbohydrateG;
	}


	public float getSugarG() {
		return sugarG;
	}


	public void setSugarG(float sugarG) {
		this.sugarG = sugarG;
	}


	public float getFiberG() {
		return fiberG;
	}


	public void setFiberG(float fiberG) {
		this.fiberG = fiberG;
	}


	public float getCalciumMg() {
		return calciumMg;
	}


	public void setCalciumMg(float calciumMg) {
		this.calciumMg = calciumMg;
	}


	public float getIronMg() {
		return ironMg;
	}


	public void setIronMg(float ironMg) {
		this.ironMg = ironMg;
	}


	public float getPhosphorusMg() {
		return phosphorusMg;
	}


	public void setPhosphorusMg(float phosphorusMg) {
		this.phosphorusMg = phosphorusMg;
	}


	public float getPotassiumMg() {
		return potassiumMg;
	}


	public void setPotassiumMg(float potassiumMg) {
		this.potassiumMg = potassiumMg;
	}


	public float getSodiumMg() {
		return sodiumMg;
	}


	public void setSodiumMg(float sodiumMg) {
		this.sodiumMg = sodiumMg;
	}


	public float getVitaminAUg() {
		return vitaminAUg;
	}


	public void setVitaminAUg(float vitaminAUg) {
		this.vitaminAUg = vitaminAUg;
	}


	public float getVitaminCMg() {
		return vitaminCMg;
	}


	public void setVitaminCMg(float vitaminCMg) {
		this.vitaminCMg = vitaminCMg;
	}


	public float getVitaminDUg() {
		return vitaminDUg;
	}


	public void setVitaminDUg(float vitaminDUg) {
		this.vitaminDUg = vitaminDUg;
	}


	public float getCholesterolMg() {
		return cholesterolMg;
	}


	public void setCholesterolMg(float cholesterolMg) {
		this.cholesterolMg = cholesterolMg;
	}


	public float getSaturatedFatG() {
		return saturatedFatG;
	}


	public void setSaturatedFatG(float saturatedFatG) {
		this.saturatedFatG = saturatedFatG;
	}


	public float getTransFatG() {
		return transFatG;
	}


	public void setTransFatG(float transFatG) {
		this.transFatG = transFatG;
	}


	public float getVitaminB12Ug() {
		return vitaminB12Ug;
	}


	public void setVitaminB12Ug(float vitaminB12Ug) {
		this.vitaminB12Ug = vitaminB12Ug;
	}
	


	@Override
	public String toString() {
		return "FoodDto [foodCode=" + foodCode + ", foodName=" + foodName + ", energyKcal=" + energyKcal + ", proteinG="
				+ proteinG + ", fatG=" + fatG + ", carbohydrateG=" + carbohydrateG + ", sugarG=" + sugarG + ", fiberG="
				+ fiberG + ", calciumMg=" + calciumMg + ", ironMg=" + ironMg + ", phosphorusMg=" + phosphorusMg
				+ ", potassiumMg=" + potassiumMg + ", sodiumMg=" + sodiumMg + ", vitaminAUg=" + vitaminAUg
				+ ", vitaminCMg=" + vitaminCMg + ", vitaminDUg=" + vitaminDUg + ", cholesterolMg=" + cholesterolMg
				+ ", saturatedFatG=" + saturatedFatG + ", transFatG=" + transFatG + ", vitaminB12Ug=" + vitaminB12Ug
				+ "]";
	}

    // Getter & Setter
    // lombok 쓰면 @Getter @Setter @AllArgsConstructor 가능
    // 여기에 코드 생략 가능 — 필요 시 요청해줘
}
