package com.pi.javateam.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
