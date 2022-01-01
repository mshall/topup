package com.shall.cloud.gateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/topupServiceFallBack")
    public String userServiceFallBackMethod() {
        return "Topup Service is taking longer than Expected." +
                " Please try again later";
    }

}