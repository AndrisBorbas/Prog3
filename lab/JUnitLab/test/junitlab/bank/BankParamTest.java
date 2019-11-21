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
public class BankParamTest {

	long rounded, amount;
	String an;
	Bank bank;

	public BankParamTest(long a, long b) {
		this.rounded = a;
		this.amount = b;
	}

	@Before
	public void setUp() throws Exception {
		bank = new GreatSavingsBank();
		an = bank.openAccount();
		bank.deposit(an, 10000L);
	}

	@Test
	public void testWithdrawRounding() throws Exception {
		long balance = bank.getBalance(an);
		bank.withdraw(an, amount);
		balance -= bank.getBalance(an);
		Assert.assertEquals(rounded, balance);
	}

	@Parameters
	public static List<Object[]> parameters() {
		List<Object[]> params = new ArrayList<Object[]>();
		params.add(new Object[] { 1100, 1100 });
		params.add(new Object[] { 1100, 1101 });
		params.add(new Object[] { 1100, 1149 });
		params.add(new Object[] { 1200, 1150 });
		params.add(new Object[] { 1200, 1151 });
		params.add(new Object[] { 1200, 1199 });
		params.add(new Object[] { 1200, 1200 });
		return params;
	}

}
