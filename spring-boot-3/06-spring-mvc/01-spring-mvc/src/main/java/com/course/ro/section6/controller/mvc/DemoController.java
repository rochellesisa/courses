package com.course.ro.section6.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class DemoController {

    @RequestMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("theDate", java.time.LocalDate.now());
        return "helloworld";
    }

}
