package com.angular.spring.tfg.teamfighttacticssearch.beans;

import java.util.List;
import java.util.Objects;

public class UnitDTO {
    private List<Integer> items;
    private String character_id;
    private String chosen;
    private String name;
    private int rarity;
    private int tier;

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    public String getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(String character_id) {
        this.character_id = character_id;
    }

    public String getChosen() {
        return chosen;
    }

    public void setChosen(String chosen) {
        this.chosen = chosen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitDTO unitDTO = (UnitDTO) o;
        return rarity == unitDTO.rarity &&
                tier == unitDTO.tier &&
                Objects.equals(items, unitDTO.items) &&
                Objects.equals(character_id, unitDTO.character_id) &&
                Objects.equals(chosen, unitDTO.chosen) &&
                Objects.equals(name, unitDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, character_id, chosen, name, rarity, tier);
    }
}
