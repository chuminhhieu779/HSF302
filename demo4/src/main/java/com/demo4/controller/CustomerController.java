package com.demo4.controller;

import com.demo4.model.dto.response.CustomerResponse;
import com.demo4.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customer")
    public String showCustomer(Model model) {
        List<CustomerResponse> customerResponseList = customerService.getCustomerInformation();
        model.addAttribute("customerList", customerResponseList);
        return "customer";
    }
}
