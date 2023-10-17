package com.baloise.cc2023diabetes;

import com.baloise.cc2023.diabetes.jooq.tables.records.FoodRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.baloise.cc2023.diabetes.jooq.Tables.FOOD;

@Component
public class JooqStartupTester implements InitializingBean {

	private final DSLContext jooq;

	public JooqStartupTester(DSLContext jooq) {
		this.jooq = jooq;
	}

	@Override
	public void afterPropertiesSet() {
		record FoodIdAndName(long id, String name) {};
		Result<FoodRecord> records = jooq.selectFrom(FOOD).fetch();
		records.forEach(System.out::println);

		List<FoodIdAndName> result = jooq.select(FOOD.ID, FOOD.TITLE)
			.from(FOOD)
			.fetchInto(FoodIdAndName.class);
		result.forEach(System.out::println);
	}
}
