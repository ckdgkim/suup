package com.example.validation_ex.controller;

import com.example.validation_ex.dto.ErrorResult;
import com.example.validation_ex.dto.Item;
import com.example.validation_ex.exception.ItemValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
@Slf4j
public class ItemController {

    @PostMapping
    public Object createItem(@Validated @RequestBody Item item,
                           BindingResult bindingResult) {
//        if (bindingResult.hasErrors()){
//            log.error("에러에요: {}", bindingResult.getAllErrors());
//            return bindingResult.getAllErrors();
//        }
        if (item.getCost() >= item.getPrice()){
            bindingResult.reject("costAndPrice","cost가 price보다 큼요");
        }
        if (bindingResult.hasErrors()){
            log.error("에러에요: {}", bindingResult.getAllErrors());
            return bindingResult.getAllErrors();
        }
        log.info("Create Item: {}", item);
        return item;
    }
}
