package com.project.xghk416.controller;

import com.project.xghk416.pojo.PublicOfferingEntity;
import com.project.xghk416.result.Result;
import com.project.xghk416.service.serviceImpl.PublicOfferingServiceImpl;
import com.project.xghk416.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    PublicOfferingServiceImpl publicOfferingService;

    @PostMapping("/test1")
    public Result test1(){
        System.out.println(1);
        return ResultUtil.success();
    }

    @PostMapping("/test2")
    public Result test2(){
        return ResultUtil.success(publicOfferingService.getPublicOffering(new PublicOfferingEntity()));
    }
}

