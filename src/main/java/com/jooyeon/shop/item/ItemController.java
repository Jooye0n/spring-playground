package com.jooyeon.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    //상품 관련 API를 보관하기 위한 Controller
    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);
        return "redirect:/list/page/1";
    }

    @GetMapping("/write")
    String write(){
        return "write.html";
    }

    @PostMapping("/add")
    String add(@RequestParam Map formData, Authentication auth){
        if(auth !=null && auth.isAuthenticated()){
            itemService.saveItem(formData, auth.getName());
            return "redirect:/list ";
        }else{
            return "login.html";
        }
    }

    @GetMapping("/modify/{id}")
    String modify(@PathVariable Long id, Model model){
        Optional<Item> result = itemRepository.findById(id);
        if(result.isPresent()){
            model.addAttribute("data", result.get());
            return "modify.html";
        }else{
            return "redirect:/list";
        }
    }

    @PostMapping("/modify")
    String modifyItem(@RequestParam Map formData, Authentication auth){
        if(auth !=null && auth.isAuthenticated()) {
            itemService.modifyItem(formData, auth.getName());
            return "redirect:/list";
        }else{
            return "login.html";
        }
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Integer id, Model model){
        Optional<Item> result = itemRepository.findById(id.longValue());
        if(result.isPresent()){
            model.addAttribute("data", result.get());
            return "detail.html";
        }else{
            return "redirect:/list";
        }
    }

    @DeleteMapping("/item")
    ResponseEntity<String> deleteItem(@RequestParam Map data){
        itemService.deleteItem(data);
        return ResponseEntity.status(200).body("삭제완료");
    }

    @GetMapping("/list/page/{idx}")
    String getListPage(Model model, @PathVariable Integer idx){
        Page<Item> result = itemRepository.findPageBy(PageRequest.of(idx - 1, 5));
        model.addAttribute("items", result.getContent());
        model.addAttribute("currentPage", idx);
        model.addAttribute("totalPages", result.getTotalPages());
        return "list.html";
    }

}
