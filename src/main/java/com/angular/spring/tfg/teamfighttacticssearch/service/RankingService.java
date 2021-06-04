package com.angular.spring.tfg.teamfighttacticssearch.service;

import com.angular.spring.tfg.teamfighttacticssearch.beans.LeagueListDTO;

public interface RankingService {
    LeagueListDTO getLeaderboard(String platform, String league);
}
