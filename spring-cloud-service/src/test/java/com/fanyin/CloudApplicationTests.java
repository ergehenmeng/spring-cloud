package com.fanyin;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=CloudApplication.class)
public class CloudApplicationTests {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void before(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void index(){
		try {
			MvcResult result = mockMvc.perform(
					MockMvcRequestBuilders.get("/index/1")
							.accept(MediaType.ALL)).andReturn();
			int status = result.getResponse().getStatus();
			System.out.println(result.getResponse().getContentAsString());
		}catch (Exception e){

		}

	}


}
