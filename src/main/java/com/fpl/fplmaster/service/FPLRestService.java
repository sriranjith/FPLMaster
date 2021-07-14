package com.fpl.fplmaster.service;

import com.fpl.fplmaster.model.LeagueStanding;
import com.fpl.fplmaster.model.ManagerHistory;
import com.fpl.fplmaster.model.ManagerInfo;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FPLRestService {

    private final RestTemplate restTemplate;

    public FPLRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ManagerHistory getManagerHistory(long managerId) {
        String url = "https://fantasy.premierleague.com/api/entry/{managerId}/history/";
        return this.restTemplate.getForObject(url, ManagerHistory.class, managerId);
    }

    public ManagerInfo getManagerInfo(long managerId) {
        String url = "https://fantasy.premierleague.com/api/entry/{managerId}/";
        return this.restTemplate.getForObject(url, ManagerInfo.class, managerId);
    }

    public LeagueStanding getLeagueStanding(long leagueId) {
        String url = "https://fantasy.premierleague.com/api/leagues-classic/{leagueId}/standings";
        return this.restTemplate.getForObject(url, LeagueStanding.class, leagueId);
    }
}