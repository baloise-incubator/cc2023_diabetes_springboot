package com.baloise.cc2023diabetes.service.food.model;

import com.baloise.cc2023.diabetes.jooq.tables.pojos.UserProfile;

import java.math.BigDecimal;

public record UserProfileModel(
        BigDecimal sensitivityMorning,
        BigDecimal sensitivityNoon,
        BigDecimal sensitivityEvening) {

    public UserProfile toUserProfile(String userId) {
        return new UserProfile(userId, sensitivityMorning, sensitivityNoon, sensitivityEvening);
    }

    public static UserProfileModel fromUserProfile(UserProfile userProfile) {
        return new UserProfileModel(userProfile.getSensitivityMorning(),
                userProfile.getSensitivityNoon(), userProfile.getSensitivityEvening()
        );
    }
}