package com.xyz.requi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xyz.requi.dao.AppUserDAO;
import com.xyz.requi.dao.CountryDAO;
import com.xyz.requi.formbean.AppUserForm;
import com.xyz.requi.model.AppUser;
import com.xyz.requi.model.Country;
import com.xyz.requi.validator.AppUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
// import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
@Controller
public class MainController {
 
   @Autowired
   private AppUserDAO appUserDAO;
 
   @Autowired
   private CountryDAO countryDAO;
 
   @Autowired
   private AppUserValidator appUserValidator;
 
   
   
   @InitBinder
   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
       SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");   
       dateFormat.setLenient(false);
       binder.registerCustomEditor(Date.class, null,  new CustomDateEditor(dateFormat, true));
       
       
   }
   
   @InitBinder
   protected void initBinder(WebDataBinder dataBinder) {
      
      Object target = dataBinder.getTarget();
      if (target == null) {
         return;
      }
      System.out.println("Target=" + target);
 
      if (target.getClass() == AppUserForm.class) {
         dataBinder.setValidator(appUserValidator);
      }
      
   }
 
   @RequestMapping("/")
   public String viewHome(Model model) {
 
      return "welcomePage";
   }
 
   @RequestMapping("/members")
   public String viewMembers(Model model) {
 
      List<AppUser> list = appUserDAO.getAppUsers();
 
      model.addAttribute("members", list);
 
      return "membersPage";
   }
 
   @RequestMapping("/registerSuccessful")
   public String viewRegisterSuccessful(Model model) {
 
      return "registerSuccessfulPage";
   }
 
   
   @RequestMapping(value = "/requirement", method = RequestMethod.GET)
   public String viewRegister(Model model) {
 
      AppUserForm form = new AppUserForm();
      List<Country> countries = countryDAO.getCountries();
 
      model.addAttribute("appUserForm", form);
      model.addAttribute("countries", countries);
 
      return "requirementPage";
   }
 
   
   @RequestMapping(value = "/requirement", method = RequestMethod.POST)
   public String saveRegister(Model model, 
         @ModelAttribute("appUserForm") @Validated AppUserForm appUserForm, 
         BindingResult result, 
         final RedirectAttributes redirectAttributes) {
 
      
      if (result.hasErrors()) {
         List<Country> countries = countryDAO.getCountries();
         model.addAttribute("countries", countries);
         return "requirementPage";
      }
      AppUser newUser= null;
     try {
       newUser = appUserDAO.createAppUser(appUserForm);
      }
      
      catch (Exception e) {
        List<Country> countries = countryDAO.getCountries();
         model.addAttribute("countries", countries);
         //model.addAttribute("errorMessage", "Error: " + e.getMessage());
         return "requirementPage";
      }
 
      redirectAttributes.addFlashAttribute("flashUser", newUser);
       
      return "redirect:/registerSuccessful";
   }
 
}
