package com.mg.springboot_project.controller;

import com.mg.springboot_project.service.impl.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @author mg
 * @date 2023-08-01
 */
@Validated
@RestController
@RequestMapping("transactional")
public class TransactionalController {


    @Autowired
    private TransactionalService transactionalService;

    @GetMapping("save1")
    public String save1(@NotNull(message = "id不可为空") @Positive(message = "id必须为正整数") Long id) {
        transactionalService.save1(id);
        return "成功";
    }

}
