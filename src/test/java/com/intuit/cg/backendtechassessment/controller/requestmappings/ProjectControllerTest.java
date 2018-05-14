package com.intuit.cg.backendtechassessment.controller.requestmappings;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.cg.backendtechassessment.BackendTechAssessmentApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackendTechAssessmentApplication.class)
@AutoConfigureMockMvc
public class ProjectControllerTest {

    private static final String BASE_URL = "http://localhost:8084/rest/api/";

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetWithSuccess() throws Exception
    {
        String url = BASE_URL + RequestMappings.PROJECTS + "/3";
        mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }



}