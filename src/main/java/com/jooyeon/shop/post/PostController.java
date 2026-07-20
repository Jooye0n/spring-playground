package com.jooyeon.shop.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;

    @GetMapping("/post")
    String list(Model model){
        List<Post> result = postRepository.findAll();
        model.addAttribute("posts", result);
        return "post.html";
    }
}
