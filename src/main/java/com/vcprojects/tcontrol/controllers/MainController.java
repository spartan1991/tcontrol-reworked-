package com.vcprojects.tcontrol.controllers;

import com.vcprojects.tcontrol.model.Data;
import com.vcprojects.tcontrol.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private DataService dataService;

    @GetMapping("/")
    public String listDatas(Model theModel) {
        List<Data> theDatas = dataService.getDatas();
        theModel.addAttribute("datas", theDatas);
        return "index";
    }
}
