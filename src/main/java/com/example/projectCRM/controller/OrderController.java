package com.example.projectCRM.controller;

import com.example.projectCRM.model.Client;
import com.example.projectCRM.model.Order;
import com.example.projectCRM.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("orders/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Integer id) {
        Optional<Order> optional = orderService.getById(id);

        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        else {
            return ResponseEntity.badRequest().body("No existing order with id " + id + " !");
        }
    }

    @DeleteMapping("orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer id) {
        Optional<Order> optional = orderService.getById(id);

        if(optional.isPresent()) {
            orderService.delete(optional.get());
            return ResponseEntity.ok("Successfully deleted the order with id " + id + " !");
        }
        else {
            return ResponseEntity.badRequest().body("No existing order with id " + id + " !");
        }
    }

//    @PutMapping("orders/{id}")
//    public ResponseEntity<?> updateOrder(@RequestBody Order order) {
//
//    }

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
