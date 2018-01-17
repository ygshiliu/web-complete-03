package com.atguigu.servlet;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

/**
 * 描述：
 * 开发者：Miss Wang
 * 2017年4月21日 上午11:15:51
 */
public class UUIDTest {

	@Test
	public void test() {

		/**
		 * UUID是一个32位的唯一标识符
		 * 它是由时间戳机器码计算出来的
		 * 时间戳就是从1970年1月1日  0点0分0秒 到现在的毫秒值
		 * 机器码每一台计算机出厂都有一个唯一的标识符
		 * 我们可以将UUID看成是全世界唯一的标识符，不可能重复的
		 * 作用：在实际生产中，对象的主键通常使用的不是自增而是uuid
		 */
		//创建UUID
		UUID randomUUID = UUID.randomUUID();
		System.out.println(randomUUID.toString().replace("-", ""));
		
		//获取时间戳
		long time = System.currentTimeMillis();
		System.out.println(time);
	}

}
