package com.baloise.cc2023diabetes.service.food.model;


import com.baloise.cc2023diabetes.generated.tables.pojos.UserProfile;

import java.util.UUID;

public record UserProfileModel(
        Double sensitivityMorning,
        Double sensitivityNoon,
        Double sensitivityEvening) {

    public static final UserProfileModel EMPTY = new UserProfileModel(0.0, 0.0, 0.0);

    public UserProfile toUserProfile(UUID userId) {
        return new UserProfile(userId, sensitivityMorning, sensitivityNoon, sensitivityEvening);
    }

    public static UserProfileModel fromUserProfile(UserProfile userProfile) {
        return new UserProfileModel(userProfile.getSensitivityMorning(),
                userProfile.getSensitivityNoon(), userProfile.getSensitivityEvening()
        );
    }
}