package com.baloise.cc2023diabetes.service.food.model;

import com.baloise.cc2023.diabetes.jooq.tables.pojos.UserProfile;

import java.math.BigDecimal;
import java.util.UUID;

public record UserProfileModel(
        BigDecimal sensitivityMorning,
        BigDecimal sensitivityNoon,
        BigDecimal sensitivityEvening) {

    public static final UserProfileModel EMPTY = new UserProfileModel(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);

    public UserProfile toUserProfile(UUID userId) {
        return new UserProfile(userId, sensitivityMorning, sensitivityNoon, sensitivityEvening);
    }

    public static UserProfileModel fromUserProfile(UserProfile userProfile) {
        return new UserProfileModel(userProfile.getSensitivityMorning(),
                userProfile.getSensitivityNoon(), userProfile.getSensitivityEvening()
        );
    }
}