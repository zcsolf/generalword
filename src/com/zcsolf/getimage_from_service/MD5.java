package com.zcsolf.getimage_from_service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5的加密算法
 * 
 * @author zcsolf
 * 
 */
public class MD5 {

	/**
	 * 获取加密后字符转的方法，静态
	 * 
	 * @param content
	 *            需要加密的字符串
	 * @return
	 */
	public static String getMD5(String content) {
		/**
		 * 此 MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA
		 * 算法。信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
		 * 
		 * MessageDigest 对象开始被初始化。该对象通过使用 update 方法处理数据。任何时候都可以调用 reset
		 * 方法重置摘要。一旦所有需要更新的数据都已经被更新了，应该调用 digest 方法之一完成哈希计算。
		 * 
		 * 对于给定数量的更新数据，digest 方法只能被调用一次。在调用 digest 之后，MessageDigest
		 * 对象被重新设置成其初始状态。
		 */
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5"); // 创建具有指定算法名称的信息摘要。
			digest.update(content.getBytes());
			return getHashString(digest);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取哈希码
	 * 
	 * @param digest
	 * @return
	 */
	public static String getHashString(MessageDigest digest) {
		/**
		 * StringBuider: 一个可变的字符序列。此类提供一个与 StringBuffer 兼容的 API，但不保证同步。该类被设计用作
		 * StringBuffer
		 * 的一个简易替换，用在字符串缓冲区被单个线程使用的时候（这种情况很普遍）。如果可能，建议优先采用该类，因为在大多数实现中，它比
		 * StringBuffer 要快。
		 * 
		 * 在 StringBuilder 上的主要操作是 append 和 insert
		 * 方法，可重载这些方法，以接受任意类型的数据。每个方法都能有效地将给定的数据转换成字符串
		 * ，然后将该字符串的字符追加或插入到字符串生成器中。append 方法始终将这些字符添加到生成器的末端；而 insert
		 * 方法则在指定的点添加字符。
		 * 
		 * 例如，如果 z 引用一个当前内容为 "start" 的字符串的生成器对象，则该方法调用 z.append("le") 将使字符串生成器包含
		 * "startle"，而 z.insert(4, "le") 将更改字符串生成器，使之包含 "starlet"。
		 * 
		 * 通常，如果 sb 引用 StringBuilder 的实例，则 sb.append(x) 和 sb.insert(sb.length(),
		 * x) 具有相同的效果。每个字符串生成器都有一定的容量。只要字符串生成器所包含的字符序列的长度没有超出此容量，就无需分配新的内部缓冲区。
		 * 如果内部缓冲区溢出，则此容量自动增大。
		 */
		StringBuilder builder = new StringBuilder(); // 构造一个不带任何字符串的字符串生成器，其初始容量为16个字符。
		for (byte b : digest.digest()) {
			/*
			 * 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式,并且将其追加到此序列
			 */
			builder.append(Integer.toHexString((b >> 4) & 0xf));
			builder.append(Integer.toHexString(b & 0xf));
		}
		return builder.toString();
	}
}
