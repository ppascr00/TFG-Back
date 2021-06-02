package com.angular.spring.tfg.teamfighttacticssearch.rest;

import com.angular.spring.tfg.teamfighttacticssearch.beans.LeagueListDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

@Configuration
public class RestCalls {

    @Value("${api.key}")
    private String apiKey;

    @Bean
    public void getChallengerList(){

        RestTemplate restTemplate = new RestTemplate();

        System.out.println("CHALLENGER");
        System.out.println(apiKey);

        LeagueListDTO leagueListDTO = restTemplate.getForObject("https://euw1.api.riotgames.com/tft/league/v1/challenger?api_key="+apiKey, LeagueListDTO.class);

        System.out.println(leagueListDTO);

        System.out.println(leagueListDTO.getName());

    }

    @Bean
    public void getMasterList(){

        RestTemplate restTemplate = new RestTemplate();

        System.out.println("MASTER");
        System.out.println(apiKey);

        LeagueListDTO leagueListDTO = restTemplate.getForObject("https://euw1.api.riotgames.com//tft/league/v1/master?api_key="+apiKey, LeagueListDTO.class);

        System.out.println(leagueListDTO);

        System.out.println(leagueListDTO.getEntries().get(0).getSummonerName());

    }

}
