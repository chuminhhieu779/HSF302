package com.assignment1.controller;


import com.assignment1.dto.request.CustomerRequestDTO;
import com.assignment1.dto.response.CityResponseDTO;
import com.assignment1.exception.EmailAlreadyExisted;
import com.assignment1.service.CityService;
import com.assignment1.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService ;
    private final CityService cityService ;
    @GetMapping("/create")
    public String creatCustomer(CustomerRequestDTO customerRequestDTO ,Model model) {
        model.addAttribute("customerRequestDTO", customerRequestDTO);
        List<CityResponseDTO> cityResponseDTOList = cityService.findAllCity();
        model.addAttribute("cityList", cityResponseDTOList);
        return "customer/customer_form";
    }
    @PostMapping("/create")
    public String createCustomer (@Valid CustomerRequestDTO customerRequestDTO , BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerRequestDTO", customerRequestDTO);
            return "customer/customer_form";
        }
        try {
            customerService.saveCustomer(customerRequestDTO);
            redirectAttributes.addFlashAttribute("notification", "add user done !!");
            return "redirect:/customers/create";
        } catch (EmailAlreadyExisted e) {
            model.addAttribute("customerRequestDTO", customerRequestDTO);
            model.addAttribute("emailError", "email already existed");
            return "customer/customer_form";
        }
    }
}
