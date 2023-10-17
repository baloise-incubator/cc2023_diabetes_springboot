package com.baloise.cc2023diabetes.json.user.profile;

import com.baloise.cc2023diabetes.service.food.UserProfileService;
import com.baloise.cc2023diabetes.service.food.model.UserProfileModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class JsonUserProfileController {
    private final UserProfileService userProfileService;

    @GetMapping("/json/user-profile")
    public Optional<UserProfileModel> getUserProfile(Principal principal) {
        return userProfileService.loadUserProfile(principal.getName());
    }

    @PutMapping("/json/user-profile")
    public void putUserProfile(Principal principal, @RequestBody UserProfileModel model) {
        userProfileService.upsertUserProfile(principal.getName(), model);
    }
}