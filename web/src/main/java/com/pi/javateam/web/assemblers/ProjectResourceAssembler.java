package com.pi.javateam.web.assemblers;

import com.pi.javateam.domain.Project;
import com.pi.javateam.web.ProjectController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by pi on 2/12/14.
 */
@Component
public class ProjectResourceAssembler implements ResourceAssembler<Project,Resource<Project>> {
    private final String TEAM_REL  = "team";

    @Override
    public Resource<Project> toResource(Project project) {
        Project tempProject = new Project(project);
        Long projectId = tempProject.getId();
        Resource<Project> projectResource = new Resource<>(tempProject);
        projectResource.add(linkTo(methodOn(ProjectController.class).loadProject(projectId)).withSelfRel());
//        projectResource.add(linkTo(methodOn(ProjectController.class).loadProjetTeam(projectId)).withRel(TEAM_REL));
        return projectResource;
    }
}
