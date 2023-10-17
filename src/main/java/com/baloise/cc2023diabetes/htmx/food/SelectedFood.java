package com.baloise.cc2023diabetes.htmx.food;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@SessionScope
@Component
@Data
public class SelectedFood {
	private final List<String> titles = new ArrayList<>();
}
