package com.example.demo.Comtroller;

import com.example.demo.Dto.PlanPageResponse;
import com.example.demo.Dto.PlanResponse;
import com.example.demo.Service.PlanService;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/plans")
@Slf4j
@RestController
public class PlanController {
    private static final Logger log = LoggerFactory.getLogger(PlanController.class);


    private final PlanService planService;
    public PlanController(PlanService planService){
        this.planService=planService;
    }

    @GetMapping
    public PlanPageResponse list(
            @RequestParam(required = false) Integer maxMonthlyFeeFen, 
            @RequestParam(defaultValue= "1") int page,
            @RequestParam(name="pageSize",defaultValue= "10") int pageSize){
        log.info("Controlller层执行");
        return planService.listPlans(maxMonthlyFeeFen,page,pageSize);

    }

    @GetMapping("/{id}")
    public  PlanResponse listById(@PathVariable("id") Long id){

        return planService.selectPlanByid(id);
    }



}
