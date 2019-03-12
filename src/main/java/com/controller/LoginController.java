package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.ConstantUtils;
import com.model.Weather;

/**
 * city change Controller
 * @author cs
 *
 */
@Controller
public class LoginController {
	@Value("${city.citylist}")
    private String cityList;
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String hello(Model model){
    	String[] cities = cityList.split(",");
    	List<String> cList = new ArrayList<>();
    	for (String city : cities) {
    		System.out.println(city);
    		cList.add(city);
    	}
    	model.addAttribute(ConstantUtils.CITY_LIST, cList);
    	// get default first city to display the weather
    	String cityName = cList.get(0);
     	Map<String , String> map = new HashMap<String, String>();
    	map.put(ConstantUtils.CITY_NAME, cityName);
    	model.addAttribute(ConstantUtils.WEATHER, map);
        return ConstantUtils.PATH_WEATHER;
    }
    
    @RequestMapping(value="/changeCity", method=RequestMethod.GET)
    @ResponseBody
    public Weather changeCity(String  cityName){
    	Weather weather = new Weather();
    	weather.setCityName(cityName);
    	return weather;    	
    } 
    
}
