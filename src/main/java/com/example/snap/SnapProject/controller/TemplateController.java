package com.example.snap.SnapProject.controller;
import com.example.snap.SnapProject.model.Driver;
import com.example.snap.SnapProject.services.DriverService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TemplateController {
    private DriverService driverService;
    @RequestMapping("/")
    public String home(){

        return "index";
    }
    @RequestMapping("/addDriver")
    public String addDriver(Model model){
        Driver driver=new Driver();
              model.addAttribute("driver",driver);
        return "adddriver";
    }
    @RequestMapping("/addDriver/register")
    public String driverRegister(@ModelAttribute("driver")Driver driver){
        driverService=new DriverService();
        driverService.addDriver(driver);
        driverService=null;
        return "index";
    }
    @RequestMapping("/viewDrivers")
    public String viewDriver(Model model){

        List<Driver> drivers=new ArrayList<>();
        driverService=new DriverService();
        drivers=driverService.drivers();
        driverService=null;
        model.addAttribute("drivers",drivers);
        model.addAttribute("empty",false);
        return "drivers";
    }
    @RequestMapping("/checkoutDrivers")
    public String checkoutDriver(@ModelAttribute("id")ObjectId objectId){
        driverService=new DriverService();
        driverService.checkout(objectId);
        driverService=null;
        return "index";
    }

    @RequestMapping("/endJob")
    public String endJob(Model model){

        driverService=new DriverService();
        List<Driver> drivers=new ArrayList<>();
        drivers=driverService.busyDrivers();
        driverService=null;

        model.addAttribute("drivers",drivers);
        model.addAttribute("empty",false);
        return "endjob";
    }
    @RequestMapping("/endJob/release")
    public String endJobRelease(@ModelAttribute("id")ObjectId objectId){

        driverService=new DriverService();

        driverService.endJob(objectId);
        driverService=null;

        return "index";
    }

    @RequestMapping("/newJob")
    public String newJob(Model model){

        driverService=new DriverService();
        List<Driver> drivers=new ArrayList<>();
        drivers=driverService.freeDrivers();
        driverService=null;

        model.addAttribute("drivers",drivers);
        model.addAttribute("empty",false);
        return "newjob";
    }
    @RequestMapping("/newJob/register")
    public String newJobRegister(@ModelAttribute("id")ObjectId objectId){

        driverService=new DriverService();

        driverService.startJob(objectId);
        driverService=null;

        return "index";
    }
}
