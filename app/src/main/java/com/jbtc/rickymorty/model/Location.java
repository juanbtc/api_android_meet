package com.jbtc.rickymorty.model;

public class Location {
    private int id;
    private String name;
    private String type;
    private String url;
    private String dimension;
    private String created;

    public Location() {
    }

    public Location(int id, String name, String type, String url, String dimension, String created) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.url = url;
        this.dimension = dimension;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", dimension='" + dimension + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
