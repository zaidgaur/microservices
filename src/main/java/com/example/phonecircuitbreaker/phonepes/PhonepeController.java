package com.example.phonecircuitbreaker.phonepes;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("phonepe")
public class PhonepeController {
    @Autowired
    private RestTemplate restTemplate;
@GetMapping
@CircuitBreaker(name="rechargeService",fallbackMethod = "rechargeServiceDown")
    public String getPhonepe(){
        String output=restTemplate.getForObject("http://localhost:9001/recharge",String.class);

        return output+"via Phonepe";
    }
    public String rechargeServiceDown(Exception e){
       return "recharge servcie is down, now phonepe continue its servcies" ;
    }

}
