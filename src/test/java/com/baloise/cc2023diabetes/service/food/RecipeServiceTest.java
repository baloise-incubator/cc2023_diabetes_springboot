package com.baloise.cc2023diabetes.service.food;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RecipeServiceTest {

	@Autowired
	DataSource ds;

	@Autowired
	RecipeService recipeService;

	@Test
	void t1() {
		assertThat(ds).isNotNull();
		assertThat(recipeService).isNotNull();
	}
}
