package com.baloise.cc2023diabetes.json.user.profile;

import com.baloise.cc2023.diabetes.jooq.tables.pojos.UserProfile;
import com.baloise.cc2023diabetes.service.food.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class JsonUserProfileController {
    private final UserProfileService userProfileService;

    @GetMapping("/json/user-profile")
    public Optional<UserProfile> getUserProfile(Principal principal){
        return userProfileService.loadUserProfile(principal.getName());
    }

    @PatchMapping("/json/user-profile")
    public void patchUserProfile(Principal principal){
    }
}
