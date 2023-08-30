package com.example.wasaaaaa.models;

public class Class {
    private Long classId;
    private String className;
    private String description;
    private Long instructorId;
    private String status;

    public Class() {
    }

    public Class(Long classId, String className, String description, Long instructorId, String status) {
        this.classId = classId;
        this.className = className;
        this.description = description;
        this.instructorId = instructorId;
        this.status = status;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
