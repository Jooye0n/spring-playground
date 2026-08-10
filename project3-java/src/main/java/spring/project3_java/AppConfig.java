package spring.project3_java;

import spring.project3_java.discount.RateDiscountPolicy;
import spring.project3_java.member.MemberRepository;
import spring.project3_java.member.MemberService;
import spring.project3_java.member.MemberServiceImpl;
import spring.project3_java.member.MemoryMemberRepository;
import spring.project3_java.order.OrderService;
import spring.project3_java.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public RateDiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
