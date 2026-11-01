package com.example.demo.Mapper;

import com.example.demo.Dto.PlanResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface PlanMapper{

     PlanResponse selectPlanByid(@Param("id") Long id);

     long countOnSalePlans(@Param("maxMonthlyFeeFen") Integer maxMonthlyFeeFen);

//     List<PlanResponse> selectOnSalePlans(@Param("maxMonthlyFeeFen") Integer maxMonthlyFeeFen,
//                                   @Param("start") long start,
//                                   @Param("pagesize") int pagesize
//
//     );

     List<PlanResponse> selectOnSalePlans(@Param("maxMonthlyFeeFen") Integer maxmonthlyFeeFen);

}

