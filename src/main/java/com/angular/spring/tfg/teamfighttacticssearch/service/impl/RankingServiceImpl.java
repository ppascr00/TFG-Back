package com.angular.spring.tfg.teamfighttacticssearch.service.impl;

import com.angular.spring.tfg.teamfighttacticssearch.beans.LeagueListDTO;
import com.angular.spring.tfg.teamfighttacticssearch.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RankingServiceImpl implements RankingService {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public LeagueListDTO getLeaderboard(String platform, String league) {
        LeagueListDTO leagueListDTO = restTemplate.getForObject("https://"+ platform +".api.riotgames.com/tft/league/v1/"+ league +"?api_key=" + apiKey, LeagueListDTO.class);

        return leagueListDTO;
    }
}
