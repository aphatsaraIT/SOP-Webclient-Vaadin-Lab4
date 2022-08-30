package com.example.demo;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MathAPI {
    @RequestMapping(value = "/plus/{num1}/{num2}", method = RequestMethod.GET)
    public String myPlus(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
        return String.valueOf(num1+num2);
    }

    @RequestMapping(value = "/minus/{num1}/{num2}", method = RequestMethod.GET)
    public String myMinus(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
        return String.valueOf(num1-num2);
    }

    @RequestMapping(value = "/multiply/{num1}/{num2}", method = RequestMethod.GET)
    public String myMulti(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
        return String.valueOf(num1*num2);
    }

    @RequestMapping(value = "/divide/{num1}/{num2}", method = RequestMethod.GET)
    public String myDivide(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
        return String.valueOf(num1/num2);
    }

    @RequestMapping(value = "/mod/{num1}/{num2}", method = RequestMethod.GET)
    public String myMod(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
        return String.valueOf(num1%num2);
    }

    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public String myMax(@RequestBody MultiValueMap<String, String> n) {
        Map<String, String> d = n.toSingleValueMap();
        String out = Double.parseDouble(d.get("num1")) > Double.parseDouble(d.get("num2")) ? String.valueOf(d.get("num1")) : String.valueOf(d.get("num2"));
        return  out+"";
    }

}
