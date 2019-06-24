package org.launchcode.GatewaySEC.controllers;

import org.launchcode.GatewaySEC.models.GradeLevel;
import org.launchcode.GatewaySEC.models.SEO;
import org.launchcode.GatewaySEC.models.Student;
import org.launchcode.GatewaySEC.models.data.SEODao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private SEODao seoDao;

    @RequestMapping(value = "")
    public String home(Model model) {

        model.addAttribute("seos", seoDao.findAll());
        return "admin/pages/home";
    }

    @RequestMapping( value = "add", method = RequestMethod.POST)
    public String processRegisterSEOForm(@ModelAttribute @Valid SEO newSEO, Errors errors, Model model){
        model.addAttribute("title", "SEO Requests");
        if ( errors.hasErrors()) {
            model.addAttribute( "seo", new SEO());
            model.addAttribute("gradeLevels", GradeLevel.values());
            model.addAttribute("title","Register Your SEO");
            return "community/pages/register/seo";
        }
        seoDao.save(newSEO);
        return "admin/add/students";
    }


}
