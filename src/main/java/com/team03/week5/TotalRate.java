package com.team03.week5;

import java.util.logging.Logger;

public class TotalRate {
	private static final Logger LOGGER = Logger.getLogger("InfoLogging");
	private static final String PREROUNDBRACKET = " + ( ";
	private static final String POSTROUNDBRACKET = " )";
	private double totalCost = 0;
	private double lineCost = 0;
	private double usedCost = 0;
	String resultofLines="";
	String resultofUsed="";
	// 기본요금+회선에 대한 추가요금(요금제에 따라서 기본요금과 추가되는 요금이 다르다)
	public double calNumberOfLine(User user, PlanType planType) {
		resultofLines = "";
		int numberOfLines = user.getNumberOfLines();
		lineCost = planType.getBasicMonthlyRate();
		if (numberOfLines > 1 && numberOfLines <= 3) {
			lineCost += ((numberOfLines - 1) * planType.getAdditionalLineRate());
			resultofLines+=(planType.getBasicMonthlyRate()+PREROUNDBRACKET+(numberOfLines-1)+" * "+planType.getAdditionalLineRate()+POSTROUNDBRACKET);
		} else if (numberOfLines >= 4) {
			lineCost += (((numberOfLines - 3) * planType.getFamilyDistcount())+planType.getAdditionalLineRate()*2);
			resultofLines+=(planType.getBasicMonthlyRate()+PREROUNDBRACKET+2+" * "+planType.getAdditionalLineRate()+POSTROUNDBRACKET+
					PREROUNDBRACKET+(numberOfLines-3)+" * "+planType.getFamilyDistcount()+POSTROUNDBRACKET);
		} else{
			resultofLines+=Double.toString(planType.getBasicMonthlyRate());
		}
		
		return lineCost;
	}

	// 초과 금액에 대한 추가요금 계산
	public double calMinuteUsed(User user, PlanType planType) {
		resultofUsed = "";
		int minutesUsed = user.getMinutesUsed();
		double ratePerExcessMinute = planType.getRatePerExcessMinute();
		int includedMinutes = planType.getIncludedMinutes();
		
		if (minutesUsed > includedMinutes) {
			usedCost = (minutesUsed - includedMinutes) * ratePerExcessMinute;
			resultofUsed+=(PREROUNDBRACKET+(minutesUsed - includedMinutes)+" * "+ratePerExcessMinute+POSTROUNDBRACKET+" = ");
		} else {
			resultofUsed+=" = ";
			usedCost = 0;
		}
			
		return usedCost;
	}

	public double calTotalRate(User user, PlanType planType) {
		totalCost = calNumberOfLine(user, planType) + calMinuteUsed(user, planType);
		totalCost = Double.parseDouble(String.format("%.2f", totalCost));
		LOGGER.info(resultofLines+resultofUsed+totalCost+"$");
		return totalCost;
	}

	public double getTotalRate() {
		return this.totalCost;
	}
}