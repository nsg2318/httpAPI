package com.apitest.helloapi.domain;

public class Document {
    private Long id;
    private String name;

    public Document(String name) {
        this.name = name;
    }

    public Document() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
