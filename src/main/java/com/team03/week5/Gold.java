package com.team03.week5;

public class Gold extends PlanType{
	static final double GOLD_BASIC_MONTHLY_RATE = 49.95;
	static final double GOLD_ADDITIONAL_RATE = 14.50;
	static final double GOLD_FAMILY_DISTCOUNT = 5.0;
	static final int GOLD_INCLUDEDMINUTES = 1000;
	static final double GOLD_RATE_PER_EXCESSMINUTE = 0.45;
	
	public Gold(){
		this.setBasicMonthlyRate(GOLD_BASIC_MONTHLY_RATE);
		this.setAdditionalLineRate(GOLD_ADDITIONAL_RATE);
		this.setFamilyDistcount(GOLD_FAMILY_DISTCOUNT);
		this.setIncludedMinutes(GOLD_INCLUDEDMINUTES);
		this.setRatePerExcessMinute(GOLD_RATE_PER_EXCESSMINUTE);
	}
}
