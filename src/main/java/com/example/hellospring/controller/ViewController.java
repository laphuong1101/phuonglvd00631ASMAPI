package com.example.hellospring.controller;

import com.example.hellospring.entity.Street;
import com.example.hellospring.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/district")
public class ViewController {
    @Autowired
    private StreetService streetService;

    @RequestMapping( method = RequestMethod.GET)
    public String index (Model model) {
        model.addAttribute("list", streetService.findAll());
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create (Model model) {
        model.addAttribute("street", new Street());
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String store (@Valid @ModelAttribute("street") Street street, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        streetService.save(street);
        return "redirect:/admin/district";
    }
}
