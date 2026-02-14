package com.assignment1.controller;


import com.assignment1.dto.response.OrderListResponseDTO;
import com.assignment1.exception.OutOfStockException;
import com.assignment1.exception.UserNotExistedException;
import com.assignment1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public String createOrder(RedirectAttributes redirectAttributes, @RequestParam List<String> productId,
                              @RequestParam String email, @RequestParam Map<String, String> map) {
        try {
            orderService.confirmOrderProduct(productId, email, map);
            redirectAttributes.addFlashAttribute("notification", "you ordered ");
        } catch (OutOfStockException | UserNotExistedException o) {
            redirectAttributes.addFlashAttribute("notification", o.getMessage());
        }
        return "redirect:/products";
    }


//    @GetMapping()
//    public String viewOrderList(Model model) {
//        List<OrderListResponseDTO> list = Collections.unmodifiableList(orderService.getALlOrder());
//        model.addAttribute("list", list);
//        return "order/order_list";
//    }


}

