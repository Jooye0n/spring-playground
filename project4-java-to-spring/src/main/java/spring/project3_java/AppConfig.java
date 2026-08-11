package spring.project3_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.project3_java.discount.DiscountPolicy;
import spring.project3_java.discount.RateDiscountPolicy;
import spring.project3_java.member.MemberRepository;
import spring.project3_java.member.MemberService;
import spring.project3_java.member.MemberServiceImpl;
import spring.project3_java.member.MemoryMemberRepository;
import spring.project3_java.order.OrderService;
import spring.project3_java.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
