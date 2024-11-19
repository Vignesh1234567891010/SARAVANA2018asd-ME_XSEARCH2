package _ME_XSEARCH2_IMPLEMENATAION;

import java.net.MalformedURLException;

public class App {
	
	public void getGreetings() throws MalformedURLException,InterruptedException{
		
		TestCases tests=new TestCases();
		
		tests.testCase01();
		
		tests.testCase02();
		
		tests.testCase03();
		
		tests.testCase04();
		
		tests.testCase05();
		
		tests.endTest();
	}

	public static void main(String[] args) throws InterruptedException,MalformedURLException {
		// TODO Auto-generated method stub
		new App().getGreetings();
	}

}
