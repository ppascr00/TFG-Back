package com.angular.spring.tfg.teamfighttacticssearch.service;

import com.angular.spring.tfg.teamfighttacticssearch.beans.UsernameInfoMatch;

import java.util.List;

public interface UserNameSearchService {
    List<UsernameInfoMatch> getSummonerInfo(String platform, String summonerName);
}
