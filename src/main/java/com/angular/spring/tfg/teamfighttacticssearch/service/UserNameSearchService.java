package com.angular.spring.tfg.teamfighttacticssearch.service;

import com.angular.spring.tfg.teamfighttacticssearch.beans.MatchDTO;

import java.util.List;

public interface UserNameSearchService {
    List<MatchDTO> getSummonerInfo(String platform, String summonerName);
}
