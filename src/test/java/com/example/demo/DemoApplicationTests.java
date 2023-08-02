package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldGetPageOfBook() {


        webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/api/books")
                        .queryParam("page", 1)
                        .queryParam("size", 2)
                        .build())
                .exchange()
                .expectBody()
                .jsonPath("$.totalElements").isEqualTo(100);
    }


}
