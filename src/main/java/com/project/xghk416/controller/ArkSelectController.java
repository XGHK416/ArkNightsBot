package com.project.xghk416.controller;

import com.project.xghk416.result.Result;
import com.project.xghk416.service.serviceImpl.ArkSelectServiceImpl;
import com.project.xghk416.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/select")
public class ArkSelectController {
    @Autowired
    ArkSelectServiceImpl selectService;

    @GetMapping(value = "/getAll")
    public Result getAll(){
        return ResultUtil.success(selectService.getAll());
    }
}
