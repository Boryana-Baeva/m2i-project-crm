package com.example.projectCRM;

import com.example.projectCRM.model.Client;
import com.example.projectCRM.model.Order;
import com.example.projectCRM.model.StateClient;
import com.example.projectCRM.model.StateOrder;
import com.example.projectCRM.service.ClientService;
import com.example.projectCRM.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ServiceTests {
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderService orderService;

    /** GET ALL **/
    @Test
    void testGetAllClients() {
        clientService.getAll().forEach(System.out::println);
    }

    @Test
    void testGetAllOrders() {
        orderService.getAll().forEach(System.out::println);
    }

    /** GET ONE **/
    @Test
    void testGetClientById() {
        clientService.getById(1).ifPresent(System.out::println);
    }

    @Test
    void testGetOrderById() {
        orderService.getById(1).ifPresent(System.out::println);
    }

    /** SAVE **/
    @Test
    void testSaveClient() {
        Client client = new Client("EFG Co.", "Alice", "Johnson", "alice.johnson@example.com",
                "555-789-1234", "987 Oak St", "54321", "Townton", "Otherland", StateClient.ACTIVE);

        clientService.save(client);
    }

    @Test
    void testSaveOrder() {
        // Sample Client
        Client client = new Client("UVW Co.", "Eva", "Miller", "eva.miller@example.com",
                "777-888-9999", "456 Elm St", "98765", "Villagetown", "United States", StateClient.ACTIVE);
        clientService.save(client);

        // New Order
        Order order = new Order("ServiceD", "Maintenance", 7, 300.0, StateOrder.CONFIRMED);
        order.setClient(client);

        orderService.save(order);
    }

    /** UPDATE **/
    @Test
    void testUpdateClient() {
        clientService.getById(5).ifPresent(c -> {
            c.setCountry("Poland");
            clientService.save(c);
        });

        clientService.getById(6).ifPresent(c -> {
            c.setCountry("United Kingdom");
            clientService.save(c);
        });

        clientService.getById(7).ifPresent(c -> {
            c.setCountry("Germany");
            clientService.save(c);
        });

        clientService.getById(8).ifPresent(c -> {
            c.setCountry("Spain");
            clientService.save(c);
        });
    }

    @Test
    void testUpdateOrder() {
        orderService.getById(1).ifPresent(o -> {
            o.setState(StateOrder.CONFIRMED);
            orderService.save(o);
        });
    }

    /** DELETE **/
    @Test
    void testDeleteClient() {
        List<Client> clients = clientService.getAll();
        Client toDelete = clients.get(clients.size()-1);

        clientService.delete(toDelete);
    }

    @Test
    void testDeleteOrder() {
        List<Order> orders = orderService.getAll();
        Order toDelete = orders.get(orders.size()-1);

        orderService.delete(toDelete);
    }
}
