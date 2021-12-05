package com.example.project3frontend;

public class Project {
    private Integer project_id;
    private String currency;
    private boolean isOpen;
    private String urlString;
    private String datePublished;
    private boolean anon;
    private String projectName;
    private float budget;
    private String description;

    // Setters
    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public void setAnon(boolean anon) {
        this.anon = anon;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getters
    public Integer getProject_id() {
        return project_id;
    }

    public String getProjectName() {
        return projectName;
    }

    public float getBudget() {
        return budget;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getUrlString() {
        return urlString;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public boolean isAnon() {
        return anon;
    }

    public String getDescription() {
        return description;
    }
}
