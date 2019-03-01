package com.group.cleanup.webadmin.controller;

import com.group.cleanup.webadmin.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class AdminController {
    @Autowired
    private AdminServices adminServices;
    @GetMapping(value = "/admin")
    public ModelAndView index(HttpSession session) throws IOException {
        ModelAndView mav = new ModelAndView();
//        if (session.getAttribute("user") == null) {
//            mav.setViewName("redirect:/login");
//            return mav;
//        }
        mav.setViewName("dashboard");
        return mav;
    }
    @GetMapping(value = "/admin-listTypeCar")
    public ModelAndView listTypeCar(HttpSession session){
        ModelAndView mav = new ModelAndView();
        if (session.getAttribute("user") == null){
            mav.setViewName("redirect:/admin-login");
            return mav;
        }
        mav.addObject("listTypeCar",adminServices.getTypeCar());
        mav.setViewName("admin/typeCar");
        return mav;
    }

}
