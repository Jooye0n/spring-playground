package com.jooyeon.shop.sales;

import lombok.CustomLog;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SalesController {
    private final SalesRepository salesRepository;

    @PostMapping("/order")
    String postOrder(@RequestParam String title,
                     @RequestParam Integer price,
                     @RequestParam Integer count,
                     Authentication auth){
        Sales sales = new Sales();
        sales.setCount(count);
        sales.setPrice(price);
        sales.setCount(count);
        sales.setMemberId(1L);
        salesRepository.save(sales);
        return "list.html";
    }
}
