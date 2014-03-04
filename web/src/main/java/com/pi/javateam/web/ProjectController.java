package com.pi.javateam.web;

import com.pi.javateam.domain.Project;
import com.pi.javateam.domain.Team;
import com.pi.javateam.services.ProjectService;
import com.pi.javateam.web.assemblers.ProjectResourceAssembler;
import com.pi.javateam.web.assemblers.TeamResourceAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
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
@ExposesResourceFor(Project.class)
@RequestMapping(value = "projects", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {;
    ProjectService projectService;
    ProjectResourceAssembler projectResourceAssembler;
    TeamResourceAssembler teamResourceAssembler;

    @Inject
    public ProjectController(ProjectService projectService, ProjectResourceAssembler projectResourceAssembler,TeamResourceAssembler teamResourceAssembler) {
        this.projectService = projectService;
        this.projectResourceAssembler = projectResourceAssembler;
        this.teamResourceAssembler = teamResourceAssembler;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public HttpEntity<Resource<Project>> loadProject(@PathVariable Long projectId) {
        Resource<Project> resource = this.projectResourceAssembler.toResource(projectService.findById(projectId));
        return new ResponseEntity<Resource<Project>>(resource, HttpStatus.OK);
    }

}
