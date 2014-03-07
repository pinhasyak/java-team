package com.pi.javateam.web.resources;

import com.pi.javateam.domain.Project;
import com.pi.javateam.web.TeamController;
import org.springframework.hateoas.ResourceSupport;

import java.util.Set;

/**
 * Created by pi on 3/3/14.
 */
    public class TeamResource extends MyResource {
    private String name;
    private String company;
    @Link(controllerName= TeamController.class,methodName = "loadTeamProjects")
    private Set<ProjectResource> projectResources;
}
