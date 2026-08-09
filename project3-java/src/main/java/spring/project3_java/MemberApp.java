package spring.project3_java;

import spring.project3_java.member.Grade;
import spring.project3_java.member.Member;
import spring.project3_java.member.MemberService;
import spring.project3_java.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member member = memberService.findMember(1L);
        System.out.println("new Member: " + memberA.getName());
        System.out.println("find Member: " + member.getName());
    }
}
