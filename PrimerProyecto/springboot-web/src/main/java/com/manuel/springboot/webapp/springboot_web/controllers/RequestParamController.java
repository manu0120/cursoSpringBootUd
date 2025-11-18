package com.manuel.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manuel.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.manuel.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamController {
    @GetMapping("/foo")
    // es opcional usar required = false, por defecto es true
    public ParamMixDto foo(@RequestParam(required = false, defaultValue = "No hay mensaje como parámetro") String mensaje) {
        ParamMixDto messageParam = new ParamMixDto();
        // messageParam.setMessage(mensaje != null ? mensaje : "No hay mensaje");
        messageParam.setMessage(mensaje);
        return messageParam;
    }

    @GetMapping("/bar")
    public ParamDto bar(
        @RequestParam(required = false, defaultValue = "No hay mensaje como parámetro") String text,
        @RequestParam Integer code
    ) {
        ParamDto paramsDto = new ParamDto();
        paramsDto.setMessage(text);
        paramsDto.setCode(code);
        return paramsDto;
    }

    @GetMapping("request")
    public ParamDto request(HttpServletRequest request) {
        ParamDto params = new ParamDto();
        Integer code = 0;
        // tratamiento de errores: cuando no se pasa code o es string
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (Exception e) {
        }
        params.setMessage(request.getParameter("message"));
        params.setCode(code);
        return params;
    }
    
}
