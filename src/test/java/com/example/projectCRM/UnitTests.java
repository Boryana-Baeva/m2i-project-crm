package com.example.projectCRM;

import com.example.projectCRM.model.Client;
import com.example.projectCRM.model.Order;
import com.example.projectCRM.model.StateClient;
import com.example.projectCRM.model.StateOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;


public class UnitTests {
    @Test
    void testCalculationTotalExcludeTax() {
        Order o = new Order("ServiceD", "Maintenance", 7, 300.00, StateOrder.CONFIRMED);

        Double expected = 300.0 * 7;
        Assertions.assertEquals(expected, o.getTotalExcludeTaxe());
    }

    @Test
    void testCalculationTotalWithTax() {
        Order o = new Order("ServiceD", "Maintenance", 7, 300.00, StateOrder.CONFIRMED);

        Double expected = 300.0 * 7 * 1.2;
        Assertions.assertEquals(expected, o.getTotalWithTaxe());
    }
}
