package com.team03.week5;

import java.util.logging.Logger;

public class App {
	// test
	static User user = new User();
	static PlanType planType = null;
	static TotalRate totalRate = new TotalRate();
	static boolean flag = true;

	private static final Logger LOGGER = Logger.getLogger("InfoLogging");
	private static final String PRINTERRORMESSAGE = "잘못된 입력값입니다.";

	public App() {
		LOGGER.info("Constructor");
	}

	public static void main(String[] args) {
		flag = true;
		try {
			if (!insertUserPlanType(user, args[0])) {
				LOGGER.info(PRINTERRORMESSAGE);
				flag = false;
			}

			if (!insertUserNumberOfLines(user, args[1])) {
				LOGGER.info(PRINTERRORMESSAGE);
				flag = false;
			}

			if (!insertMinutesUsed(user, args[2])) {
				LOGGER.info(PRINTERRORMESSAGE);
				flag = false;
			}
			
		} catch (Exception e) {
			flag = false;
			LOGGER.info("ERROR : Wrong input arguments");
		}


		if (flag) {
			LOGGER.info("User의 요금제 : " + user.getPlanTypeName());
			LOGGER.info("User의 회선 수 : " + user.getNumberOfLines());
			LOGGER.info("User의 사용시간 : " + user.getMinutesUsed());
			
			totalRate.calTotalRate(user, planType);
		}else {
			return;
		}
		
	}

	public static boolean insertUserPlanType(User user, String args) {
		LOGGER.info("User의 요금제(Gold/Silver)를 입력하세요.");
		user.setPlanTypeName(args);
		if ("Gold".equals(user.getPlanTypeName()) || "gold".equals(user.getPlanTypeName())) {
			planType = new Gold();
			return true;
		} else if ("Silver".equals(user.getPlanTypeName()) || "silver".equals(user.getPlanTypeName())) {
			planType = new Silver();
			return true;
		} else {
			return false;
		}
	}

	public static boolean insertUserNumberOfLines(User user, String args) {
		LOGGER.info("User의 회선 수를 입력하세요.");
		user.setNumberOfLines(Integer.parseInt(args));
		if (user.getNumberOfLines() <= 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean insertMinutesUsed(User user, String args) {
		LOGGER.info("User의 사용시간을 입력하세요.");
        user.setMinutesUsed(Integer.parseInt(args));
		if (user.getMinutesUsed() <= 0) {
			return false;
		} else {
			return true;
		}
	}
}
