package junitlab.bank;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junitlab.bank.impl.GreatSavingsBank;

@RunWith(Parameterized.class)
public class BankTest {

	Bank bank;

	@Before
	public void setUp() {
		bank = new GreatSavingsBank();
	}

	@Test
	public void testOpenAccount() throws Exception {
		String an = bank.openAccount();
		long balance = bank.getBalance(an);
		Assert.assertEquals(0L, balance);
	}

	@Test
	public void testUniqueAccount() {
		String an1 = bank.openAccount();
		String an2 = bank.openAccount();
		Assert.assertNotEquals(an1, an2);
	}

	@Test(expected = AccountNotExistsException.class)
	public void testInvalidAccount() throws Exception {
		String an = bank.openAccount();
		bank.getBalance(new String("asd"));
	}

	@Test
	public void testDeposit() throws Exception {
		String an = bank.openAccount();
		bank.deposit(an, 2000L);
		long balance = bank.getBalance(an);
		Assert.assertEquals(2000L, balance);
	}

	@Parameters
	public static List<Object[]> parameters() {
		List<Object[]> params = new ArrayList<Object[]>();
		params.add(new Object[] {});
		return params;
	}

}
