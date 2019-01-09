package hello.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public MyService() {
    }

    public String message() {
        return "Hello World";
    }
}
