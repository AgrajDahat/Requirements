package com.xyz.requi.validator;

import org.apache.commons.validator.routines.EmailValidator;
import com.xyz.requi.dao.AppUserDAO;
import com.xyz.requi.formbean.AppUserForm;
import com.xyz.requi.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
 
@Component
public class AppUserValidator implements Validator {
 
    
    private EmailValidator emailValidator = EmailValidator.getInstance();
 
    @Autowired
    private AppUserDAO appUserDAO;
 
    
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == AppUserForm.class;
    }
 
    @Override
    public void validate(Object target, Errors errors) {
        AppUserForm appUserForm = (AppUserForm) target;
 
       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clientName", "NotEmpty.appUserForm.clientName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designation", "NotEmpty.appUserForm.designation");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "NotEmpty.appUserForm.location");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty.appUserForm.description");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "NotEmpty.appUserForm.date");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.appUserForm.password");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.appUserForm.confirmPassword");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty.appUserForm.gender");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stackCode", "NotEmpty.appUserForm.stackCode");
 
       // if (!this.emailValidator.isValid(appUserForm.getDescription())) {
            
         //   errors.rejectValue("email", "Pattern.appUserForm.email");
        //} else if (appUserForm.getUserId() == null) {
          //  AppUser dbUser = appUserDAO.findAppUserByEmail(appUserForm.getDescription());
            //if (dbUser != null) {
                
              //  errors.rejectValue("email", "Duplicate.appUserForm.email");
            //}
        //}
 
        if (!errors.hasFieldErrors("clientName")) {
            AppUser dbUser = appUserDAO.findAppUserByClientName(appUserForm.getClientName());
            if (dbUser != null) {
                
                errors.rejectValue("clientName", "Duplicate.appUserForm.clientName");
            }
        }
 
       
        }
    }
 

