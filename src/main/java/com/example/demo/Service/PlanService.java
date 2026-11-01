package com.example.demo.Service;


import com.example.demo.Dto.PlanPageResponse;
import com.example.demo.Dto.PlanResponse;
import com.example.demo.Mapper.PlanMapper;
import com.example.demo.common.PlanNotFoundException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlanService {

    private final PlanMapper planMapper;

    public PlanService(PlanMapper planMapper) {
        this.planMapper = planMapper;
    }

    public PlanResponse selectPlanByid(Long id) {
        if (id == null || id <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "套餐ID必须大于0"
            );
        }
        PlanResponse planResponses = planMapper.selectPlanByid(id);
        if (planResponses == null) {
            throw new PlanNotFoundException();
        }

        return planResponses;
    }

    public PlanPageResponse listPlans(Integer maxMonthlyFeeFen, int page, int pageSize) {

        if (page < 1) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "页码不能小于1"
            );
        }

        if (pageSize < 1 || pageSize > 100) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "每页必须在1~100之内"
            );

        }

        if (maxMonthlyFeeFen != null && maxMonthlyFeeFen < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "月费上限不能低于0");
        }
//        long start = (long)(page -1)*pagesize;
        try {
            PageHelper.startPage(page, pageSize);

//        long total= planMapper.countOnSalePlans(maxMonthlyFeeFen);

//        List<PlanResponse> items= planMapper.selectOnSalePlans(maxMonthlyFeeFen,start,pagesize);
            List<PlanResponse> items = planMapper.selectOnSalePlans(maxMonthlyFeeFen);
            PageInfo<PlanResponse> pageInfo = new PageInfo<>(items);

            return new PlanPageResponse(items, page, pageSize, pageInfo.getTotal());
        } finally {
            PageHelper.clearPage();
        }
    }


}
