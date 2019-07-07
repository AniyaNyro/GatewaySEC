package org.launchcode.GatewaySEC.controllers;

import org.launchcode.GatewaySEC.models.*;
import org.launchcode.GatewaySEC.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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
    @Autowired
    private SEODao seoDao;

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
        model.addAttribute("partners", partnerDao.findByApproved(true));
        model.addAttribute("title","Our Partners");
        return "community/pages/partners";
    }

    @RequestMapping(value = "view/teamMembers", method = RequestMethod.GET)
    public String displayViewTeam(Model model) {
        model.addAttribute("teamMs", teamDao.findAll());
        model.addAttribute("title", "Team Members");
        return "community/pages/team";
    }

    @RequestMapping(value = "register/partner", method = RequestMethod.GET)
    public String displayRegisterPartnerForm(Model model){
        model.addAttribute("partner", new Partner());
        model.addAttribute("whos", Who.values());
        model.addAttribute("title","Register to be a Partner");
        return "community/pages/register/partner";

    }

    @RequestMapping( value = "register/partner", method = RequestMethod.POST)
    public String processAddPartnerForm(@ModelAttribute @Valid Partner newPartner, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("partner", newPartner);
            model.addAttribute("whos", Who.values());
            return "community/pages/register/partner";


        }
        partnerDao.save(newPartner);
        return "redirect:/";

    }

    @RequestMapping(value = "register/seo", method = RequestMethod.GET)
    public String displayRegisterSEOForm(Model model){
        model.addAttribute("seo", new SEO());
        model.addAttribute("teamMs", teamDao.findAll());
        model.addAttribute("gradeLevels", GradeLevel.values());
        model.addAttribute("title","Register Your SEO");
        return "community/pages/register/seo";

    }

    @RequestMapping( value = "register/seo", method = RequestMethod.POST)
    public String processRegisterSEOForm(@ModelAttribute @Valid SEO newSEO, Errors errors, Model model) {
        model.addAttribute("title", "SEO Requests");
        if (errors.hasErrors()) {
            model.addAttribute("teamMs", teamDao.findAll());
            model.addAttribute("gradeLevels", GradeLevel.values());
            model.addAttribute("title", "Register Your SEO");
            return "community/pages/register/seo";
        }

        seoDao.save(newSEO);
        return "redirect:/";
    }
    @RequestMapping(value = "view/seos", method = RequestMethod.GET)
    public String displayViewSEOs(Model model){
        model.addAttribute("seos", seoDao.findByApproved(true));
        model.addAttribute("title","All Student Empowerment Organizations");
        return "community/pages/seos";

    }

    @RequestMapping(value = "register/funder", method = RequestMethod.GET)
    public String displayRegisterFunderForm(Model model){
        model.addAttribute("funder", new Funder());
        model.addAttribute("whos", Who.values());
        return "community/pages/register/funder";


    }

    @RequestMapping( value = "register/funder", method = RequestMethod.POST)
    public String processRegisterFunderForm(@ModelAttribute @Valid Funder newFunder, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("funder", newFunder);
            model.addAttribute("whos", Who.values());
            return "community/pages/register/funder";

        }
        funderDao.save(newFunder);
        return "redirect:/";


    }

}

