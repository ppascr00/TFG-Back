package com.angular.spring.tfg.teamfighttacticssearch.beans;

import java.util.List;
import java.util.Objects;

public class MetadataDTO {
    private String data_version;
    private String match_id;
    private List<String> participants;

    public String getData_version() {
        return data_version;
    }

    public void setData_version(String data_version) {
        this.data_version = data_version;
    }

    public String getMatch_id() {
        return match_id;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetadataDTO that = (MetadataDTO) o;
        return Objects.equals(data_version, that.data_version) &&
                Objects.equals(match_id, that.match_id) &&
                Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data_version, match_id, participants);
    }
}
