package com.angular.spring.tfg.teamfighttacticssearch.controller;

import com.angular.spring.tfg.teamfighttacticssearch.beans.LeagueItemDTO;
import com.angular.spring.tfg.teamfighttacticssearch.beans.LeagueListDTO;
import com.angular.spring.tfg.teamfighttacticssearch.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ranking")
@CrossOrigin
public class rankingController {

    @Autowired
    private RankingService rankingService;

    @PostMapping("/leaderboard")
    public ResponseEntity<List<LeagueItemDTO>> getChallengerList(@RequestParam(value = "platform") String platform){

        LeagueListDTO leagueListDTOChallenger = rankingService.getLeaderboard(platform, "challenger");

        List<LeagueItemDTO> leagueItemDTO = leagueListDTOChallenger.getEntries();

        leagueItemDTO = orderLeagueItemDTO(leagueItemDTO);

        return new ResponseEntity(leagueItemDTO, HttpStatus.OK);
    }

    private List<LeagueItemDTO> orderLeagueItemDTO(List<LeagueItemDTO> leagueItemDTO) {
        leagueItemDTO = leagueItemDTO.stream().sorted((o1, o2) -> {
            if(o1.getLeaguePoints() < o2.getLeaguePoints() /*? -1 : 1*/){
                return 1;
            }else if(o1.getLeaguePoints() > o2.getLeaguePoints()){
                return -1;
            }else{
                return o1.getSummonerName().compareTo(o2.getSummonerName());
            }
        }).collect(Collectors.toList());
        leagueItemDTO.removeIf(leagueItemDTO1 -> (leagueItemDTO1.getLeaguePoints()<400));
        return leagueItemDTO;
    }
}
