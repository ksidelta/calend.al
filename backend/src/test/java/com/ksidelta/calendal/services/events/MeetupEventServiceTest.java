package com.ksidelta.calendal.services.events;

import org.junit.jupiter.api.Test;
import com.ksidelta.calendal.services.events.MeetupEventService; 
import com.ksidelta.calendal.CalendalApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CalendalApplication.class)
public class MeetupEventServiceTest {
    @Autowired
    protected MeetupEventService meetupEventService;

    @Test
    public void whenUserGroupIsSearchedThenListIsReturned(){
        var output = this.meetupEventService.findPages("User Group");
    }
}
