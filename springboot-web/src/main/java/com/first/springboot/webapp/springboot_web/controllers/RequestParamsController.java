package com.first.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.first.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.first.springboot.webapp.springboot_web.models.dto.ParamsDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "HELLO TEST") String message){

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamsDto bar(@RequestParam String text, @RequestParam Integer code) {
        
        ParamsDto params = new ParamsDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }
    
    @GetMapping("/request")
    public ParamsDto request(HttpServletRequest request) {
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
            // TODO: handle exception
        }
        ParamsDto params = new ParamsDto();
        params.setMessage(request.getParameter("message"));
        params.setCode(code);

        return params;
    }
    
}
