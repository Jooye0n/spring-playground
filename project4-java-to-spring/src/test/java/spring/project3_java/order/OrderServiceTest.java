package spring.project3_java.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.project3_java.AppConfig;
import spring.project3_java.member.Grade;
import spring.project3_java.member.Member;
import spring.project3_java.member.MemberService;
import spring.project3_java.member.MemberServiceImpl;

public class OrderServiceTest {
    //MemberServiceImpl memberService = new MemberServiceImpl();
    //OrderServiceImpl orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        //System.out.println(order);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
