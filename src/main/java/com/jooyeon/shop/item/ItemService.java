package com.jooyeon.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemService {

    //상품 관련 API를 보관하기 위한 Controller
    private final ItemRepository itemRepository;

    public void saveItem(Map formData, String userName){
        // 맵 데이터를 자르고 조합해서
        // 테이블에 save
        Item item = new Item((String) formData.get("title"), Integer.parseInt((String) formData.get("price")), userName);
        if(formData.get("id") != null){
            item.setId(Long.parseLong((String)formData.get("id")));
        }
        itemRepository.save(item);
    }

    public void deleteItem(Map formData) {
        itemRepository.deleteById(Long.parseLong((String) formData.get("id")));
    }

    public void modifyItem(Map formData, String userName) {
        saveItem(formData, userName);
    }
}
