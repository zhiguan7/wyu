package com.wyu;

import com.wyu.util.CodeUtil;
import com.wyu.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestInstitutionBeApplicationTests {

	@Autowired
	private RedisUtil redisUtil;

	@Test
	void contextLoads() {

		redisUtil.set("code", CodeUtil.randomCode(),10);
		System.out.println(redisUtil.get("code"));

	}

}
