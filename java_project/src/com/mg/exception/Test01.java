package com.mg.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mg
 * @Date 2023-02-22
 * @Version 1.0
 */
public class Test01 {

	private final static Logger log= LoggerFactory.getLogger(Test01.class);

	public static void main(String[] args){
		System.out.println("testFinally()的结果:"+testFinally());
		System.out.println("testFinally2()的结果:"+testFinally2());
	}

	private static int testFinally() {
		try {
			int num = 1 / 0;
		} catch (Exception e) {
			log.error("异常",e);
			return 1;
		} finally {
			return 2;
		}
	}

	private static int testFinally2() {
		try {
			return 1;
		} finally {
			System.out.println("testFinally2()的finally");
			//return 2;
		}
	}
}
