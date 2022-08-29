package com.mg.mac;

import java.util.Random;

/**
 * @author mg
 * @Date 2022-03-01
 * @Version 1.0
 */
public class MacTest {
	public static void main(String[] args){
		for (int i = 0; i < 500; i++) {
			String s = randomMac4Qemu();
			System.out.println(s);
		}

	}

	private static String SEPARATOR_OF_MAC = ":";

	/**
	 * Generate a random MAC address for qemu/kvm
	 * 52-54-00 used by qemu/kvm
	 * The remaining 3 fields are random,  range from 0 to 255
	 *
	 * @return MAC address string
	 */
	public static String randomMac4Qemu() {
		Random random = new Random();
		String[] mac = {
				String.format("%02x", 0x52),
				String.format("%02x", 0x54),
				String.format("%02x", 0x00),
				String.format("%02x", random.nextInt(0xff)),
				String.format("%02x", random.nextInt(0xff)),
				String.format("%02x", random.nextInt(0xff))
		};
		return String.join(SEPARATOR_OF_MAC, mac);
	}
}
