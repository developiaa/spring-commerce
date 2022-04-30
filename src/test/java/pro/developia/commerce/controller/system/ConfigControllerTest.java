package pro.developia.commerce.controller.system;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;


@Slf4j
@Transactional
@SpringBootTest(properties = "spring.profiles.active:test")
class ConfigControllerTest {

    @Autowired
    ConfigController configController;

    private MockMvc mockMvc;

    @Value("${spring.profiles.active}")
    String PROFILES_ACTIVE;

    @Value("${spring.application.name}")
    private String APPLICATION_NAME;

    @Test
    @DisplayName("서버가 어떤 환경으로 구동됐는지 확인한다.")
    public void checkProfile() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(configController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/config/profiles-active"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(PROFILES_ACTIVE))
        ;
    }

    @Test
    @DisplayName("애플리케이션의 이름을 반환한다.")
    public void checkApplicationName() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(configController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/api/config/application-name"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(APPLICATION_NAME))
        ;
    }

}