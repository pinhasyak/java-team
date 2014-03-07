package com.pi.javateam.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pi on 2/12/14.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Table(name = "TEAM")
public class Team extends AbstractEntity {

    @Column(name = "TEAM_NAME")
    private String name;

    @Column(name = "COMPANY_NAME")
    private String company;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "team")
    private Set<Project> projects = new HashSet<>();

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Team() {
    }

    public Team(Long id, String teamName, String companyName, Set<Project> projects) {
        this.id = id;
        this.name = teamName;
        this.company = companyName;
        this.projects = projects;
    }

    public Team(String teamName, String companyName, Set<Project> projects) {
        this(null, teamName, companyName, projects);
    }

    public Team(Team team){
        this(team.getId(), team.getName(), team.getCompany(), new HashSet<Project>());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return false;
        if (!super.equals(o)) return false;

        Team team = (Team) o;

        if (!company.equals(team.company)) return false;
        if (!name.equals(team.name)) return false;
        if (!projects.equals(team.projects)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + company.hashCode();
        return result;
    }
}
