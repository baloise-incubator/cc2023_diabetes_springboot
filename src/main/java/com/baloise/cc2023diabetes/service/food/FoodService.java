package com.baloise.cc2023diabetes.service.food;

import com.baloise.cc2023diabetes.service.food.model.FoodModel;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.baloise.cc2023.diabetes.jooq.Tables.FOOD;

@Service
@AllArgsConstructor
public class FoodService {

    private final DSLContext jooq;

    public List<FoodModel> getAll() {
        return jooq.select(FOOD.ID, FOOD.TITLE, FOOD.UNIT, FOOD.CARBOHYDRATE_AVAILABLE,
                FOOD.CARBOHYDRATE_AVAILABLE.div(10.0), FOOD.SUGAR).from(FOOD).fetchInto(FoodModel.class);
    }

    public List<FoodModel> search(String searchString) {
        return jooq.select(FOOD.ID, FOOD.TITLE, FOOD.UNIT, FOOD.CARBOHYDRATE_AVAILABLE,
                        FOOD.CARBOHYDRATE_AVAILABLE.div(10.0), FOOD.SUGAR).from(FOOD)
                .where(DSL.lower(FOOD.TITLE).like(searchString.toLowerCase() + "%")
                        .or(DSL.lower(FOOD.SYN).like(searchString.toLowerCase() + "%"))
                ).fetchInto(FoodModel.class);
    }
}
