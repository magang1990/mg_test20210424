package com.mg.springboot_project.req;

import com.mg.springboot_project.constant.CheckConstants;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author mg
 * @Date 2022-05-16
 * @Version 1.0
 */
@Data
public class ValidatedTestReq {

	@NotBlank(message = "姓名不能为空",groups = CheckConstants.getCheck.class)
	private String name;

	@NotNull(message = "年龄不能为空",groups = CheckConstants.postCheck.class)
	private String age;

}
