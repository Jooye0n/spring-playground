package spring.project3_java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.project3_java.member.*;
import spring.project3_java.order.Order;
import spring.project3_java.order.OrderService;
import spring.project3_java.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        //MemberServiceImpl memberService = new MemberServiceImpl();
        //OrderServiceImpl orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println(order);
    }
}
