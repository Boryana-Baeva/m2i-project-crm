package com.example.projectCRM;

import com.example.projectCRM.model.Client;
import com.example.projectCRM.model.Order;
import com.example.projectCRM.model.StateClient;
import com.example.projectCRM.model.StateOrder;
import com.example.projectCRM.repository.ClientRepository;
import com.example.projectCRM.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
public class RepositoryTests {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testSaveClient() {
        Client client1 = new Client("ABC Inc.", "John", "Doe", "john.doe@example.com",
                "123-456-7890", "123 Main St", "12345", "Cityville", "Countryland", StateClient.ACTIVE);

        Client client2 = new Client("XYZ Ltd.", "Jane", "Smith", "jane.smith@example.com",
                "987-654-3210", "456 Oak St", "54321", "Townsville", "Otherland", StateClient.INACTIVE);

        Client client3 = new Client("PQR Corp.", "Bob", "Johnson", "bob.johnson@example.com",
                "555-123-4567", "789 Pine St", "67890", "Villagetown", "Anotherland", StateClient.ACTIVE);


        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);
    }

    @Test
    void testGetAllClients() {
        clientRepository.findAll().forEach(System.out::println);
    }

    @Test
    void testGetAllOrders() {
        orderRepository.findAll().forEach(System.out::println);
    }

    @Test
    void testSaveOrder() {
        Optional<Client> op1 = clientRepository.findById(1);
        Optional<Client> op2 = clientRepository.findById(2);

        if(op1.isPresent() && op2.isPresent()) {
            Client client1 = op1.get();
            Client client2 = op2.get();
            // Sample Orders
//            Order order1 = new Order("ServiceA", "Consultation", 3, 100.0, StateOrder.CANCELED);
//            order1.setClient(client1);
//
//            Order order2 = new Order("ServiceB", "Development", 5, 500.0, StateOrder.CONFIRMED);
//            order2.setClient(client1);
//
//            Order order3 = new Order("ServiceC", "Training", 2, 200.0, StateOrder.OPTION);
//            order3.setClient(client2);
//
//            Order order4 = new Order("ServiceA", "Consultation", 4, 150.0, StateOrder.CONFIRMED);
//            order4.setClient(client2);
//
//            Order order5 = new Order("ServiceB", "Development", 6, 600.0, StateOrder.CONFIRMED);
//            order5.setClient(client2);
//
//            Order order6 = new Order("ServiceC", "Training", 3, 250.0, StateOrder.CONFIRMED);
//            order6.setClient(client1);
//
//            Order order7 = new Order("ServiceA", "Consultation", 2, 120.0, StateOrder.OPTION);
//            order7.setClient(client1);
//
//            Order order8 = new Order("ServiceB", "Development", 4, 550.0, StateOrder.CONFIRMED);
//            order8.setClient(client2);
//
//            Order order9 = new Order("ServiceC", "Training", 1, 180.00, StateOrder.CANCELED);
//            order9.setClient(client1);
//
//            Order order10 = new Order("ServiceA", "Consultation", 5, 130.00, StateOrder.CONFIRMED);
//            order10.setClient(client2);

//            orderRepository.save(order1);
//            orderRepository.save(order2);
//            orderRepository.save(order3);
//            orderRepository.save(order4);
//            orderRepository.save(order5);
//            orderRepository.save(order6);
//            orderRepository.save(order7);
//            orderRepository.save(order8);
//            orderRepository.save(order9);
//            orderRepository.save(order10);

            Order order11 = new Order("New Order", "Consultation", 7, 830.00, StateOrder.CONFIRMED);
            order11.setClient(client2);
            orderRepository.save(order11);
        }

    }
    @Test
    void testGetCalculatedProperties() {
        Order o = orderRepository.findAll().get(0);
        System.out.println(o.getUnitPrice());
        System.out.println(o.getTotalExcludeTaxe());
        System.out.println(o.getTotalWithTaxe());
    }
}
