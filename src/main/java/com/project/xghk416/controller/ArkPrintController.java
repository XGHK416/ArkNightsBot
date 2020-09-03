package com.project.xghk416.controller;


import com.project.xghk416.result.Result;
import com.project.xghk416.service.serviceImpl.ArkPrintServiceImpl;
import com.project.xghk416.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/print")
public class ArkPrintController {
    @Autowired
    ArkPrintServiceImpl arkPrintService;
    @RequestMapping("/getAllOp")
    public Result getAllOp(){
        return ResultUtil.success(arkPrintService.getAllOp());
    }
    @RequestMapping("/getBase")
    public Result getBase(String index){
        return ResultUtil.success(arkPrintService.getBase(index));
    }
}
