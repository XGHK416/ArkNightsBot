package com.project.xghk416.controller;


import com.project.xghk416.result.Result;
import com.project.xghk416.service.serviceImpl.ArkResumeServiceImpl;
import com.project.xghk416.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ark")
public class ArkResumeController {
    @Autowired
    ArkResumeServiceImpl arkResumeService;

    @GetMapping(value = "/getAttribute")
    public Result getResume(String index){
        return ResultUtil.success(arkResumeService.getBase(index));
    }
    @GetMapping(value = "/getRange")
    public Result getRange(String index){
        return ResultUtil.success(arkResumeService.getRange(index));
    }
    @GetMapping(value = "/getEliteMaterial")
    public Result getEliteMaterial(String index){
        return ResultUtil.success(arkResumeService.getEliteMaterial(index));
    }
    @GetMapping(value = "/getTalent")
    public Result getTalent(String index){
        return ResultUtil.success(arkResumeService.getTalent(index));
    }
    @GetMapping(value = "/getPotential")
    public Result getPotential(String index){
        return ResultUtil.success(arkResumeService.getPotential(index));
    }
    @GetMapping(value = "/getRiic")
    public Result getRiic(String index){
        return ResultUtil.success(arkResumeService.getRiic(index));
    }
    @GetMapping(value = "/getSkillElite")
    public Result getSkillElite(String index,String rank){
        return ResultUtil.success(arkResumeService.getSkill(index,rank));
    }


}
