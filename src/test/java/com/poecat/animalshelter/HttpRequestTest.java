package com.poecat.animalshelter;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void loginShouldReturnLoginPage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/login",
                String.class)).contains("login");
    }

    @Test
    public void downloadsShouldReturnDownloadsPage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/downloads",
                String.class)).contains("downloads");
    }
}
