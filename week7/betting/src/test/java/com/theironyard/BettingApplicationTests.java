package com.theironyard;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theironyard.entities.SportsBook;
import com.theironyard.repositories.SportsBookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BettingApplicationTests {

	@Autowired
	SportsBookRepository sportsBookRepository;

	@Autowired
	WebApplicationContext wap;

	MockMvc mockMvc;

	@Before
	public void before(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
	}

	@Test
	public void testCreateSportsBook() throws Exception {
		SportsBook sportsBook = new SportsBook("Test Sportsbook");

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(sportsBook);

		mockMvc.perform(
				MockMvcRequestBuilders.post("/sports-books/")
				.content(json)
				.contentType("application/json")
		).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

		SportsBook sb = sportsBookRepository.findOne(1);
		assertNotNull(sb);
		assertEquals("Test Sportsbook", sb.getName());

	}

}
