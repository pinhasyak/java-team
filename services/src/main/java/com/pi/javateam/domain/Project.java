package com.pi.javateam.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by pi on 2/12/14.
 */

@Entity
@Table(name = "PROJECT")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Project extends AbstractEntity {

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name="DESCRIPTION")
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (nullable = false, name = "project_team_id_fkey")
    private Team team;

    public Project(String projectName, String description) {
        this.projectName = projectName;
        this.description = description;
    }
    public Project(Project project){
        this(project.getId(),project.getProjectName(),project.getDescription());
    }
    public Project(Long id, String projectName, String description) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
