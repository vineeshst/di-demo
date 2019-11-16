package guru.springframework.controllers;

import guru.springframework.services.GreetingServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyInjectedControllerTest {
    private PropertyInjectedController propertyInjectedController;

    @BeforeEach
    void setUp() {
       this.propertyInjectedController = new PropertyInjectedController();
        this.propertyInjectedController.greetingServiceImpl = new GreetingServiceImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGreeting() {
        assertEquals(GreetingServiceImpl.HELLO_GURUS, propertyInjectedController.greetingServiceImpl.sayGreeting());
    }
}