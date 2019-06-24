package org.launchcode.GatewaySEC.controllers;

import org.launchcode.GatewaySEC.models.*;
import org.launchcode.GatewaySEC.models.data.FunderDao;
import org.launchcode.GatewaySEC.models.data.PartnerDao;
import org.launchcode.GatewaySEC.models.data.StudentDao;
import org.launchcode.GatewaySEC.models.data.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class CommunityController {

    @Autowired
    private TeamDao teamDao;
    @Autowired
    private FunderDao funderDao;
    @Autowired
    private PartnerDao partnerDao;
    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "")
    public String home(Model model) {

        return "community/pages/home";
    }

    @RequestMapping(value = "contacts", method = RequestMethod.GET)
    public String displayContactUs(Model model){
        model.addAttribute("contacts", teamDao.findAll());
        model.addAttribute("title","Contact Us");
        return "community/pages/contacts";
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String displayAbout(Model model){
        model.addAttribute("title","About");
        return "community/pages/about";
    }

    @RequestMapping(value = "need", method = RequestMethod.GET)
    public  String displayTheNeed(Model model){
        model.addAttribute("title","The Need");
        return "community/pages/need";
    }

    @RequestMapping(value = "funders", method = RequestMethod.GET)
    public String displayOurFunders(Model model){
        model.addAttribute("funders", funderDao.findAll());
        model.addAttribute("title","Our Funders");
        return "community/pages/funders";
    }

    @RequestMapping(value = "partners", method = RequestMethod.GET)
    public String displayOurPartners(Model model){
        model.addAttribute("partners", partnerDao.findAll());
        model.addAttribute("title","Our Partners");
        return "community/pages/partners";
    }

    @RequestMapping(value = "register/partner", method = RequestMethod.GET)
    public String displayRegisterPartnerForm(Model model){
        model.addAttribute("partner", new Partner());
        model.addAttribute("whos", Who.values());
        model.addAttribute("title","Register to be a Partner");
        return "community/pages/register/partner";

    }

    @RequestMapping(value = "register/seo", method = RequestMethod.GET)
    public String displayRegisterSEOForm(Model model){
        model.addAttribute( "seo", new SEO());
        model.addAttribute("gradeLevels", GradeLevel.values());
        model.addAttribute("title","Register Your SEO");
        return "community/pages/register/seo";

    }

    @RequestMapping(value = "register/funder", method = RequestMethod.GET)
    public String displayRegisterFunderForm(Model model){
        return "community/pages/register/funder";


    }

}

