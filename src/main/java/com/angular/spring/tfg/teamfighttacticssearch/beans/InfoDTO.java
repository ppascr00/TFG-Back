package com.angular.spring.tfg.teamfighttacticssearch.beans;

import java.util.List;
import java.util.Objects;

public class InfoDTO {
    private long game_datetime;
    private float game_length;
    private String game_variaton;
    private String game_version;
    private List<ParticipantDTO> participants;
    private int queue_id;
    private int tft_set_number;

    public long getGame_datetime() {
        return game_datetime;
    }

    public void setGame_datetime(long game_datetime) {
        this.game_datetime = game_datetime;
    }

    public float getGame_length() {
        return game_length;
    }

    public void setGame_length(float game_length) {
        this.game_length = game_length;
    }

    public String getGame_variaton() {
        return game_variaton;
    }

    public void setGame_variaton(String game_variaton) {
        this.game_variaton = game_variaton;
    }

    public String getGame_version() {
        return game_version;
    }

    public void setGame_version(String game_version) {
        this.game_version = game_version;
    }

    public List<ParticipantDTO> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantDTO> participants) {
        this.participants = participants;
    }

    public int getQueue_id() {
        return queue_id;
    }

    public void setQueue_id(int queue_id) {
        this.queue_id = queue_id;
    }

    public int getTft_set_number() {
        return tft_set_number;
    }

    public void setTft_set_number(int tft_set_number) {
        this.tft_set_number = tft_set_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoDTO infoDTO = (InfoDTO) o;
        return game_datetime == infoDTO.game_datetime &&
                Float.compare(infoDTO.game_length, game_length) == 0 &&
                queue_id == infoDTO.queue_id &&
                tft_set_number == infoDTO.tft_set_number &&
                Objects.equals(game_variaton, infoDTO.game_variaton) &&
                Objects.equals(game_version, infoDTO.game_version) &&
                Objects.equals(participants, infoDTO.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_datetime, game_length, game_variaton, game_version, participants, queue_id, tft_set_number);
    }
}
