package com.assignment1.controller;


import com.assignment1.dto.request.OrderRequestDTO;
import com.assignment1.dto.response.OrderDetailResponseDTO;
import com.assignment1.dto.response.OrderListResponseDTO;
import com.assignment1.exception.EmailAlreadyExisted;
import com.assignment1.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/create")
    public String createOrder(Model model) {
        OrderRequestDTO dto = new OrderRequestDTO();
        model.addAttribute("orderRequestDTO", dto);
        return "order/order_form";
    }

    @PostMapping("/create")
    public String createOrder(@Valid OrderRequestDTO dto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("orderRequestDTO", dto);
            return "order/order_form";
        }
        try {
            orderService.saveOrder(dto);
            redirectAttributes.addFlashAttribute("notification", "add order done !!");
            return "redirect:/orders/create";
        } catch (EmailAlreadyExisted e) {
            model.addAttribute("orderRequestDTO", dto);
            model.addAttribute("emailError", "email already existed");
            return "order/order_form";
        }
    }

    @GetMapping()
    public String viewOrderList(Model model){
        List<OrderListResponseDTO> list = Collections.unmodifiableList(orderService.getALlOrder());
        model.addAttribute("list", list);
        return "order/order_list";
    }

    @GetMapping("/{email}")
    public String viewOrderDetail2(@PathVariable String email, Model model){
        OrderDetailResponseDTO dto = orderService.getOrderDetailByEmail(email);
        model.addAttribute("orderDetail", dto);
        return "order/order_detail";
    }
}

