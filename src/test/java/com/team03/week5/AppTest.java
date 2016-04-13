package com.team03.week5;
import static org.junit.Assert.*;


import org.junit.*;

public class AppTest 
{
   User user;
   PlanType planType;
   TotalRate totalRate;
	private static final String GOLD = "GOLD";
	private static final String SILVER = "SILVER";
   
   @Before
    public void setUp()
    {
        user = new User();
        planType = new PlanType();
        totalRate = new TotalRate();
    }
   
   @Test
   public void testAppInputSmallGold()
   {
       
      user.setPlanTypeName(GOLD);
      assertEquals(GOLD, user.getPlanTypeName());
   }
   @Test
   public void testAppInputBigGold()
   {
       
       user.setPlanTypeName(GOLD);
       assertEquals(GOLD, user.getPlanTypeName());
   }
   @Test
   public void testAppInputSmallSilver()
   {
       
      user.setPlanTypeName(SILVER);
      assertEquals(SILVER, user.getPlanTypeName());
   }
   @Test
   public void testAppInputBigSilver()
   {
       
      user.setPlanTypeName(SILVER);
      assertEquals(SILVER, user.getPlanTypeName());
   }
   @Test
   public void testAppInputIncorrectlyPlanName()
   {
       
      user.setPlanTypeName("gollld");
   }
   @Test
   public void testAppInputLine()
   {
       
       user.setNumberOfLines(1);
       assertEquals(1, user.getNumberOfLines());
   }
   @Test
   public void testAppInputZeroLine()
   {
       
       user.setNumberOfLines(0);
   }
   @Test
   public void testAppInputUsedTime()
   {
       
       user.setMinutesUsed(500);
       assertEquals(500, user.getMinutesUsed());
   }
   @Test
   public void testAppInputZeroUsedTime()
   {
       
       user.setMinutesUsed(0);
   }
   
   @Test
   public void testUserGoldBill()
   {
       
       user.setPlanTypeName(GOLD);
       user.setNumberOfLines(1);
       user.setMinutesUsed(500);
       planType = new Gold();
       totalRate.calTotalRate(user, planType);
       assertEquals(49.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserGoldAddLine()
   {
      setUp();
       user.setPlanTypeName(GOLD);
       user.setNumberOfLines(2);
       user.setMinutesUsed(500);
       planType = new Gold();
       totalRate.calTotalRate(user, planType);
       assertEquals(64.45, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserGoldAddLines()
   {
       
       user.setPlanTypeName(GOLD);
       user.setNumberOfLines(4);
       user.setMinutesUsed(500);
       planType = new Gold();
       totalRate.calTotalRate(user, planType);
       assertEquals(83.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserGoldOverTime()
   {
       
       user.setPlanTypeName(GOLD);
       user.setNumberOfLines(1);
       user.setMinutesUsed(1300);
       planType = new Gold();
       totalRate.calTotalRate(user, planType);
       assertEquals(184.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserSilverBill()
   {
       
       user.setPlanTypeName(SILVER);
       user.setNumberOfLines(1);
       user.setMinutesUsed(250);
       planType = new Silver();
       totalRate.calTotalRate(user, planType);
       assertEquals(29.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserSilverAddLine()
   {
       
       user.setPlanTypeName(SILVER);
       user.setNumberOfLines(2);
       user.setMinutesUsed(250);
       planType = new Silver();
       totalRate.calTotalRate(user, planType);
       assertEquals(51.45, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserSilverAddLines()
   {
       user.setPlanTypeName(SILVER);
       user.setNumberOfLines(4);
       user.setMinutesUsed(250);
       planType = new Silver();
       totalRate.calTotalRate(user, planType);
       assertEquals(77.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserSilverOverTime()
   {
       
       user.setPlanTypeName(SILVER);
       user.setNumberOfLines(1);
       user.setMinutesUsed(1000);
       planType = new Silver();
       totalRate.calTotalRate(user, planType);
       assertEquals(299.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testSilverApp(){
	   
	   App.main(new String[]{SILVER, "1","1020"});
	   assertEquals(true, App.flag);
   }
   @Test
   public void testGoldApp(){
	   App.main(new String[]{GOLD, "5", "1020"});
	   assertEquals(true,App.flag);
   }
   @Test
   public void testFailApp(){
	   App.main(new String[]{"other","-1","-1"});
	   assertEquals(false, App.flag);
   }
   
   @Test 
   public void testNoArgs() {
	   App.main(null);
	   assertEquals(false, App.flag);
   }
}