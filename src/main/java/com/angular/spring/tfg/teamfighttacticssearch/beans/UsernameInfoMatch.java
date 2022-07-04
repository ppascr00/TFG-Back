package com.angular.spring.tfg.teamfighttacticssearch.beans;

import java.util.Objects;

public class UsernameInfoMatch {

    private int position;
    private String gameLength;
    private String gameDatetime;

    public UsernameInfoMatch() {
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getGameLength() {
        return gameLength;
    }

    public void setGameLength(String gameLength) {
        this.gameLength = gameLength;
    }

    public String getGameDatetime() {
        return gameDatetime;
    }

    public void setGameDatetime(String gameDatetime) {
        this.gameDatetime = gameDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsernameInfoMatch that = (UsernameInfoMatch) o;
        return position == that.position &&
                Objects.equals(gameLength, that.gameLength) &&
                Objects.equals(gameDatetime, that.gameDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, gameLength, gameDatetime);
    }

    @Override
    public String toString() {
        return "UsernameInfoMatch{" +
                "position=" + position +
                ", gameLength='" + gameLength + '\'' +
                ", gameDatetime='" + gameDatetime + '\'' +
                '}';
    }
}
