package com.mg.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mg
 * @Date 2023-04-08
 * @Version 1.0
 */
public class Test07 {

	private static Logger log = LoggerFactory.getLogger(Test07.class);

	public static void main(String[] args) {
		synchronized (Test07.class) {
			try {
				int a=10/0;
			} catch (Exception e) {
//				log.info("中断", e);
//				log.info("中断:{}", e);
//				log.info("中断:{}", e.toString());
				log.info("中断:{}", e.getMessage());
			}
		}

	}
}
