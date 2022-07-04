package com.angular.spring.tfg.teamfighttacticssearch.beans;

import java.util.Objects;

public class TraitDTO {
    private String name;
    private int num_units;
    private int style;
    private int tier_current;
    private int tier_total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum_units() {
        return num_units;
    }

    public void setNum_units(int num_units) {
        this.num_units = num_units;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public int getTier_current() {
        return tier_current;
    }

    public void setTier_current(int tier_current) {
        this.tier_current = tier_current;
    }

    public int getTier_total() {
        return tier_total;
    }

    public void setTier_total(int tier_total) {
        this.tier_total = tier_total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TraitDTO traitDTO = (TraitDTO) o;
        return num_units == traitDTO.num_units &&
                style == traitDTO.style &&
                tier_current == traitDTO.tier_current &&
                tier_total == traitDTO.tier_total &&
                name.equals(traitDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, num_units, style, tier_current, tier_total);
    }
}
