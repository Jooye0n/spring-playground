package jooyeon.hello_spring.controller;
import jooyeon.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired //Dependency Injection (의존관계 주입)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
