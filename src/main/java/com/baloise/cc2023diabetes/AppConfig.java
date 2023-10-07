package com.baloise.cc2023diabetes;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

	@Bean
	DSLContext jooq(DataSource ds) {
		return DSL.using(ds, SQLDialect.POSTGRES);
	}
}
