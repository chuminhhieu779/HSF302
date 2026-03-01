package com.demo4.controller;

import jakarta.servlet.http.HttpServletResponse;
import com.demo4.model.dto.response.CustomerResponse;
import com.demo4.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService ;
    @GetMapping("/customer")
    public String showCustomer(Model model){
        List<CustomerResponse> customerResponseList = customerService.getCustomerInformation();
        model.addAttribute("customerList", customerResponseList);
        return "customer";
    }

    @GetMapping("/customer/snyk/native")
    @ResponseBody
    public String testSnykNativeQuery(@RequestParam String name) {
        int rowCount = customerService.findCustomersUntrusted(name).size();
        return "Native query executed. Rows found: " + rowCount;
    }

    @GetMapping("/customer/snyk/jdbc")
    @ResponseBody
    public String testSnykJdbcQuery(@RequestParam String name) {
        customerService.testSnyk(name);
        return "JdbcTemplate execute completed.";
    }

    @GetMapping("/customer/snyk/weak-hash")
    @ResponseBody
    public String testSnykWeakHash(@RequestParam String value) {
        return customerService.weakHashForTesting(value);
    }

    @GetMapping("/customer/snyk/weak-hash-2")
    @ResponseBody
    public String testSnykWeakHash2(@RequestParam String value) {
        return customerService.weakHashForTestingV2(value);
    }

    @GetMapping("/customer/snyk/weak-hash-3")
    @ResponseBody
    public String testSnykWeakHash3(@RequestParam String value) {
        return customerService.weakHashForTestingV3(value);
    }

    @GetMapping("/customer/snyk/open-redirect-1")
    public void testSnykOpenRedirect1(@RequestParam String next, HttpServletResponse response) throws IOException {
        response.sendRedirect(next);
    }

    @GetMapping("/customer/snyk/open-redirect-2")
    public void testSnykOpenRedirect2(@RequestParam String target, HttpServletResponse response) throws IOException {
        response.sendRedirect(target);
    }

    @GetMapping("/customer/snyk/open-redirect-3")
    public void testSnykOpenRedirect3(@RequestParam String url, HttpServletResponse response) throws IOException {
        response.sendRedirect(url);
    }

    @GetMapping("/customer/snyk/command-injection")
    @ResponseBody
    public String testSnykCommandInjection(@RequestParam String cmd) {
        customerService.executeCommandUntrusted(cmd);
        return "Command executed (intentionally vulnerable for testing).";
    }

    @GetMapping("/customer/snyk/script-eval")
    @ResponseBody
    public String testSnykScriptEval(@RequestParam String expression) {
        Object result = customerService.evalUserScriptUntrusted(expression);
        return String.valueOf(result);
    }

    @GetMapping("/customer/snyk/deserialization")
    @ResponseBody
    public String testSnykDeserialization(@RequestParam String payload) {
        Object result = customerService.deserializeUntrusted(payload);
        return String.valueOf(result);
    }
}
