package com.assignment1.service.implement;


import com.assignment1.dto.response.OrderListResponseDTO;
import com.assignment1.entity.Customer;
import com.assignment1.entity.Order;
import com.assignment1.entity.OrderDetail;
import com.assignment1.entity.Product;
import com.assignment1.exception.UserNotExistedException;
import com.assignment1.mapper.OrderMapper;
import com.assignment1.repository.CustomerRepository;
import com.assignment1.repository.OrderDetailRepository;
import com.assignment1.repository.OrderRepository;
import com.assignment1.repository.ProductRepository;
import com.assignment1.service.CustomerService;
import com.assignment1.service.OrderService;
import com.assignment1.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;
    private  final CustomerService customerService ;
    private final OrderMapper orderMapper;

//    @Override
//    public List<OrderListResponseDTO> getALlOrder() {
//
//    }


    private Order createOrder(Customer customer) {
        Order order = new Order();
        String orderId = order.createID("OD00", orderRepository.count());
        order.setId(orderId);
        order.setCustomer(customer);
        return order;
    }

    @Override
    @Transactional
    public void confirmOrderProduct(List<String> productID, String userEmail, Map<String, String> map) {

        Customer customer = customerService.checkUserExist(userEmail);

        List<Product> productList = new ArrayList<>();

        productID.forEach(id -> {
            Product p = productRepository.findById(id).orElseThrow(() -> new RuntimeException("ds"));
            productList.add(p);
        });

        productList.forEach(productService::checkQuantity);

        Order order = createOrder(customer);
        orderRepository.save(order);
        List<OrderDetail> orderDetailList = createOrderDetail(productList, order, map);
        orderDetailRepository.saveAll(orderDetailList);
    }


    private List<OrderDetail> createOrderDetail(List<Product> productList, Order order, Map<String, String> map) {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        productList.forEach(product -> {
            OrderDetail orderDetail = new OrderDetail();
            String orderDetailID = orderDetail.createID("ODT00", orderDetailRepository.count());
            orderDetail.setId(orderDetailID);
            orderDetail.setOrder(order);
            orderDetail.setProduct(product);
            String quantity = map.get("quantity_" + product.getId());
            orderDetail.setQuantity(Integer.parseInt(quantity));
            orderDetailList.add(orderDetail);
        });
        return orderDetailList;
    }


}