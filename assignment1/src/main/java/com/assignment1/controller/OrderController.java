package com.assignment1.controller;


import com.assignment1.dto.creation.OrderCreationDTO;
import com.assignment1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService ;

    @GetMapping("/create")
    public String createOrder3(){
        return "home";
    }

    @PostMapping("/create")
    public String createOrder(OrderCreationDTO dto  , RedirectAttributes redirectAttributes){
        try {
            orderService.saveOrder(dto);
            redirectAttributes.addFlashAttribute("notification", "add order done !!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("notification", "add order failed");
        }
        return "redirect:/order/create";
    }
}