package com.team03.week5;

public class Silver extends PlanType{
	static final double SILVER_BASIC_MONTHLY_RATE = 29.95;
	static final double SILVER_BASIC_ADDITIONAL_LINE_RATE = 21.50;
	static final double SILVER_FAMILY_DISTCOUNT = 5.0;
	static final int SILVER_INCLUDE_MINUTES = 500;
	static final double SILVER_RATE_PER_EXCESS_MINUTE = 0.54;
	
	public Silver(){
		this.setBasicMonthlyRate(SILVER_BASIC_MONTHLY_RATE);
		this.setAdditionalLineRate(SILVER_BASIC_ADDITIONAL_LINE_RATE);
		this.setFamilyDistcount(SILVER_FAMILY_DISTCOUNT);
		this.setIncludedMinutes(SILVER_INCLUDE_MINUTES);
		this.setRatePerExcessMinute(SILVER_RATE_PER_EXCESS_MINUTE);
	}
}