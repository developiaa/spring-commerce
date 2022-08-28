package pro.developia.commerce.controller.system;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/api/system")
@RequiredArgsConstructor
@RestController
public class SystemController {
    @Value("${spring.profiles.active}")
    private String PROFILES_ACTIVE;

    @Value("${spring.application.name}")
    private String APPLICATION_NAME;

    @GetMapping("/profiles-active")
    public String getProfilesActive() {
        return PROFILES_ACTIVE;
    }

    @GetMapping("/application-name")
    public String getApplicationName() {
        return APPLICATION_NAME;
    }
}
