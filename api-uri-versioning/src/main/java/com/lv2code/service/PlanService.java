package com.lv2code.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lv2code.dto.PlanDTO;
import com.lv2code.repository.PlanRepository;

@Service
public class PlanService {
	
	@Autowired
	private PlanRepository planRepository;
	
	public PlanDTO fetchPlanById(int planId) {
		return planRepository.fetchPlanById(planId);
	}
	
	public Map<String, Integer> fetchPlanByIdv2(int planId) {
		return planRepository.fetchPlanByIdv2(planId);
	}
}
