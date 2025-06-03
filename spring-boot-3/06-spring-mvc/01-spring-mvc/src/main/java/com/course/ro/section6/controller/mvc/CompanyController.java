package com.course.ro.section6.controller.mvc;

import com.course.ro.section6.model.dto.CompanyDTO;
import com.course.ro.section6.model.dto.converter.MapstructMapper;
import com.course.ro.section6.service.ICompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Controller
@RequestMapping("/view/company")
public class CompanyController {

    private final ICompanyService companyService;
    private final MapstructMapper mapper;

    @Value("${countries}")
    private List<String> countries;

    @Value("${industry}")
    private List<String> industries;

    @Autowired
    public CompanyController(ICompanyService companyService, MapstructMapper mapper) {
        this.companyService = companyService;
        this.mapper = mapper;
    }

    @RequestMapping("/all")
    public String loadCompanies(Model model){
        System.out.println(model.getAttribute("created"));
        model.addAttribute("companies", companyService.getAll());
        return "company/company";
    }

    @GetMapping("/create")
    public String loadCompanyCreateForm(Model model){
        CompanyDTO company = new CompanyDTO();
        model.addAttribute("company", company);
        model.addAttribute("countries", countries);
        model.addAttribute("industries", industries);
        return "company/company-form";
    }

    @PostMapping("/save")
    public String submitCompanyCreateForm(@Valid @ModelAttribute("company") CompanyDTO company,
                                          BindingResult bindingResult,
                                          RedirectAttributes redirectAttrs,
                                          Model model){

        System.out.println("-----------------------------------------------");
        System.out.println("BindingResult=" + bindingResult.toString());
        System.out.println("-----------------------------------------------");

        if (bindingResult.hasErrors()){
            model.addAttribute("company", company);
            model.addAttribute("countries", countries);
            model.addAttribute("industries", industries);
            return "company/company-form";
        } else {
            CompanyDTO saved = company.getId() == null ? companyService.create(company) : companyService.update(company);
            redirectAttrs.addFlashAttribute("created", saved);
            return "redirect:/view/company/all";
        }
    }

    @GetMapping("/update")
    public String loadCompanyEditForm(@RequestParam("companyId") Long companyId, Model model){
        CompanyDTO company = companyService.getById(companyId);
        model.addAttribute("company", company);
        model.addAttribute("countries", countries);
        model.addAttribute("industries", industries);
        return "company/company-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("companyId") Long companyId, Model model){
        companyService.delete(companyId);
        return "redirect:/view/company/all";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, trimmer);
    }

}
