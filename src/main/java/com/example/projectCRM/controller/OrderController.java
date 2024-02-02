package com.example.projectCRM.controller;

import com.example.projectCRM.model.Client;
import com.example.projectCRM.model.Order;
import com.example.projectCRM.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("orders")
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }

    @PostMapping("orders")
    public ResponseEntity<?> save(@RequestBody Order order) {
        List<String> errors = getPostErrors(order);
        if(!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors.toString());
        }
        else {
            orderService.save(order);
            return ResponseEntity.ok(order);
        }
    }

    private List<String> getPostErrors(Order order) {
        List<String> errors = new ArrayList<>();

        if(order.getTypePresta() == null || order.getTypePresta().isBlank()) {
            errors.add("Missing Order Type !");
        }

        if(order.getUnitPrice() == null) {
            errors.add("Missing Unit Price !");
        }

        if(order.getNbDays() == null) {
            errors.add("Missing Number Of Days !");
        }

        return errors;
    }
}
