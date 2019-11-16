package guru.springframework.controllers;

import guru.springframework.services.GreetingServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorInjectedControllerTest {
    ConstructorInjectedController constructorInjectedController;
    @BeforeEach
    void setUp() {
        this.constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGreeting() {
        assertEquals(GreetingServiceImpl.HELLO_GURUS, constructorInjectedController.sayHello());
    }
}