package guru.springframework.controllers;

import guru.springframework.services.GreetingServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetterInjectedControllerTest {
    private SetterInjectedController setterInjectedController;
    @BeforeEach
    void setUp() {
        this.setterInjectedController = new SetterInjectedController();
        this.setterInjectedController.setGreetingService(new GreetingServiceImpl());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGreetings() {
        assertEquals(GreetingServiceImpl.HELLO_GURUS, setterInjectedController.sayHello());
    }


}