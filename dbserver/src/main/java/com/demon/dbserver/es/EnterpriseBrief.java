package com.demon.dbserver.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "dbserver", type = "enterprise")
public class EnterpriseBrief implements Serializable {
    @Id
    private Integer id;
    private String enterpriseName;

    public EnterpriseBrief() {

    }

    public EnterpriseBrief(Integer id, String enterpriseName) {
        this.id = id;
        this.enterpriseName = enterpriseName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    @Override
    public String toString() {
        return "id: " + id + ", enterpriseName='" + enterpriseName;
    }
}
