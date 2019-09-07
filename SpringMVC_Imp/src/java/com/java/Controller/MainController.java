/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.Controller;

import com.java.Bean.User;
import com.java.Model.UserModel;
import javax.jms.Session;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author PhamBaHieu
 */
@Controller
public class MainController {
    @RequestMapping(value = "trang-chu", method = RequestMethod.GET)
    public ModelAndView homeController(){
       ModelAndView mav = new ModelAndView("View/HomePages");
       return mav;
    }
    
   @RequestMapping(value = "Login")
   public ModelAndView loginController(ModelMap model){
        model.addAttribute("UserLogin", new User());
        ModelAndView mav = new ModelAndView("View/Login");
        return mav;
   }
   
   @RequestMapping(value = "Logout")
   public ModelAndView logoutController (ModelMap model, HttpServletResponse resp,HttpSession session){
        model.addAttribute("UserLogin", new User());
        ModelAndView mav = new ModelAndView("View/Login");
        session.removeAttribute("UserLogin");
        return mav;
   }
   
   
   @RequestMapping(value = "auth")
   public String authController(@ModelAttribute("UserLogin") User us, HttpServletResponse resp, ModelMap model)
   {  
        UserModel usm = new UserModel();
        String temp = usm.auth(us.getEmail(), us.getPass());
           if(temp!=null){    
            resp.addCookie(new Cookie("UserName",temp));
            resp.addCookie(new Cookie("UserEmail", us.getEmail()));
            resp.addCookie(new Cookie("UserPass", us.getPass()));   
            return "View/HomePages";
        }
        model.addAttribute("err", "Login faisle");
        return "View/Login";
   }
   
}
