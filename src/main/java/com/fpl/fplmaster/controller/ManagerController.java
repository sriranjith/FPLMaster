package com.fpl.fplmaster.controller;

import com.fpl.fplmaster.common.ControllerConstants;
import com.fpl.fplmaster.service.FPLRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/{managerId}")
public class ManagerController {
    FPLRestService service;

    @Autowired
    public ManagerController(FPLRestService service) {
        this.service = service;
    }

    @GetMapping("/history")
    public String getManagerHistory(@PathVariable(name = "managerId") long managerId, Model model) {
        //model.addAttribute(ModelAttributes.MANGER_INFO.name(), service.getManagerInfo(managerId));
        //model.addAttribute(ModelAttributes.MANGER_HISTORY.name(), service.getManagerHistory(managerId));
        return ControllerConstants.MANAGER.name();
    }
}
