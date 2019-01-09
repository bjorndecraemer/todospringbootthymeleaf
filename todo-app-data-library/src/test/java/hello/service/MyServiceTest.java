package hello.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MyServiceTest {

    @InjectMocks
    private MyService myService;

    @BeforeEach
    void SetUp(){
        myService = new MyService();
    }

    @Test
    void message() {
        assertEquals("Hello World", myService.message());
    }
}