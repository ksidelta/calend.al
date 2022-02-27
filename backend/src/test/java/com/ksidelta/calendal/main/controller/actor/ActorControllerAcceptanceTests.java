package com.ksidelta.calendal.main.controller.actor;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ActorControllerAcceptanceTests {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void whenActorSearchesForSourcesThenTheyAreReturnedAccordingToTheSearchQuery() {
        var response =
                testRestTemplate.getForEntity(
                        "/api/main/actor/search?searchString={searchString}",
                        SearchedSourcesViewModel.class,
                        Map.of("searchString", "B")
                );

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody(), equalTo(new SearchedSourcesViewModel(
                Arrays.asList(new SearchedSourcesViewModel.SourceElement("B", "Group B", "mock"))
        )));
    }

}