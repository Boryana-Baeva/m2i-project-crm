package com.example.projectCRM.controller;

import com.example.projectCRM.controller.dto.OrderDTO;
import com.example.projectCRM.controller.dto.OrderMapper;
import com.example.projectCRM.model.Order;
import com.example.projectCRM.service.ClientService;
import com.example.projectCRM.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ClientService clientService;

    @GetMapping("orders")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAll()
                .stream().map(OrderMapper::toDTO)
                .toList();
    }

    @PostMapping("orders")
    public ResponseEntity<?> save(@RequestBody Order order) {
        List<String> errors = orderService.getInputErrors(order);

        if(!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors.toString());
        }
        else {
            if(order.getClient() != null) {
                // Find the Client by the ID provided in the request
                // in order to replace the empty Client property with it
                clientService.getById(order.getClient().getId())
                        .ifPresent(order::setClient);
            }
            orderService.save(order);
            return ResponseEntity.ok(order);
        }
    }

    @PostMapping("orders/dto")
    public ResponseEntity<?> save(@RequestBody OrderDTO orderDTO) {
        Order order = OrderMapper.toEntity(orderDTO);
        List<String> errors = orderService.getInputErrors(order);

        if(!errors.isEmpty()) {
            return ResponseEntity.badRequest().body(errors.toString());
        }
        else {
            orderService.save(order);
            OrderDTO response = OrderMapper.toDTO(order);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("orders/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Integer id) {
        Optional<Order> optional = orderService.getById(id);

        if(optional.isPresent()) {
            OrderDTO dto = OrderMapper.toDTO(optional.get());
            return ResponseEntity.ok(dto);
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

    @PutMapping("orders/{id}")
    public ResponseEntity<?> updateOrder(@RequestBody Order order, @PathVariable("id") Integer id) {
        if(!id.equals(order.getId())) {
            return ResponseEntity.badRequest().body("ID Mismatch!");
        }
        else {
            List<String> errors = orderService.getInputErrors(order);

            if(!errors.isEmpty()) {
                return ResponseEntity.badRequest().body(errors.toString());
            }
            else {
                if(order.getClient() != null) {
                    // Find the Client by the ID provided in the request
                    // in order to replace the empty Client property with it
                    clientService.getById(order.getClient().getId())
                                 .ifPresent(order::setClient);
                }

                orderService.update(order);
                OrderDTO response = OrderMapper.toDTO(order);
                return ResponseEntity.ok(response);
            }
        }
    }

}
