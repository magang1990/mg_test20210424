package com.mg.springboot_project.controller;

import com.mg.springboot_project.constant.CheckConstants;
import com.mg.springboot_project.req.ValidatedTestReq;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * @author mg
 * @Date 2022-05-16
 * @Version 1.0
 */
@Validated(CheckConstants.getCheck.class)
@RestController
@RequestMapping("/validated/test")
public class ValidatedTestController {

	@GetMapping("/get/run")
	public String getRun(@NotBlank(message = "niu不能为空！",groups = CheckConstants.getCheck.class) String niu){
		return "get ok";
	}

	@PostMapping("/post/run")
	public String postRun(@Validated(CheckConstants.postCheck.class) @RequestBody ValidatedTestReq request){
		return "post ok";
	}
}
