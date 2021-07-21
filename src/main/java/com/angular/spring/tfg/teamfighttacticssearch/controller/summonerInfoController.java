package com.angular.spring.tfg.teamfighttacticssearch.controller;

import com.angular.spring.tfg.teamfighttacticssearch.beans.MatchDTO;
import com.angular.spring.tfg.teamfighttacticssearch.service.UserNameSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/summoner")
@CrossOrigin
public class summonerInfoController{

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private UserNameSearchService userNameSearchService;

    @PostMapping("/matches")
    public ResponseEntity<List<MatchDTO>> getSummonerNameInfo(@RequestParam(value = "platform") String platform, @RequestParam(value = "summonerName") String summonerName){
        List<MatchDTO> listMatchesInfo = userNameSearchService.getSummonerInfo(platform, summonerName);

        return new ResponseEntity(listMatchesInfo, HttpStatus.OK);
    }

}
