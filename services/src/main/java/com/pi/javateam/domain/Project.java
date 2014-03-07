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
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (nullable = false, name = "PROJECT_TEAM_ID_FKEY")
    private Team team;

    public Project() {
    }

    public Project(String projectName, String description) {
        this.name = projectName;
        this.description = description;
    }
    public Project(Project project){
        this(project.getId(),project.getName(),project.getDescription(),project.getTeam());
    }
    public Project(String projectName, String description,Team team){
        this(null,projectName,description,team);
    }
    public Project(Long id, String projectName, String description,Team team) {
        this.id = id;
        this.name = projectName;
        this.description = description;
        this.team=team;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        if (!super.equals(o)) return false;

        Project project = (Project) o;

        if (description != null ? !description.equals(project.description) : project.description != null) return false;
        if (!name.equals(project.name)) return false;
        if (team != null ? !team.equals(project.team) : project.team != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (team != null ? team.hashCode() : 0);
        return result;
    }
}
