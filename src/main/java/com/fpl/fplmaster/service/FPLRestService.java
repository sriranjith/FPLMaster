package com.fpl.fplmaster.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FPLRestService {

    private final RestTemplate restTemplate;
    private static final String DOMAIN = "https://fantasy.premierleague.com/api";

    public FPLRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public JsonNode getGeneralInfo() throws JsonProcessingException {
        return get(DOMAIN + "/bootstrap-static/");
    }

    public JsonNode getFixtures() throws JsonProcessingException {
        return get(DOMAIN + "/fixtures/");
    }

    public JsonNode getPlayerDetails(String playerId) throws JsonProcessingException {
        return get(DOMAIN + "/element-summary/{playerId}/", playerId);
    }

    public JsonNode getLivePlayerStats(String gameWeek) throws JsonProcessingException {
        return get(DOMAIN + "/event/{gameWeek}/live/", gameWeek);
    }

    public JsonNode getManagerInfo(String managerId) throws JsonProcessingException {
        return get(DOMAIN + "/entry/{managerId}/", managerId);
    }

    public JsonNode getManagerTransfers(String managerId) throws JsonProcessingException {
        return get(DOMAIN + "entry/{managerId}/transfers/", managerId);
    }

    public JsonNode getManagerGameWeekSummary(String managerId, String gameWeek) throws JsonProcessingException {
        return get(DOMAIN + "/entry/{managerId}/event/{gameWeek}/picks/", managerId, gameWeek);
    }

    public JsonNode getLeagueInfo(String leagueId) throws JsonProcessingException {
        return get(DOMAIN + "/leagues-classic/{leagueId}/standings/", leagueId);
    }

    private JsonNode get(String url, String... params) throws JsonProcessingException {
        ResponseEntity<String> response
                = restTemplate.getForEntity(url, String.class, params);
        return new ObjectMapper().readTree(response.getBody());
    }
}