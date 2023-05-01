package com.mg.springboot_project.controller;

import com.mg.springboot_project.service.JingZhunService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 鲸准航运
 */
@RestController
public class JingZhunController {

	@Resource
	private JingZhunService jingZhunService;

	@PostMapping("/getOcean")
	public String getOcean(@RequestBody String params){
		return  jingZhunService.getOcean(params);
	}

	@GetMapping("/getBlnoDeclare")
	public String getBlnoDeclare(@RequestParam("blno")String blno, @RequestParam("ieid")String ieid){
		return jingZhunService.getBlnoDeclare(blno,ieid);
	}

}
