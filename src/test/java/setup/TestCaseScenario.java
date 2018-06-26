package setup;

public class TestCaseScenario {
	private int id;
	private String name;
	private String info;
	private String testName;
	private String testData;
	//Constructor for TestCaseScenario where test case parameters are initialized
	public TestCaseScenario(int id, String name,String testName,String info, String feature,String testData) {
		super();
		this.id = id;
		this.name = name;
		this.testName=testName;
		this.info = info;
		this.testData=testData;

	}
   //Getter methods
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getInfo() {
		return info;
	}



	public String getTestName(){
		return testName;
	}
	public String getTestData(){
		return testData;
	}

}
