package com.mg.host;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author mg
 * @date 2023-07-08
 * <p>
 * 主机信息
 */
public class HostTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("主机名：" + localHost.getHostName());
        System.out.println("本机IP：" + localHost.getHostAddress());
        System.out.println("" + localHost.getCanonicalHostName());
        System.out.println("" + localHost.getAddress());
        System.out.println("" + localHost.getLocalHost());
    }
}
