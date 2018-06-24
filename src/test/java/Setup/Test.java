package Setup;

import junit.framework.TestCase;

public class Test {
    TestCaseScenario testCaseScenario;
    TestCaseExecutor testCaseExecutor;
    public static void main(String args[]){

        TestCaseExecutor testCaseExecutor=new TestCaseExecutor();
        TestCaseScenario testCaseScenario= testCaseExecutor.getTestScenario("signUp");
        System.out.println("Info is"+testCaseScenario.getInfo());

    }
}
