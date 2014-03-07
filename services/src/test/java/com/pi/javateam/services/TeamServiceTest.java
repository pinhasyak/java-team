package com.pi.javateam.services;

import com.pi.javateam.domain.Project;
import com.pi.javateam.domain.Team;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pi on 2/23/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfiguration.class)
@Transactional
@TransactionConfiguration
public class TeamServiceTest {
    private static String TEAM_NAME = "java_infra";
    private static String COMPANY_NAME = "company_name";
    private Team team;

    @Inject
    private TeamService teamService;

    @Before
    public void setUp(){
        List<Team> teams = teamService.findTeamsByName(TEAM_NAME);
        if(teams.isEmpty()){
           team = teamService.createTeam(TEAM_NAME,COMPANY_NAME,null);

            Set<Project> projectSet = new HashSet<>();
            for(int i=1;i<=10;i++){
                Project project = new Project("name_"+i,"desc",team);
                projectSet.add(project);
            }
            team.setProjects(projectSet);
            teamService.save(team);
        }else{
            team = teams.get(0);
        }

    }
    @Test
    public void findTeamById(){
        Team testTeam = teamService.findById(team.getId());
        Assert.assertNotNull(testTeam);
    }

    @Test
    public void findTeamByName(){
        List<Team> teams = teamService.findTeamsByName(TEAM_NAME);
        Team testTeam = teams.get(0);
        Assert.assertNotNull(testTeam);
        System.out.println("Printing Projects !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        for(Project project:testTeam.getProjects()){
            System.out.println(project);
        }
    }
    @Test
    public void findTeamByCompany(){
        List<Team> teams = teamService.findTeamsByCompany(COMPANY_NAME);
        Team testTeam = teams.get(0);
        Assert.assertNotNull(testTeam);
    }
    @Test
    public void findAll(){
        List<Team> teams = teamService.findAll();
        Assert.assertNotNull(teams);
    }

}
