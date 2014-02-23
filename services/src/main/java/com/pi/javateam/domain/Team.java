package com.pi.javateam.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pi on 2/12/14.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Table(name = "TEAM")
public class Team  extends AbstractEntity {

    @Column(name = "REAM_NAME")
    private String teamName;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "team")
    private Set<Project> projects = new HashSet<>();

    public Team(Long id, String teamName, String companyName, Set<Project> projects) {
        this.id = id;
        this.teamName = teamName;
        this.companyName = companyName;
        this.projects = projects;
    }

    public Team(Team team){
        this(team.getId(), team.getTeamName(), team.getCompanyName(), new HashSet<Project>());
    }
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
