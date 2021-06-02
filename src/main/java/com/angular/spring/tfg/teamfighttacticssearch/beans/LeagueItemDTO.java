package com.angular.spring.tfg.teamfighttacticssearch.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueItemDTO {

    private boolean freshBlood;
    private int wins;
    private String summonerName;
    private MiniSeriesDTO miniSeries;
    private boolean inactive;
    private boolean veteran;
    private boolean hotStreak;
    private String rank;
    private int leaguePoints;
    private int losses;
    private String summonerId;

    public boolean isFreshBlood() {
        return freshBlood;
    }

    public void setFreshBlood(boolean freshBlood) {
        this.freshBlood = freshBlood;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public MiniSeriesDTO getMiniSeries() {
        return miniSeries;
    }

    public void setMiniSeries(MiniSeriesDTO miniSeries) {
        this.miniSeries = miniSeries;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public boolean isVeteran() {
        return veteran;
    }

    public void setVeteran(boolean veteran) {
        this.veteran = veteran;
    }

    public boolean isHotStreak() {
        return hotStreak;
    }

    public void setHotStreak(boolean hotStreak) {
        this.hotStreak = hotStreak;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeagueItemDTO that = (LeagueItemDTO) o;
        return freshBlood == that.freshBlood &&
                wins == that.wins &&
                inactive == that.inactive &&
                veteran == that.veteran &&
                hotStreak == that.hotStreak &&
                leaguePoints == that.leaguePoints &&
                losses == that.losses &&
                Objects.equals(summonerName, that.summonerName) &&
                Objects.equals(miniSeries, that.miniSeries) &&
                Objects.equals(rank, that.rank) &&
                Objects.equals(summonerId, that.summonerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(freshBlood, wins, summonerName, miniSeries, inactive, veteran, hotStreak, rank, leaguePoints, losses, summonerId);
    }
}
