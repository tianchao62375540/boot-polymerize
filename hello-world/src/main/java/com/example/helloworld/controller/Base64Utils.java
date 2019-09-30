package com.example.helloworld.controller;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Base64Utils {

	public static void main(String[] args) throws IOException {
		String man = "Man男人";
		String a = "A";
		String bc = "BC";

		BASE64Encoder encoder = new BASE64Encoder();
		System.out.println("Man base64结果为：" + encoder.encode(man.getBytes("iso-8859-1")));
		System.out.println("Man base64结果为：" + encoder.encode(man.getBytes("utf-8")));
		System.out.println("BC base64结果为：" + encoder.encode(bc.getBytes()));
		System.out.println("A base64结果为：" + encoder.encode(a.getBytes()));

		BASE64Decoder decoder = new BASE64Decoder();
		byte[] twFu55S35Lq6s = decoder.decodeBuffer("TWFu55S35Lq6");
		String s = new String(twFu55S35Lq6s, "utf-8");
		System.out.println(s);
	}
}
