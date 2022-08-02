package com.jbtc.rickymorty.model;

import java.util.List;

public class PaginationCharacter {
    private Info info;
    private List<Character> results;

    public PaginationCharacter() {
    }

    public PaginationCharacter(Info info, List<Character> results) {
        this.info = info;
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "PaginationCharacter{" +
                "info=" + info +
                ", results=" + results +
                '}';
    }
}
