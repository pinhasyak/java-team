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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created by pi on 2/12/14.
 */
@Controller
@ExposesResourceFor(Team.class)
@RequestMapping(value = "/teams", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeamController {
    TeamService teamService;
    TeamResourceAssembler teamResourceAssembler;
    @Inject
    public TeamController(TeamService teamService, TeamResourceAssembler teamResourceAssembler) {
        this.teamService = teamService;
        this.teamResourceAssembler = teamResourceAssembler;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public HttpEntity<Resource<Team>> loadTeam(@PathVariable Long teamId) {
        Resource<Team> resource = this.teamResourceAssembler.toResource(teamService.findById(teamId));
        return new ResponseEntity<Resource<Team>>(resource, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}/projects")
    public HttpEntity<Resources<Resource<Project>>> loadTeamProjects(@PathVariable Long teamId){
        return null;
    }

}