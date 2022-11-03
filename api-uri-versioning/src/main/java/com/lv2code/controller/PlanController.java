package com.lv2code.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lv2code.dto.PlanDTO;
import com.lv2code.service.PlanService;

@RestController
@RequestMapping("/plans")
public class PlanController {
	
	@Autowired
	private PlanService planService;
	
	@GetMapping(value = "/{planId}", params = "version=1")
	public PlanDTO fetchPlanById(@PathVariable("planId") int planId) {
		return planService.fetchPlanById(planId);
	}
	
	@GetMapping(value = "/{planId}", params = "version=2")
	public Map<String, Integer> fetchPlanByIdv2(@PathVariable("planId") int planId) {
		return planService.fetchPlanByIdv2(planId);
	}
}
