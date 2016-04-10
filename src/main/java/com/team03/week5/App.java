package com.team03.week5;

import java.util.Scanner;
import java.util.logging.Logger;

public class App {
	static Scanner scan = new Scanner(System.in);
	static User user = new User();
	static PlanType planType = null;
	static TotalRate totalRate = new TotalRate();

	private static final Logger LOGGER = Logger.getLogger("InfoLogging");
	private static final String PRINTERRORMESSAGE = "잘못된 입력값입니다.";
	public static String testArgs[] = null;

	public App() {
	}

	public static void main(String[] args) {
		App.testArgs = args;
		if(args.length==1){
			user.setPlanTypeName("Gold");
			user.setMinutesUsed(10000);
			user.setNumberOfLines(6);
		}
		if(args.length==2){
			user.setPlanTypeName("Silver");
			user.setMinutesUsed(10000);
			user.setNumberOfLines(6);
		}
		if(args.length==3){
			user.setPlanTypeName("abc");
			user.setMinutesUsed(-1);
			user.setNumberOfLines(-1);
		}
			while (!insertUserPlanType(user)) {
				LOGGER.info(PRINTERRORMESSAGE);
				if(args.length==3){
					user.setPlanTypeName("gold");
				}
			}

			while (!insertUserNumberOfLines(user)) {
				LOGGER.info(PRINTERRORMESSAGE);
				if(args.length==3){
					user.setNumberOfLines(6);
				}
			}
			
			while(!insertMinutesUsed(user)) {
				LOGGER.info(PRINTERRORMESSAGE);
				if(args.length==3){
					user.setMinutesUsed(1000);
				}
			}
		
		LOGGER.info("User의 요금제 : " + user.getPlanTypeName());

		LOGGER.info("User의 회선 수 : " + user.getNumberOfLines());

		LOGGER.info("User의 사용시간 : " + user.getMinutesUsed());

		totalRate.calTotalRate(user, planType);
	}

	public static boolean insertUserPlanType(User user) {
		LOGGER.info("User의 요금제(Gold/Silver)를 입력하세요.");
		if(App.testArgs.length==0){
		user.setPlanTypeName(scan.next());
		}
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

	public static boolean insertUserNumberOfLines(User user) {
		LOGGER.info("User의 회선 수를 입력하세요.");
		if(App.testArgs.length==0){
		user.setNumberOfLines(scan.nextInt());
		}
		if (user.getNumberOfLines() <= 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean insertMinutesUsed(User user) {
		LOGGER.info("User의 사용시간을 입력하세요.");
		if(App.testArgs.length==0){
		user.setMinutesUsed(scan.nextInt());
		}
		if (user.getMinutesUsed() <= 0) {
			return false;
		} else {
			return true;
		}
	}
}
