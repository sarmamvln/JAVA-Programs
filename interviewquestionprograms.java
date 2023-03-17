package sa_workspace;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.stream.Stream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class interviewquestionprograms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1. reverse of string
		
		//String url2="https://phptravels.com/demo/";
		//System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		//WebDriver driver= new FirefoxDriver();
		//driver.get(url2); 
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Actions a= new Actions(driver);
		
		 revstri();
		 //loop2demo();
		// InterviewMinnumber();
				
		
	}

	
	public static void revstri() 
	{
		String  st=  "name" ;
		String n="";
		
		 for(int i=st.length()-1;i>0;i--)
		 {
			 n.concat(""+st.charAt(i));
			   
			   
		 }
		 System.out.println(n);
			
}
	 
/*
	// Example on pyramid Triangle
	public static void loop2demo {

		// TODO Auto-generated method stub
		//int k=1;
		for(int i=1;i<5;i++)
		{
		for(int j=1;j<=i;j++)
		{
		System.out.print(j);
		System.out.print("\t");
		//k++;
		}
		System.out.println("");

		}
		}

		
	
	public static class InterviewMinnumber {
		/*2 4 5

		3 4 7

		1 2 9*/
		//Maximum number from the array

/*		
		int abc[][]={‌{2,4,5},{3,2,10},{1,2,0}};
		int min=abc[0][0];
		int mincoloumn = 0;


		for(int i=0;i<3;i++)
		{
		for(int j=0;j<3;j++)
		{
		if(abc[i][j]<min)//2
		{
		min=abc[i][j];
		mincoloumn=j;
		}
		}
		}
		
		//=1
		int max=abc[0][mincoloumn];
		int k = 0;
		while(k<3)
		{
		if(abc[k][mincoloumn]>max)
		{
		max=abc[k][mincoloumn];
		}
		k++;
		}

		System.out.println(max);
		}

		}
	
	*/
}	
