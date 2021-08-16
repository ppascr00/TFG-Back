package com.angular.spring.tfg.teamfighttacticssearch.controller;

import com.angular.spring.tfg.teamfighttacticssearch.beans.LeagueItemDTO;
import com.angular.spring.tfg.teamfighttacticssearch.beans.LeagueListDTO;
import com.angular.spring.tfg.teamfighttacticssearch.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ranking")
@CrossOrigin
public class rankingController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RankingService rankingService;

    //leaderboard?platform=euw1
    @PostMapping("/leaderboard")
    public ResponseEntity<List<LeagueItemDTO>> getChallengerList(@RequestParam(value = "platform") String platform){

        LeagueListDTO leagueListDTOChallenger = rankingService.getLeaderboard(platform, "challenger");
        LeagueListDTO leagueListDTOGrandmaster = rankingService.getLeaderboard("euw1", "grandmaster");
        LeagueListDTO leagueListDTOMaster = rankingService.getLeaderboard("euw1", "master");

        //LeagueListDTO leagueListDTOLeaderboard = leagueListDTOChallenger + leagueListDTOGrandmaster + leagueListDTOMaster;

        List<LeagueItemDTO> leagueItemDTO = leagueListDTOChallenger.getEntries();
        leagueItemDTO.addAll(leagueListDTOGrandmaster.getEntries());
        leagueItemDTO.addAll(leagueListDTOMaster.getEntries());

        leagueItemDTO = orderLeagueItemDTO(leagueItemDTO);

        return new ResponseEntity(leagueItemDTO, HttpStatus.OK);
    }

    //prueba ejecución automática 2
    private List<LeagueItemDTO> orderLeagueItemDTO(List<LeagueItemDTO> leagueItemDTO) {
        leagueItemDTO = leagueItemDTO.stream().sorted(new Comparator<LeagueItemDTO>() {
            @Override
            public int compare(LeagueItemDTO o1, LeagueItemDTO o2) {
                if(o1.getLeaguePoints() < o2.getLeaguePoints() /*? -1 : 1*/){
                    return 1;
                }else if(o1.getLeaguePoints() > o2.getLeaguePoints()){
                    return -1;
                }else{
                    return o1.getSummonerName().compareTo(o2.getSummonerName());
                }
            }

        }).collect(Collectors.toList());
        return leagueItemDTO;
    }
}
