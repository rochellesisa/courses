package com.courses.ro.section1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class FunRestController {

    @Value("${food.merienda:burger}")
    private String merienda;

    @Value("#{'${food.lunch}'.split(' & ')}")
    private List<String> lunch;

    @Value("#{${food.menu}}")
    private Map<String, String> menu;

    @Value("#{${food.menu.bistro}}")
    private Map<String, List<String>> menuBistro;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/bye")
    public String sayBye() {
        return "Goodbye World!";
    }

    @GetMapping("/get-menu")
    public Map<String, String> getMenu() {
        return menu;
    }

    @GetMapping("/get-menu-bistro")
    public Map<String, List<String>> getMenuBistro() {
        return menuBistro;
    }

    @GetMapping("/get-lunch")
    public List<String> getLunch() {
        return lunch;
    }

    @GetMapping("/get-merienda")
    public String getMerienda() {
        return merienda;
    }
}
