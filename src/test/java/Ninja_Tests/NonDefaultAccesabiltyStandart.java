package Ninja_Tests;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import NinjaPages.NinjaWebConsts;
import freemarker.template.TemplateException;
import io.github.sridharbandi.HtmlCsRunner;
import io.github.sridharbandi.a11y.HTMLCS;
import java.io.FileWriter;   // Import the FileWriter class
import java.util.Iterator;





/**
 * A sample test to demonstrate
 */
public class NonDefaultAccesabiltyStandart {

    private WebDriver driver;
    private static HtmlCsRunner htmlCsRunner;
    JsonReader jsonReader;
    String directoryPath = "target\\java-a11y\\htmlcs\\json"; // Replace with the path of the directory you want to delete files from

    @Before
   
    public void beforeTest() {
    
    	System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
    	driver = new ChromeDriver();
        jsonReader = new JsonReader();

        driver.manage().window().fullscreen();
        htmlCsRunner = new HtmlCsRunner(driver);
        htmlCsRunner.setStandard(HTMLCS.WCAG2A);
       //this is to delete former jsons fron former executions. for some reason could not execte same for the htmls 
        
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if(files != null) {
            for(File file : files) {
            	//System.out.println(file.getName());
                if(file.isFile()) {
                    file.delete();
                }
            }
        }   
    }
    
    @Test
    public void googleTest() throws URISyntaxException, TemplateException, ParseException {
        driver.get(NinjaWebConsts.baseUrl);
        
		try {
	        htmlCsRunner.execute();
	        driver.quit();
	        htmlCsRunner.generateHtmlReport();
	        
	        File directory = new File(directoryPath);
	        File file = directory.listFiles()[0];
	        
	        var jsonResluts = jsonReader.read(file.getPath());
	        
	        StringBuilder sb = new StringBuilder();
	        sb.append("Accsesbility test results\n\n");
	        sb.append("Test Date : ");
	        sb.append(jsonResluts.get("date").toString());
	        sb.append("\nMachine details: \n");
	        sb.append("\tBrowser: ");
	        sb.append(jsonResluts.get("browser").toString() + "\n");
	        sb.append("\tDevice: ");
	        sb.append(jsonResluts.get("device").toString() + "\n");
	        sb.append("\tDimensions: ");
	        sb.append(jsonResluts.get("dimension").toString() + "\n");
	        sb.append("\nNumber of found errors: ");
	        sb.append(jsonResluts.get("errors").toString() + "\n\n");
	        int errorsCounterToPrint = 1;
	        
	        JSONParser parser = new JSONParser();
	            // Parse the JSON file
	            Object obj = parser.parse(new FileReader(file.getPath()));
	            JSONObject jsonObject = (JSONObject) obj;

	            // Get the results array
	            JSONArray resultsArray = (JSONArray) jsonObject.get("results");

	            // Iterate over the results array and print the msg field of every result with type = 1
	            for (Object resultObj : resultsArray) {
	              JSONObject result = (JSONObject) resultObj;
	              Long type = (Long) result.get("type");

	              if (type != null && type == 1) {
	                String msg = (String) result.get("msg");
	                sb.append("Error #"+errorsCounterToPrint+": ");
	                sb.append(msg + "\n");
	                errorsCounterToPrint++;
	              }
	            }   

	        String resultsPath = directoryPath + "\\results.txt";

			FileWriter results = new FileWriter (resultsPath);
			results.write(sb.toString());
			results.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
        

    }

  
}









	
	



