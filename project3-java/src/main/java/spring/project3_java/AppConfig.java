package spring.project3_java;

import spring.project3_java.discount.FixDiscountPolicy;
import spring.project3_java.member.MemberService;
import spring.project3_java.member.MemberServiceImpl;
import spring.project3_java.member.MemoryMemberRepository;
import spring.project3_java.order.OrderService;
import spring.project3_java.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
