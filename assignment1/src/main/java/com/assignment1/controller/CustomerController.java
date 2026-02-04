package com.assignment1.controller;


import com.assignment1.dto.request.CustomerRequestDTO;
import com.assignment1.exception.EmailAlreadyExisted;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping("/create")
    public String creatCustomer(CustomerRequestDTO dto ,Model model) {
        model.addAttribute("customerDTO", dto);
        return "customer/customer_form";
    }
    @PostMapping("/create")
    public String createCustomer (@Valid CustomerRequestDTO dto , BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDTO", dto);
            return "order/order_form";
        }
        try {
            redirectAttributes.addFlashAttribute("notification", "add order done !!");
            return "redirect:/customers/create";
        } catch (EmailAlreadyExisted e) {
            model.addAttribute("customerDTO", dto);
            model.addAttribute("emailError", "email already existed");
            return "order/order_form";
        }
    }
}
