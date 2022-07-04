package com.angular.spring.tfg.teamfighttacticssearch.service.impl;

import com.angular.spring.tfg.teamfighttacticssearch.beans.MatchDTO;
import com.angular.spring.tfg.teamfighttacticssearch.beans.SummonerDTO;
import com.angular.spring.tfg.teamfighttacticssearch.beans.UsernameInfoMatch;
import com.angular.spring.tfg.teamfighttacticssearch.service.UserNameSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserNameSearchServiceImpl implements UserNameSearchService {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<UsernameInfoMatch> getSummonerInfo(String platform, String summonerName) {
        SummonerDTO summonerDTO = restTemplate.getForObject("https://"+ platform +".api.riotgames.com/tft/summoner/v1/summoners/by-name/"
                + summonerName +"?api_key="+ apiKey, SummonerDTO.class);
        String puuid = summonerDTO.getPuuid();
        String region = getRegion(platform);

        List<String> listMatches = restTemplate.getForObject("https://"+ region +".api.riotgames.com/tft/match/v1/matches/by-puuid/"
                + puuid +"/ids?count=20&api_key=" + apiKey, List.class);
        List<MatchDTO> listMatchesInfo = new ArrayList();
        getListMatchesInfo(region, listMatches, listMatchesInfo);

        List<UsernameInfoMatch> usernameInfoMatches = new ArrayList<>();

        getUsernameInfo(puuid, listMatchesInfo, usernameInfoMatches);

        return usernameInfoMatches;
    }

    private void getListMatchesInfo(String region, List<String> listMatches, List<MatchDTO> listMatchesInfo) {
        for(int i = 0; i< listMatches.size(); i++){
            MatchDTO matchDTO = restTemplate.getForObject("https://"+ region +".api.riotgames.com/tft/match/v1/matches/"
                    + listMatches.get(i) +"?api_key=" + apiKey, MatchDTO.class);
            listMatchesInfo.add(matchDTO);
        }
    }

    private String getRegion(String platform) {
        String region = "";
        if(platform.contentEquals("EUW1") || platform.contentEquals("EUN1") || platform.contentEquals("TR1") || platform.contentEquals("RU")){
            region = "europe";
        }else if(platform.contentEquals("JP1") || platform.contentEquals("KR")){
            region = "asia";
        }else if(platform.contentEquals("NA1") || platform.contentEquals("BR") ||
                platform.contentEquals("LA1") || platform.contentEquals("LA2") ||
                        platform.contentEquals("OC1")){
            region = "americas";
        }
        return region;
    }

    private void getUsernameInfo(String puuid, List<MatchDTO> listMatchesInfo, List<UsernameInfoMatch> usernameInfoMatches) {
        listMatchesInfo.forEach(s -> {
            UsernameInfoMatch usernameInfoMatch = new UsernameInfoMatch();
            usernameInfoMatch.setPosition(s.getInfo().getParticipants().stream().filter(participantDTO ->
                    participantDTO.getPuuid().equals(puuid)).findFirst().get().getPlacement());

            float seconds = s.getInfo().getGame_length();
            usernameInfoMatch.setGameLength(calculateTime((long) seconds));

            Date dateGame = new Date(s.getInfo().getGame_datetime());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateGameString = dateFormat.format(dateGame);
            usernameInfoMatch.setGameDatetime(dateGameString);

            usernameInfoMatches.add(usernameInfoMatch);
        });
    }

    private String calculateTime(long seconds) {
        return String.format("%d min, %d sec",
                TimeUnit.SECONDS.toMinutes(seconds),
                TimeUnit.SECONDS.toSeconds(seconds) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(seconds))
        );
    }
}
