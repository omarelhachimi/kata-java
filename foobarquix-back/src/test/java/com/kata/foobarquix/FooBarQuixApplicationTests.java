package com.kata.foobarquix;

import com.kata.foobarquix.controllers.FooBarQuixController;
import com.kata.foobarquix.services.impl.FooBarQuixServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FooBarQuixApplicationTests {

	@Autowired
	private FooBarQuixController fooBarQuixController;

	@Autowired
	private FooBarQuixServiceImpl fooBarQuixServiceImpl;

	@Test
	void contextLoads() {
		assertThat(fooBarQuixController).isNotNull();
		assertThat(fooBarQuixServiceImpl).isNotNull();
	}

}
