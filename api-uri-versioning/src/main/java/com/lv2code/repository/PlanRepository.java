package com.lv2code.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.lv2code.dto.PlanDTO;

@Repository
public class PlanRepository {
	
	private List<PlanDTO> plans;
	
	@PostConstruct
	public void populatePlans() {
		plans = new ArrayList<>();
		PlanDTO plan1 = new PlanDTO();
		plan1.setPlanId(1);
		plan1.setPlanName("Simple");
		plan1.setLocalRate(3);
		plan1.setNationalRate(5);
		
		PlanDTO plan2 = new PlanDTO();
		plan2.setPlanId(2);
		plan2.setPlanName("Medium");
		plan2.setLocalRate(5);
		plan2.setNationalRate(8);
		
		plans.add(plan1);
		plans.add(plan2);
	}
	
	public PlanDTO fetchPlanById(int planId) {
		Optional<PlanDTO> optional = plans.stream().filter(e -> e.getPlanId() == planId).findFirst();
		return optional.orElse(plans.get(0));
	}
	
	public Map<String, Integer> fetchPlanByIdv2(int planId) {
		Map<String, Integer> rates = new HashMap<>();
		Optional<PlanDTO> optional = plans.stream().filter(e -> e.getPlanId() == planId).findFirst();
		rates.put("localRate", optional.orElse(plans.get(0)).getLocalRate());
		rates.put("nationalRate", optional.orElse(plans.get(0)).getNationalRate());
		return rates;
	}
}
