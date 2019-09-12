package com.xyz.requi.model;

import java.util.Date;

public class AppUser {
    
	 
    private Long userId;
    private String clientName;
    private String designation;
    private Date date;
    private String location;
    private boolean enabled;
    private String gender;
    private String description;
    //private String encrytedPassword;
     
    private String stackCode;
 
    public AppUser() {
 
    }
 
    public AppUser(Long userId, String clientName, String designation,Date date, String location, 
            boolean enabled, String gender, 
            String description,String stackCode) {
        super();
        this.userId = userId;
        this.clientName = clientName;
        this.designation = designation;
        this.date = date;
        this.location = location;
        this.enabled = enabled;
        this.gender = gender;
        this.description = description;
        this.stackCode= stackCode;
        //this.encrytedPassword = encrytedPassword;
    }
 
    public Long getUserId() {
        return userId;
    }
 
    public void setUserId(Long userId) {
        this.userId = userId;
    }
 
    public String getClientName() {
        return clientName;
    }
 
    public void setUserName(String clientName) {
        this.clientName = clientName;
    }
 
    

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	
 
   

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isEnabled() {
        return enabled;
    }
 
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
 
    public String getGender() {
        return gender;
    }
 
    public void setGender(String gender) {
        this.gender = gender;
    }
 
    
 
    //public String getEncrytedPassword() {
       // return encrytedPassword;
    //}
 
    //public void setEncrytedPassword(String encrytedPassword) {
      //  this.encrytedPassword = encrytedPassword;
    //}
 
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStackCode() {
		return stackCode;
	}

	public void setStackCode(String stackCode) {
		this.stackCode = stackCode;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
 
}