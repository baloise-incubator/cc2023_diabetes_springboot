package com.baloise.cc2023diabetes.service.food;

import com.baloise.cc2023.diabetes.jooq.tables.daos.UserProfileDao;
import com.baloise.cc2023.diabetes.jooq.tables.pojos.UserProfile;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final DSLContext jooq;

    public Optional<UserProfile> loadUserProfile(String userId){
       return new UserProfileDao(jooq.configuration())
                .findOptionalById(userId);
    }

    public void saveUserProfile(UserProfile profile){
        new UserProfileDao(jooq.configuration()).update(profile);
    }
}
