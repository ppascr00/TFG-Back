package com.angular.spring.tfg.teamfighttacticssearch.beans;

import java.util.Objects;

public class CompanionDTO {
    private String content_ID;
    private int skin_ID;
    private String species;

    public String getContent_ID() {
        return content_ID;
    }

    public void setContent_ID(String content_ID) {
        this.content_ID = content_ID;
    }

    public int getSkin_ID() {
        return skin_ID;
    }

    public void setSkin_ID(int skin_ID) {
        this.skin_ID = skin_ID;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanionDTO that = (CompanionDTO) o;
        return skin_ID == that.skin_ID &&
                Objects.equals(content_ID, that.content_ID) &&
                Objects.equals(species, that.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content_ID, skin_ID, species);
    }
}
