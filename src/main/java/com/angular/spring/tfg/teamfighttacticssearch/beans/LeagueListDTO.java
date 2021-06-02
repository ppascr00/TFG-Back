package com.angular.spring.tfg.teamfighttacticssearch.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueListDTO {

    private String leagueId;
    private List<LeagueItemDTO> entries;
    private String tier;
    private String name;
    private String queue;

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public List<LeagueItemDTO> getEntries() {
        return entries;
    }

    public void setEntries(List<LeagueItemDTO> entries) {
        this.entries = entries;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeagueListDTO that = (LeagueListDTO) o;
        return Objects.equals(leagueId, that.leagueId) &&
                Objects.equals(entries, that.entries) &&
                Objects.equals(tier, that.tier) &&
                Objects.equals(name, that.name) &&
                Objects.equals(queue, that.queue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leagueId, entries, tier, name, queue);
    }

    @Override
    public String toString() {
        return "LeagueListDTO{" +
                "leagueId='" + leagueId + '\'' +
                ", entries=" + entries +
                ", tier='" + tier + '\'' +
                ", name='" + name + '\'' +
                ", queue='" + queue + '\'' +
                '}';
    }
}
