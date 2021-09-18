package site.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import site.interfaces.user.RegistrationInterface;

@Component
//@WebMvcTest(RegistrationController.class)
//@AutoConfigureMockMvc
//@SpringBootTest
public class RegistrationSteps extends BaseSteps {

//    @Autowired
//    private MockMvc mockMvc;

    @Autowired
    private RegistrationInterface registrationInterface;


    public void createUser(String email, String password) throws Exception {
        registrationInterface.createUser(email, password);
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/createUser")
//                        .param("email", TestData.getRandomEmail())
//                        .param("password", TestData.getRandomPassword())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().is2xxSuccessful());
    }
}
