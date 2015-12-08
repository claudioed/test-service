package com.shivang.authentication.tests;

import com.shivang.authentication.AuthenticationApplication;
import java.util.HashMap;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AuthenticationApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class AuthenticationResourceTest {

    private static final String BASE_URL = "http://localhost:9000/authentication-service";
    private final RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testAuthenticate() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("username", "username");
        map.add("password", "password");
        ResponseEntity<HashMap> entity = restTemplate.postForEntity(BASE_URL + "/authenticate",map, HashMap.class);
        assertThat(entity.getStatusCode().value()).isEqualTo(200);
        assertThat(entity.getBody().get("success")).isEqualTo(true);
        map.clear();
        map.add("username", "username");
        entity = restTemplate.postForEntity(BASE_URL + "/authenticate",map, HashMap.class);
        assertThat(entity.getStatusCode().value()).isEqualTo(200);
        assertThat(entity.getBody().get("success")).isEqualTo(false);
    }
}
