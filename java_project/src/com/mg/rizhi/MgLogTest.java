package com.mg.rizhi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mg
 * @Date 2021-04-25
 * @Version 1.0
 */
public class MgLogTest {
	public static void main(String[] args){
		Logger logger = LoggerFactory.getLogger(MgLogTest.class);

		logger.debug("编码错误！");

		int code=888888;
		logger.info("输入号码："+code);

		int i=1;
		int j=(++i)+(++i);
		logger.debug("{}",j);
		int a=1;
		int z=(a++)+(++a);
		logger.debug("[{}]",z);
	}
}
