package junitlab.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import junitlab.bank.impl.GreatSavingsBank;

public class BankTestFixture {

	Bank savingsBank;
	String an1, an2;

	@Before
	public void setUp() throws Exception {
		savingsBank = new GreatSavingsBank();
		an1 = savingsBank.openAccount();
		an2 = savingsBank.openAccount();
		savingsBank.deposit(an1, 1500L);
		savingsBank.deposit(an2, 12000L);
	}

	@Test
	public void testTransfer() throws Exception {
		savingsBank.transfer(an2, an1, 3456L);
		long balance = savingsBank.getBalance(an1);
		Assert.assertEquals(4956L, balance);
		balance = savingsBank.getBalance(an2);
		Assert.assertEquals(8544L, balance);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTransferNegative() throws Exception {
		savingsBank.transfer(an2, an1, -3456L);
	}

	@Test
	public void testClose() throws Exception {
		savingsBank.transfer(an1, an2, 1500L);
		boolean test = savingsBank.closeAccount(an1);
		Assert.assertEquals(true, test);
	}

	@Test
	public void testNoClose() throws Exception {
		boolean test = savingsBank.closeAccount(an2);
		Assert.assertEquals(false, test);
	}

	@Test(expected = NotEnoughFundsException.class)
	public void testTransferWithoutEnoughFunds() throws Exception {
		savingsBank.transfer(an1, an2, 3456L);
	}

}
