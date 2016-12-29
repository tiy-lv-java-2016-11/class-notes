package com.theironyard;

import com.theironyard.controllers.CalendarSpringController;
import com.theironyard.entities.Event;
import com.theironyard.entities.User;
import com.theironyard.repositories.EventRepository;
import com.theironyard.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalendarSpringApplicationTests {

    @Autowired
    WebApplicationContext wap;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
    }

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/login")
                .param("name", "TestUser")
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());

        User user = userRepository.findFirstByName("TestUser");
        assertNotNull(user);
        assertEquals(userRepository.count(), 1);
    }

    @Test
    public void testCreateEvent() throws Exception{
        String description = "Lunch";
        String dateTime = LocalDateTime.now().toString();

        User user = new User("EventUser");
        userRepository.save(user);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/create-event")
                .param("description", description)
                .param("dateTime", dateTime)
                .sessionAttr(CalendarSpringController.SESSION_USERNAME, user.getName())
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());

        assertEquals(1, eventRepository.count());
//        Event event = eventRepository.findFirst();
    }

}
