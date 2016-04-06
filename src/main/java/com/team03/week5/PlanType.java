package com.team03.week5;

public class PlanType {
	private double additionalLineRate;
	private double ratePerExcessMinute;
	private int includedMinutes;
	private double basicMonthlyRate;
	private double familyDistcount;
	
	public double getAdditionalLineRate() {
		return additionalLineRate;
	}
	public double getRatePerExcessMinute() {
		return ratePerExcessMinute;
	}
	public int getIncludedMinutes() {
		return includedMinutes;
	}
	public double getBasicMonthlyRate() {
		return basicMonthlyRate;
	}
	public double getFamilyDistcount() {
		return familyDistcount;
	}
	public void setAdditionalLineRate(double additionalLineRate) {
		this.additionalLineRate = additionalLineRate;
	}
	public void setRatePerExcessMinute(double ratePerExcessMinute) {
		this.ratePerExcessMinute = ratePerExcessMinute;
	}
	public void setIncludedMinutes(int includedMinutes) {
		this.includedMinutes = includedMinutes;
	}
	public void setBasicMonthlyRate(double basicMonthlyRate) {
		this.basicMonthlyRate = basicMonthlyRate;
	}
	public void setFamilyDistcount(double familyDistcount) {
		this.familyDistcount = familyDistcount;
	}
	
}


