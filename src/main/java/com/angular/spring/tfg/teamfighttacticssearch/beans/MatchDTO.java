package com.angular.spring.tfg.teamfighttacticssearch.beans;

import java.util.Objects;

public class MatchDTO {
    private MetadataDTO metadata;
    private InfoDTO info;

    public MetadataDTO getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataDTO metadata) {
        this.metadata = metadata;
    }

    public InfoDTO getInfo() {
        return info;
    }

    public void setInfo(InfoDTO info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchDTO matchDTO = (MatchDTO) o;
        return metadata.equals(matchDTO.metadata) &&
                info.equals(matchDTO.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, info);
    }
}
