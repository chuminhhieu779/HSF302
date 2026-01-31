package com.assignment1.controller;


import com.assignment1.dto.creation.OrderCreationDTO;
import com.assignment1.exception.EmailAlreadyExisted;
import com.assignment1.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/create")
    public String createOrder(Model model) {
        OrderCreationDTO dto = new OrderCreationDTO();
        model.addAttribute("orderCreationDTO", dto);
        return "home";
    }

    @PostMapping("/create")
    public String createOrder(@Valid OrderCreationDTO dto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("orderCreationDTO", dto);
            return "home";
        }
        try {
            orderService.saveOrder(dto);
            redirectAttributes.addFlashAttribute("notification", "add order done !!");
            return "redirect:/order/create";
        } catch (EmailAlreadyExisted e) {
            model.addAttribute("orderCreationDTO", dto);
            bindingResult.rejectValue("email", "",e.getMessage());
            return "home";
        }
    }
}

