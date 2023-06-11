package api;

import api.schemas.RegistrationDto;
import com.github.javafaker.Faker;
import io.restassured.response.Response;

public class RegistrationApi extends ApiBase {
    Response response;
    RegistrationDto dto;
    Faker faker = new Faker();


    public RegistrationDto randomDataBodyForRegisterUser(String password) {
        dto = new RegistrationDto();
        dto.setUserName(faker.name().username());
        dto.setPassword(password); // "yA*UeeuA2pU3"
        return dto;
    }

    public Response registerUser(Integer code, String password) {
        String endpoint = "/Account/v1/User";
        response = postRequest(endpoint, code, randomDataBodyForRegisterUser(password));
        return response;
    }
}
