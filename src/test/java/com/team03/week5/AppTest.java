package com.team03.week5;
import static org.junit.Assert.*;
import org.junit.*;

public class AppTest 
{
	User user;
	PlanType planType;
	TotalRate totalRate;
   
	@Test
    public void setUp()
    {
        user = new User();
        totalRate = new TotalRate();
    }
	@Test
	public void testAppInputSmallGold()
	{
		setUp();
		user.setPlanTypeName("gold");
		assertEquals("gold", user.getPlanTypeName());
	}
   @Test
   public void testAppInputBigGold()
   {
	   setUp();
       user.setPlanTypeName("Gold");
       assertEquals("Gold", user.getPlanTypeName());
   }
   @Test
	public void testAppInputSmallSilver()
	{
		setUp();
		user.setPlanTypeName("silver");
		assertEquals("silver", user.getPlanTypeName());
	}
   @Test
   public void testAppInputBigSilver()
   {
	   setUp();
	   user.setPlanTypeName("Silver");
	   assertEquals("Silver", user.getPlanTypeName());
   }
   @Test
   public void testAppInputIncorrectlyPlanName()
   {
	   setUp();
	   user.setPlanTypeName("gollld");
       //assertTrue();
   }
   @Test
   public void testAppInputLine()
   {
	   setUp();
       user.setNumberOfLines(1);
       assertEquals(1, user.getNumberOfLines());
   }
   @Test
   public void testAppInputZeroLine()
   {
	   setUp();
       user.setNumberOfLines(0);
       //assertTrue(true);
   }
   @Test
   public void testAppInputUsedTime()
   {
	   setUp();
       user.setMinutesUsed(500);
       assertEquals(500, user.getMinutesUsed());
   }
   @Test
   public void testAppInputZeroUsedTime()
   {
	   setUp();
       user.setMinutesUsed(0);
       //assertTrue(true);
   }
   
   @Test
   public void testUserGoldBill()
   {
	   setUp();
       user.setPlanTypeName("Gold");
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
       user.setPlanTypeName("Gold");
       user.setNumberOfLines(2);
       user.setMinutesUsed(500);
       planType = new Gold();
       totalRate.calTotalRate(user, planType);
       assertEquals(64.45, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserGoldAddLines()
   {
	   setUp();
       user.setPlanTypeName("Gold");
       user.setNumberOfLines(4);
       user.setMinutesUsed(500);
       planType = new Gold();
       totalRate.calTotalRate(user, planType);
       assertEquals(83.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserGoldOverTime()
   {
	   setUp();
       user.setPlanTypeName("Gold");
       user.setNumberOfLines(1);
       user.setMinutesUsed(1300);
       planType = new Gold();
       totalRate.calTotalRate(user, planType);
       assertEquals(184.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserSilverBill()
   {
	   setUp();
       user.setPlanTypeName("Silver");
       user.setNumberOfLines(1);
       user.setMinutesUsed(250);
       planType = new Silver();
       totalRate.calTotalRate(user, planType);
       assertEquals(29.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserSilverAddLine()
   {
	   setUp();
       user.setPlanTypeName("Silver");
       user.setNumberOfLines(2);
       user.setMinutesUsed(250);
       planType = new Silver();
       totalRate.calTotalRate(user, planType);
       assertEquals(51.45, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserSilverAddLines()
   {
	   setUp();
       user.setPlanTypeName("Silver");
       user.setNumberOfLines(4);
       user.setMinutesUsed(250);
       planType = new Silver();
       totalRate.calTotalRate(user, planType);
       assertEquals(77.95, totalRate.getTotalRate(),0.01);
   }
   @Test
   public void testUserSilverOverTime()
   {
	   setUp();
       user.setPlanTypeName("Silver");
       user.setNumberOfLines(1);
       user.setMinutesUsed(1000);
       planType = new Silver();
       totalRate.calTotalRate(user, planType);
       assertEquals(299.95, totalRate.getTotalRate(),0.01);
   }
}
