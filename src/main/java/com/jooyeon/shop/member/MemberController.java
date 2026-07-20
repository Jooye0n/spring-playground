package com.jooyeon.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    String join(Authentication auth){
        if (auth != null && auth.isAuthenticated()){
            return "redirect:/list";
        }else{
            return "join.html";
        }
    }

    @PostMapping("/join")
    String join(@RequestParam Map formData){
        memberService.saveUser(formData);
        return "redirect:/list";
    }

    @GetMapping("/login")
    String login(Authentication auth){
        if (auth != null && auth.isAuthenticated()){
            return "redirect:/list";
        }else{
            return "login.html";
        }
    }

    @GetMapping("/my-page")
    public String myPage(Authentication auth){
        CustomUser result = (CustomUser)auth.getPrincipal();
        System.out.println(result.displayName);
        return "mypage.html";
    }
}
