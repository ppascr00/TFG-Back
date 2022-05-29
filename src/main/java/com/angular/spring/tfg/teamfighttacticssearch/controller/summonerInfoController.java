package com.angular.spring.tfg.teamfighttacticssearch.controller;

import com.angular.spring.tfg.teamfighttacticssearch.beans.MatchDTO;
import com.angular.spring.tfg.teamfighttacticssearch.beans.UsernameInfoMatch;
import com.angular.spring.tfg.teamfighttacticssearch.service.UserNameSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/summoner")
@CrossOrigin
public class summonerInfoController{

    @Autowired
    private UserNameSearchService userNameSearchService;

    @PostMapping("/matches")
    public ResponseEntity<List<UsernameInfoMatch>> getSummonerNameInfo(@RequestParam(value = "platform") String platform, @RequestParam(value = "summonerName") String summonerName){
        List<UsernameInfoMatch> usernameInfoMatches = userNameSearchService.getSummonerInfo(platform, summonerName);

        return new ResponseEntity(usernameInfoMatches, HttpStatus.OK);
    }

}
