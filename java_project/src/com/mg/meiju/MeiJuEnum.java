package com.mg.meiju;

public enum MeiJuEnum {
	//`operate_mode` tinyint(1) NOT NULL DEFAULT '0' COMMENT '操作方式：0-人工；1-系统',
	/**
	 * 人工
	 */
	ARTIFICIAL(0, "人工"),

	SYSTEMO(1, "系统");

	private Integer key;
	private String value;

	MeiJuEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}
