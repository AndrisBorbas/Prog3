package hu.bme.mit.inf.symod.homework.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hu.bme.mit.inf.symod.homework.generic.tests.TesterAPI;

public class CucumberStepDefinitions {
	TesterAPI tester;

	
	public CucumberStepDefinitions() {
		reset();
	}

	private void reset() {
		tester = new TesterAPI("CucumberTest", "Tests with Cucumber.");
	}

	@Given("a fresh chess clock")
	public void setUp() throws Throwable {
		reset();
	}

	@When("I press the WHITE button")
	public void pressWhite() throws Throwable {
		tester.pushWhite();
	}

	@When("I press the BLACK button")
	public void pressBlack() throws Throwable {
		tester.pushBlack();
	}

	@When("I press the START button")
	public void pressStart() throws Throwable {
		tester.pushStart();
	}

	@When("I press the MOD button")
	public void pressMod() throws Throwable {
		tester.pushMod();
	}

	@When("I wait for (\\d+) ms")
	public void waitMilliseconds(long length) throws Throwable {
		tester.clockForward(length);
	}

	@When("I wait for (\\d+) s")
	public void waitSeconds(long length) throws Throwable {
		tester.clockForward(length * 1000);
	}

	@Then("the MAIN display should display the text '(.*)'")
	public void checkText(String text) throws Throwable {
		tester.expectText(text);
	}

	@Then("the WHITE display should display the number (\\d+)")
	public void checkWhiteNumber(long length) throws Throwable {
		tester.expectWhiteNumber(length);
	}

	@Then("the BLACK display should display the number (\\d+)")
	public void checkBlcakNumber(long length) throws Throwable {
		tester.expectBlackNumber(length);
	}

	@Then("a BEEP should be made")
	public void checkBeep() throws Throwable {
		tester.expectBeep(true);
	}

	@Then("NO BEEP should be made")
	public void checkNoBeep() throws Throwable {
		tester.expectBeep(false);
	}
}
