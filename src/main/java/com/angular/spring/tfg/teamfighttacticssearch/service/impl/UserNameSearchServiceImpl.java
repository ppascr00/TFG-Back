package com.angular.spring.tfg.teamfighttacticssearch.service.impl;

import com.angular.spring.tfg.teamfighttacticssearch.beans.MatchDTO;
import com.angular.spring.tfg.teamfighttacticssearch.beans.SummonerDTO;
import com.angular.spring.tfg.teamfighttacticssearch.service.UserNameSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserNameSearchServiceImpl implements UserNameSearchService {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<MatchDTO> getSummonerInfo(String platform, String summonerName) {
        SummonerDTO summonerDTO = restTemplate.getForObject("https://"+ platform +".api.riotgames.com/tft/summoner/v1/summoners/by-name/"+ summonerName +"?api_key="+ apiKey, SummonerDTO.class);
        String puuid = summonerDTO.getPuuid();
        String region = "";
        region = getRegion(platform, region);

        List<String> listMatches = restTemplate.getForObject("https://"+ region +".api.riotgames.com/tft/match/v1/matches/by-puuid/"+ puuid +"/ids?count=20&api_key=" + apiKey, List.class);
        List<MatchDTO> listMatchesInfo = new ArrayList();
        getListMatchesInfo(region, listMatches, listMatchesInfo);

        return listMatchesInfo;
    }

    private void getListMatchesInfo(String region, List<String> listMatches, List<MatchDTO> listMatchesInfo) {
        for(int i = 0; i< listMatches.size(); i++){
            MatchDTO matchDTO = restTemplate.getForObject("https://"+ region +".api.riotgames.com/tft/match/v1/matches/"+ listMatches.get(i) +"?api_key=" + apiKey, MatchDTO.class);
            listMatchesInfo.add(matchDTO);
        }
    }

    private String getRegion(String platform, String region) {
        if(platform.contentEquals("euw1") || platform.contentEquals("eun1") || platform.contentEquals("tr1") || platform.contentEquals("ru")){
            region = "europe";
        }else if(platform.contentEquals("jp1") || platform.contentEquals("kr")){
            region = "asia";
        }else if(platform.contentEquals("na1") || platform.contentEquals("br") ||
                platform.contentEquals("la1") || platform.contentEquals("la2") ||
                        platform.contentEquals("oc1")){
            region = "americas";
        }
        return region;
    }
}
