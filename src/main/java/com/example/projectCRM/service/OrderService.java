package com.example.projectCRM.service;

import com.example.projectCRM.model.Order;
import com.example.projectCRM.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> getById(Integer id) {
        return orderRepository.findById(id);
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    public void update(Order order) {
        orderRepository.save(order);
    }

    public List<String> getInputErrors(Order order) {
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
