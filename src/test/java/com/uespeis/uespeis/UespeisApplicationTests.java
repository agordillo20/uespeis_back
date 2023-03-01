package com.uespeis.uespeis;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.uespeis.utils.Codifiquer;

@SpringBootTest
class UespeisApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(Codifiquer.encode("test"));
		assertNull(null);
	}

}
