package com.fpl.fplmaster.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fpl.fplmaster.service.FPLRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FPLRestServiceController {

    FPLRestService service;

    @Autowired
    public FPLRestServiceController(FPLRestService service) {
        this.service = service;
    }

    @GetMapping("/generalinfo")
    public JsonNode getGeneralInfo() throws JsonProcessingException {
        return service.getGeneralInfo();
    }

    @GetMapping("/fixtures")
    public JsonNode getFixtures() throws JsonProcessingException {
        return service.getFixtures();
    }
}
