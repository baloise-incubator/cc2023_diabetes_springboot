package com.baloise.cc2023diabetes.htmx.food;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@SessionScope
@Component
@Data
public class SelectedFood {
	private Set<String> titles = new HashSet<>();
}
