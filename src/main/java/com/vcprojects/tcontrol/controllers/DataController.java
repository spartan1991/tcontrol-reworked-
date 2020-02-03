package com.vcprojects.tcontrol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vcprojects.tcontrol.model.Data;
import com.vcprojects.tcontrol.service.DataService;

@Controller
//@RequestMapping("/product")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/catalog")
    public String listDatas(Model theModel) {
        List < Data > theDatas = dataService.getDatas();
        theModel.addAttribute("datas", theDatas);
        return "catalog";
    }

    @GetMapping("/graphics")
    public String listDatasGraphics(Model theModel) {
        List<Data> theDatas = dataService.getDatas();
        theModel.addAttribute("datas", theDatas);
        return "graphics";
    }

    @GetMapping("/addData")
    public String addData(Model theModel) {
        Data theData = new Data();
        theModel.addAttribute("data", theData);
        return "data-add";
    }

    @PostMapping("/saveData")
    public String saveData(@ModelAttribute("data") Data theData) {
        dataService.saveData(theData);
        return "redirect:/";
    }

    @GetMapping("/updateData")
    public String updateData(@RequestParam("dataId") int theId, Model theModel) {
        Data theData = dataService.getData(theId);
        theModel.addAttribute("data", theData);
        //return "data-form";
        return "index";
    }

    @GetMapping("/showData")
    public String showData(@RequestParam("dataId") int theId, Model theModel) {
        Data theData = dataService.getData(theId);
        theModel.addAttribute("data", theData);
        //return "data-form";
        return "data-info";
    }

    @GetMapping("/deleteData")
    public String deleteData(@RequestParam("dataId") int theId) {
        dataService.deleteData(theId);
        //return "redirect:/user/list";
        return "index";
    }
}
