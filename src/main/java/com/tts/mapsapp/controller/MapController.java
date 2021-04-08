package com.tts.mapsapp.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.mapsapp.deserialization.Location;
import com.tts.mapsapp.service.MapService;

@Controller
public class MapController
{
    @Autowired
    MapService mapService;
    
    Random random = new Random();
    
    @GetMapping("/")
    public String getDefaultMap(Model model)
    {
        model.addAttribute(new Location());
        return "index.html";
    }
    
    @PostMapping("/")
    public String getMapForLocation(Location location, Model model)
    {
        mapService.addCoordinates(location);
        model.addAttribute(location);
        return "index.html";
    }
    
    @PostMapping("/random")
    public String getRandomLocation(Model model)
    {
        Location location = new Location();
        double lat = (random.nextDouble() * 180.0)-90.0;
        double lng = (random.nextDouble()* 360.0)-180.0;
        location.setLat(String.valueOf(lat));
        location.setLng(String.valueOf(lng));
        mapService.addPlace(location);
        model.addAttribute(location);
        return "index.html";
    }
}
