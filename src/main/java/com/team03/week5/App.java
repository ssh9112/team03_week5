package com.team03.week5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
	// test
	static User user = new User();
	static PlanType planType = null;
	static TotalRate totalRate = new TotalRate();
	static boolean flag = true;

	private static final Logger LOGGER = Logger.getLogger("InfoLogging");
	private static final String PRINTERRORMESSAGE = "잘못된 입력값입니다.";

	private App() {
		LOGGER.info("Constructor");
	}

	public static void main(String[] args) {
		App app = new App();
		LOGGER.info(app.toString());
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
			LOGGER.log(Level.INFO,"ERROR : Wrong input arguments",e);
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
		if ("GOLD".equalsIgnoreCase(user.getPlanTypeName())) {
			planType = new Gold();
			return true;
		} else if ("SILVER".equalsIgnoreCase(user.getPlanTypeName())) {
			planType = new Silver();
			return true;
		} else {
			return false;
		}
	}

	public static boolean insertUserNumberOfLines(User user, String args) {
		LOGGER.info("User의 회선 수를 입력하세요.");
		user.setNumberOfLines(Integer.parseInt(args));
		return !(user.getNumberOfLines() <= 0);
	}

	public static boolean insertMinutesUsed(User user, String args) {
		LOGGER.info("User의 사용시간을 입력하세요.");
        user.setMinutesUsed(Integer.parseInt(args));
        return !(user.getMinutesUsed() <= 0);
	}
}
