package com.baloise.cc2023diabetes.service.food;

import com.baloise.cc2023.diabetes.jooq.tables.daos.UserProfileDao;
import com.baloise.cc2023.diabetes.jooq.tables.pojos.UserProfile;
import com.baloise.cc2023diabetes.service.food.model.UserProfileModel;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final DSLContext jooq;

    public Optional<UserProfileModel> loadUserProfile(UUID userId) {
        return new UserProfileDao(jooq.configuration())
                .findOptionalById(userId).map(UserProfileModel::fromUserProfile);
    }

    @Synchronized
    public void upsertUserProfile(UUID userId, UserProfileModel profile) {
        UserProfileDao dao = new UserProfileDao(jooq.configuration());
        UserProfile entity = profile.toUserProfile(userId);
        loadUserProfile(userId).ifPresentOrElse(p -> dao.update(entity), () -> dao.insert(entity));
    }
}
