package com.ksidelta.calendal.services.communication;

import com.ksidelta.calendal.CalendalApplication;
import com.ksidelta.calendal.services.events.FacebookEventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CalendalApplication.class)
public class FacebookApiTest {
    @Autowired
    FacebookApi facebookApi;

    @Test
    public void whenFacebookIsLookedForThenExplicitEntryIsReturned(){
        System.out.println(facebookApi.fetchPages("facebook"));

    }
}
