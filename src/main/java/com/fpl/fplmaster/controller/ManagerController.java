package com.fpl.fplmaster.controller;

import com.fpl.fplmaster.service.FPLRestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ManagerController {
    FPLRestService service;

    public ManagerController(FPLRestService service) {
        this.service = service;
    }

    @GetMapping("/team/{managerId}/history")
    public String getTeamHistory(@PathVariable(name = "managerId") long id, Model model) {
        model.addAttribute("managerHistory", service.getManagerHistory(id));
        return "manager";
    }
}
