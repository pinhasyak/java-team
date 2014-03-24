package com.pi.javateam.web;

import com.pi.javateam.domain.Project;
import com.pi.javateam.domain.Team;
import com.pi.javateam.services.TeamService;
import com.pi.javateam.web.assemblers.TeamResourceAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by pi on 2/12/14.
 */
@Controller
@ExposesResourceFor(Team.class)
@RequestMapping(value = ApiUrls.ROOT_URL_TEAMS, produces = MediaType.APPLICATION_JSON_VALUE)
public class TeamController {
    TeamService teamService;
    TeamResourceAssembler teamResourceAssembler;
    @Inject
    public TeamController(TeamService teamService, TeamResourceAssembler teamResourceAssembler) {
        this.teamService = teamService;
        this.teamResourceAssembler = teamResourceAssembler;
    }

    @RequestMapping(method = RequestMethod.GET, value = ApiUrls.URL_USERS_TEAM)
    public HttpEntity<Resource<Team>> loadTeam(@PathVariable Long team) {
        Resource<Team> resource = this.teamResourceAssembler.toResource(teamService.findById(team));
        return new ResponseEntity<Resource<Team>>(resource, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "")
    public HttpEntity<Resources<Resource<Team>>> loadAllTeams(){
        List<Team> teams = this.teamService.findAll();
        Collection<Resource<Team>> resourceCollection = new ArrayList<>();
        for(Team team:teams){
            resourceCollection.add(this.teamResourceAssembler.toResource(team));
        }
        Resources<Resource<Team>> resources = new Resources<>(resourceCollection);
        return new ResponseEntity<Resources<Resource<Team>>>(resources,HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST,value = ApiUrls.URL_USERS_TEAM)
    public @ResponseBody void savePerson(@RequestBody Team team) {
        teamService.save(team);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{team}/projects")
    public HttpEntity<Resources<Resource<Project>>> loadTeamProjects(@PathVariable Long team){
        return null;
    }

}
