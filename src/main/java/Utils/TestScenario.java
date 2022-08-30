package Utils;

public enum TestScenario {
	
	T1("Navigate to shop"),
	T2("User Add item"),
	T3("User checkout");
	
	private String testName;
	
	TestScenario(String value) {
		testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}