package org.launchcode.GatewaySEC.controllers;

import org.launchcode.GatewaySEC.models.*;
import org.launchcode.GatewaySEC.models.data.PartnerDao;
import org.launchcode.GatewaySEC.models.data.SEODao;
import org.launchcode.GatewaySEC.models.data.StudentDao;
import org.launchcode.GatewaySEC.models.data.TeamDao;
import org.launchcode.GatewaySEC.models.forms.AddStudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;


@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private SEODao seoDao;
    @Autowired
    private PartnerDao partnerDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeamDao teamDao;

    @RequestMapping(value = "")
    public String home(Model model) {
        model.addAttribute("seos", seoDao.findByApproved(false));
        model.addAttribute("partners", partnerDao.findByApproved(false));

        return "admin/pages/home";
    }

        @RequestMapping(value = "", params = "b1", method = RequestMethod.POST)
    public String processApproveandProceedForm(@RequestParam int seoId, Model model){
       SEO seoInDB = seoDao.findById(seoId);
       seoInDB.setApproved(true);
       seoDao.save(seoInDB);
       return "redirect:/admin/seo/?seoId=" + seoInDB.getId();

    }

    @RequestMapping(value = "", params = "b2", method = RequestMethod.POST)
    public String processApproveForm(@RequestParam int partnerId, Model model){
        Partner partnerInDB = partnerDao.findById(partnerId);
        partnerInDB.setApproved(true);
        partnerDao.save(partnerInDB);
        return "redirect:/admin";

    }

    @RequestMapping(value = "seo", method = RequestMethod.GET)
    public String displaySEOProfile(Model model, @RequestParam int seoId){
        SEO someSEO = seoDao.findById(seoId);
        model.addAttribute("seo", someSEO);
        model.addAttribute("students", someSEO.getStudents());
        return "admin/pages/seo-profile";

    }

    @RequestMapping(value = "seo/{seoId}/addStu", method = RequestMethod.GET)
    public String displaySEOAddStuForm(Model model, @PathVariable int seoId){
        SEO someSEO = seoDao.findById(seoId);
        AddStudentForm form = new AddStudentForm(someSEO.getStudents(), someSEO);
        model.addAttribute("seo", someSEO);
        model.addAttribute("carrot", someSEO.getId());
        model.addAttribute("students", someSEO.getStudents());
        model.addAttribute("title", "Add Students to: "+ someSEO.getName());
        model.addAttribute("form",form);
        model.addAttribute("gradeLevels", GradeLevel.values());
        return "admin/pages/students";
    }

    @RequestMapping(value = "seo/{seoId}/addStu", method = RequestMethod.POST)
    public String processSEOAddStuForm(@ModelAttribute @Valid AddStudentForm form, Errors  errors, Model model,
                                       @PathVariable int seoId){

        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "admin/pages/students";
        }
        SEO someSEO = seoDao.findOne(form.getSeoId());
        Student student = new Student(form.getfName(), form.getlName(), form.getGrade(),
                seoDao.findById(form.getSeoId()));
        someSEO.addStudent(student);
        studentDao.save(student);
        seoDao.save(someSEO);
        return "redirect:addStu";
    }

    @RequestMapping(value = "register/team", method = RequestMethod.GET)
    public String displayAddTeamForm(Model model){
        model.addAttribute("title", "Register Team Members");
        model.addAttribute("teamM",new TeamM());
        return "admin/pages/register-team";
    }

    @RequestMapping(value = "register/team", method = RequestMethod.POST)
    public String processAddTeamForm(@ModelAttribute @Valid TeamM teamM, Errors errors, Model model ){
        if (errors.hasErrors()){
            model.addAttribute("title","Register Team Members");
            return "admin/pages/register-team";
        }
        teamDao.save(teamM);
        return "redirect:/admin";

    }




}
