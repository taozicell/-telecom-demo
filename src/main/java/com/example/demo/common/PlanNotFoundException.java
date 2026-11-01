package com.example.demo.common;


import jdk.jshell.spi.ExecutionControl;

public class PlanNotFoundException extends RuntimeException {
    public PlanNotFoundException(){
        super("套餐不存在或过期");
    }
}
