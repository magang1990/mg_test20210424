package com.mg.rizhi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mg
 * @Date 2021-04-25
 * @Version 1.0
 */
public class MgLogbackTest2 {

	private static final Logger log= LoggerFactory.getLogger(MgLogbackTest2.class);

	public static void main(String[] args){
		log.info("祝我们伟大的{},第{}个生日快乐！", "中国", "72");
		log.debug("编码debug！");
		log.error("编码error！");
		log.warn("编码warn!");
	}


}
