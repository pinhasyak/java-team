package com.pi.javateam.web;

import com.pi.javateam.domain.Team;
import com.pi.javateam.domain.User;
import com.pi.javateam.services.CrmService;
import com.pi.javateam.services.TeamService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by pi on 2/25/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestContext.class,WebMvcConfiguration.class})
public class TeamControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private TeamService teamServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        Mockito.reset(teamServiceMock);
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    @Test
    public void loadTeam() throws Exception {
        Long id = new Long(1);
        Team team = new Team(id,"javaTeam","bank",null);
        Mockito.when(teamServiceMock.findById(id)).thenReturn(team);
        mockMvc.perform(get("/teams/"+id.longValue()))
                .andExpect(status().isOk())
//                .andExpect(content().contentType(TestUtil.APPLICATION_JSON))
//                .andExpect(jsonPath("$.lastName", Matchers.is("yak")))
//                .andExpect(jsonPath("$.firstName", Matchers.is("pi")))
//                .andExpect(jsonPath("$.username", Matchers.is("username")))
//                .andExpect(jsonPath("$.password", Matchers.nullValue()))
//                .andExpect(jsonPath("$.links[0].rel",Matchers.is("self")))
//                .andExpect(jsonPath("$.links[0].href",Matchers.is("http://localhost/users/1")))
//                .andExpect(jsonPath("$.links[1].rel",Matchers.is("customers")))
//                .andExpect(jsonPath("$.links[1 ].href",Matchers.is("http://localhost/users/1/customers")))
        ;
    }
}