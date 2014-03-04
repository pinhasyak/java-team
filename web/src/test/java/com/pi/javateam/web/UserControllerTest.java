package com.pi.javateam.web;

import com.jayway.jsonassert.impl.matcher.IsCollectionWithSize;
import com.pi.javateam.domain.User;
import com.pi.javateam.services.CrmService;
import com.pi.javateam.web.config.TestContext;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by pi on 2/25/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestContext.class,WebMvcConfiguration.class})
public class UserControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private CrmService crmServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        Mockito.reset(crmServiceMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    @Test
    public void loadUser() throws Exception {
        Long id = new Long(1);
        User user = new User("username", "password", "pi", "yak");
        Mockito.when(crmServiceMock.findById(id)).thenReturn(user);
        mockMvc.perform(get("/users/"+id.longValue()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON))
                .andExpect(jsonPath("$.lastName", Matchers.is("yak")))
                .andExpect(jsonPath("$.firstName", Matchers.is("pi")))
                .andExpect(jsonPath("$.username", Matchers.is("username")))
                .andExpect(jsonPath("$.password", Matchers.nullValue()))
                .andExpect(jsonPath("$.links[0].rel",Matchers.is("self")))
                .andExpect(jsonPath("$.links[0].href",Matchers.is("http://localhost/users/1")))
                .andExpect(jsonPath("$.links[1].rel",Matchers.is("customers")))
                .andExpect(jsonPath("$.links[1].href",Matchers.is("http://localhost/users/1/customers")))
        ;
    }
}