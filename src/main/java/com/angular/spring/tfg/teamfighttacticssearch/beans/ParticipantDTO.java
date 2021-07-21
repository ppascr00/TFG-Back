package com.angular.spring.tfg.teamfighttacticssearch.beans;

import java.util.List;
import java.util.Objects;

public class ParticipantDTO {
    private CompanionDTO companion;
    private int gold_left;
    private int last_round;
    private int level;
    private int placement;
    private int players_eliminated;
    private String puuid;
    private float time_eliminated;
    private int total_damage_to_players;
    private List<TraitDTO> traits;
    private List<UnitDTO> units;

    public CompanionDTO getCompanion() {
        return companion;
    }

    public void setCompanion(CompanionDTO companion) {
        this.companion = companion;
    }

    public int getGold_left() {
        return gold_left;
    }

    public void setGold_left(int gold_left) {
        this.gold_left = gold_left;
    }

    public int getLast_round() {
        return last_round;
    }

    public void setLast_round(int last_round) {
        this.last_round = last_round;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public int getPlayers_eliminated() {
        return players_eliminated;
    }

    public void setPlayers_eliminated(int players_eliminated) {
        this.players_eliminated = players_eliminated;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public float getTime_eliminated() {
        return time_eliminated;
    }

    public void setTime_eliminated(float time_eliminated) {
        this.time_eliminated = time_eliminated;
    }

    public int getTotal_damage_to_players() {
        return total_damage_to_players;
    }

    public void setTotal_damage_to_players(int total_damage_to_players) {
        this.total_damage_to_players = total_damage_to_players;
    }

    public List<TraitDTO> getTraits() {
        return traits;
    }

    public void setTraits(List<TraitDTO> traits) {
        this.traits = traits;
    }

    public List<UnitDTO> getUnits() {
        return units;
    }

    public void setUnits(List<UnitDTO> units) {
        this.units = units;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantDTO that = (ParticipantDTO) o;
        return gold_left == that.gold_left &&
                last_round == that.last_round &&
                level == that.level &&
                placement == that.placement &&
                players_eliminated == that.players_eliminated &&
                Float.compare(that.time_eliminated, time_eliminated) == 0 &&
                total_damage_to_players == that.total_damage_to_players &&
                Objects.equals(companion, that.companion) &&
                puuid.equals(that.puuid) &&
                traits.equals(that.traits) &&
                units.equals(that.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companion, gold_left, last_round, level, placement, players_eliminated, puuid, time_eliminated, total_damage_to_players, traits, units);
    }
}
