package com.xyz.requi.model;

public class Country {
	 
    private String stackCode;
    private String countryName;
 
    public Country() {
 
    }
 
    public Country(String stackCode, String countryName) {
        this.stackCode = stackCode;
        this.countryName = countryName;
    }
 
    public String getStackCode() {
        return stackCode;
    }
 
    public void setCountryCode(String countryCode) {
        this.stackCode = stackCode;
    }
 
    public String getCountryName() {
        return countryName;
    }
 
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}