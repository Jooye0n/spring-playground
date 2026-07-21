package com.jooyeon.shop.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentRepository commentRepository;
    @PostMapping("/comment")
    String insertComment(@RequestParam Map formData, Authentication auth){
        if(auth !=null && auth.isAuthenticated()) {
            Comment comment = new Comment(auth.getName(), (String) formData.get("comment"), Long.parseLong((String) formData.get("parentId")));
            commentRepository.save(comment);
            return "redirect:/list";
        }else{
            return "login.html";
        }
    }
}
