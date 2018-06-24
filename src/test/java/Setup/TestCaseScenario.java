package Setup;

public class TestCaseScenario {
	private int id;
	private String name;
	private String info;
	private String feature;
	private String testName;
	private String testData;
	
	public TestCaseScenario(int id, String name,String testName,String info, String feature,String testData) {
		super();
		this.id = id;
		this.name = name;
		this.testName=testName;
		this.info = info;
		this.feature = feature;
		this.testData=testData;

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getInfo() {
		return info;
	}

	public String getFeature() {
		return feature;
	}

	public String getTestName(){
		return testName;
	}
	public String getTestData(){
		return testData;
	}

}
