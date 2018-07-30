package com.example.abhil.ass1;

public class BMIResult {
    private double height =1;
    private double weight =1;
	private double bmi=1;
	private String date;
	public BMIResult(){}
    public BMIResult(double height, double weight){

        this.height=height;
        this.weight=weight;
		this.bmi=bmi;
		this.date=date;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
 public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
    public double getResult(){
        return (weight/(height*height));
    }

    public String toString(){
      return String.valueOf(getBmi())+"           "+getDate();   
    }

}

