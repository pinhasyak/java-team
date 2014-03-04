package com.pi.javateam.web.assemblers;

import com.pi.javateam.domain.Team;
import com.pi.javateam.web.TeamController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by pi on 2/12/14.
 */
@Component
public class TeamResourceAssembler implements ResourceAssembler<Team, Resource<Team>> {

    public static final String PROJECTS_REL = "projects";

    @Override
    public Resource<Team> toResource(Team team) {
        Team tempTeam = new Team(team);
        Long teamId = tempTeam.getId();
        Resource<Team> teamResource = new Resource<>(tempTeam);
        teamResource.add(linkTo(methodOn(TeamController.class).loadTeam(teamId)).withSelfRel());
        teamResource.add(linkTo(methodOn(TeamController.class).loadTeamProjects(teamId)).withRel(PROJECTS_REL));
        return teamResource;
    }
}
