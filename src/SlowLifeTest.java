//created by Joseph Bender

//imports
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;


public class SlowLifeTest {
	
	//Initialize MainPanel object
	private MainPanel _mainPanel;

	//unused before and after methods
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	//These three tests investigate the CPU heavy convertToInt() method in MainPanel
	//It seems that any argument passed into this method is returned unmodified
	//So these three tests ensure that after my refactoring of the code, the functionality is the same
	//It passes a variable in, and tests the return to make sure they are identical
	//I used three different values that would test multiple edge cases
	@Test
	public void testConvertToInt() {
		
		//declare initial variable
		int x = 30;
		
		//pass variable into convertToInt() method in MainPanel, and store return in new integer
		int y = MainPanel.convertToInt(x);
		
		//if the passed and returned arguments are the same, pass the test
		assertEquals(x,y);
		
		//this also means the method tested is arbitrary and doesn't actually change the argument
		
	}//end testConvertToInt() method
	
	@Test
	public void testConvertToInt2() {
		
		//declare initial variable
		int x = 0;
		
		//pass variable into convertToInt() method in MainPanel, and store return in new integer
		int y = MainPanel.convertToInt(x);
		
		//if the passed and returned arguments are the same, pass the test
		assertEquals(x,y);
		
		//this also means the method tested is arbitrary and doesn't actually change the argument
		
	}//end testConvertToInt2() method
	
	@Test
	public void testConvertToInt3() {
		
		//declare initial variable
		int x = -3;
		
		//pass variable into convertToInt() method in MainPanel, and store return in new integer
		int y = MainPanel.convertToInt(x);
		
		//if the passed and returned arguments are the same, pass the test
		assertEquals(x,y);
		
		//this also means the method tested is arbitrary and doesn't actually change the argument
		
	}//end testConvertToInt3() method
	
	
	
	
	//These three tests investigate the CPU heavy toString() method in Cell
	//To access Cell.toString(), it goes through MainPanel.toString()
	//Cell.toString had an unnecessary for loop that iterated 10000 times
	//I refactored the method and removed this for loop
	//These three tests ensure functionality has not changed, and the file saved is accurate
	@Test
	public void testToString() {
		
		//create a new array of size 1
		String[] argument = new String[1];
		
		//assign the first index of the array a string to control size of MainPanel
		argument[0] = "15";
		
		//declare integer to hold value of argument
		int xx;
		
		//assign xx with the string from argument, convert to int
		xx = Integer.parseInt(argument[0]);
		
		//do a virtual construction of the game
		GameOfLife.main(argument);
		
		//build the MainPanel of cells, with size from argument
		MainPanel _m = new MainPanel(xx);
		
		//create a new file that has fake data used in test
		String fileName = "test.txt";
		
		//load fake data from file and store in arraylist
	    ArrayList<String> info = FileAccess.loadFile(fileName);
	    
	    //using the fake data, populate the game
	    _m.load(info);
	    
	    //store the current state of the game to a new string
	    //this uses the refactored toString method in MainPanel
	    //if test passes, than this line operated correctly
	    String newToWrite = _m.toString();
	    
	    //store the current state of the game in a brand new file
	    FileAccess.saveFile("testCompare.txt", newToWrite);
	    
	    //load the data that was immediately stored in temporary file
	    ArrayList<String> infoCompare = FileAccess.loadFile(fileName);
	    
	    //if the original test data, and newly written test data are the same,
	    //that means that the refactored toString method still performs the same functionality
	    assertEquals(info, infoCompare);
	    
	}//end testToString() method

	@Test
	public void testToString2() {
		
		//create a new array of size 1
		String[] argument = new String[1];
		
		//assign the first index of the array a string to control size of MainPanel
		argument[0] = "15";
		
		//declare integer to hold value of argument
		int xx;
		
		//assign xx with the string from argument, convert to int
		xx = Integer.parseInt(argument[0]);
		
		//do a virtual construction of the game
		GameOfLife.main(argument);
		
		//build the MainPanel of cells, with size from argument
		MainPanel _m = new MainPanel(xx);
		
		//create a new file that has fake data used in test
		String fileName = "test2.txt";
		
		//load fake data from file and store in arraylist
	    ArrayList<String> info = FileAccess.loadFile(fileName);
	    
	    //using the fake data, populate the game
	    _m.load(info);
	    
	    //store the current state of the game to a new string
	    //this uses the refactored toString method in MainPanel
	    //if test passes, than this line operated correctly
	    String newToWrite = _m.toString();
	    
	    //store the current state of the game in a brand new file
	    FileAccess.saveFile("testCompare2.txt", newToWrite);
	    
	    //load the data that was immediately stored in temporary file
	    ArrayList<String> infoCompare = FileAccess.loadFile(fileName);
	    
	    //if the original test data, and newly written test data are the same,
	    //that means that the refactored toString method still performs the same functionality
	    assertEquals(info, infoCompare);
    
	}//end testToString2() method
		
	@Test
	public void testToString3() {
		
		//create a new array of size 1
		String[] argument = new String[1];
		
		//assign the first index of the array a string to control size of MainPanel
		argument[0] = "15";
		
		//declare integer to hold value of argument
		int xx;
		
		//assign xx with the string from argument, convert to int
		xx = Integer.parseInt(argument[0]);
		
		//do a virtual construction of the game
		GameOfLife.main(argument);
		
		//build the MainPanel of cells, with size from argument
		MainPanel _m = new MainPanel(xx);
		
		//create a new file that has fake data used in test
		String fileName = "test3.txt";
		
		//load fake data from file and store in arraylist
	    ArrayList<String> info = FileAccess.loadFile(fileName);
	    
	    //using the fake data, populate the game
	    _m.load(info);
	    
	    //store the current state of the game to a new string
	    //this uses the refactored toString method in MainPanel
	    //if test passes, than this line operated correctly
	    String newToWrite = _m.toString();
	    
	    //store the current state of the game in a brand new file
	    FileAccess.saveFile("testCompare3.txt", newToWrite);
	    
	    //load the data that was immediately stored in temporary file
	    ArrayList<String> infoCompare = FileAccess.loadFile(fileName);
	    
	    //if the original test data, and newly written test data are the same,
	    //that means that the refactored toString method still performs the same functionality
	    assertEquals(info, infoCompare);
	    
	}//end testToString3() method
	
	
	
	//These three tests investigate the CPU heavy MainPanel.runContinuous() method
	//This method had an unnecessary Thread.sleep(20) call that was slowing down calculations significantly
	//It also had a for loop that iterated 10000 times for no applicable reason
	//I removed all of the useless code
	//These three tests ensure that the runContinuous() method still produces the same functionality
	@Test
	public void testRunContinuous(){
		//create a new array of size 1
		String[] argument = new String[1];
		
		//assign the first index of the array a string to control size of MainPanel
		argument[0] = "15";
		
		//declare integer to hold value of argument
		int xx;
		
		//assign xx with the string from argument, convert to int
		xx = Integer.parseInt(argument[0]);
		
		//do a virtual construction of the game
		GameOfLife.main(argument);
		
		//build the MainPanel of cells, with size from argument
		MainPanel _n = new MainPanel(xx);

		//create a new file that has fake data used in test
		String fileName = "preresult.txt";
		
		//load fake data from file and store in arraylist
	    ArrayList<String> info = FileAccess.loadFile(fileName);
	    
	    //load fake data into grid
	    _n.load(info);
	    
	    //simulate a run of the MainPanel.runContinuous() method
	    //calculate the next iteration 100 times
	    for(int k = 0; k < 100; k++){
	    	_n.calculateNextIteration();
	    }
		
	    //stop the program
		_n.stop();
		
		//save the current state of the grid to a string
		String currentState = _n.toString();
		
		//save the current state to a file
		FileAccess.saveFile("runContinuousTest.txt", currentState);
		
		//reload the file that was just saved to an arraylist
		ArrayList<String> checkContinuousRun = FileAccess.loadFile("runContinuousTest.txt");
		
		//the continuous run that was just executed was loaded from a file
		//that will always produce the same dead end
		//compare that the results of the actual continuous run are equal to a file holding the 
		//expected deadend outcome
		ArrayList<String> checkContinuousRun2 = FileAccess.loadFile("postresult.txt");
		
		//compare the results of the two files, and pass the test if they are identical
		assertEquals(checkContinuousRun, checkContinuousRun2);

	}//end testRunContinuous() method
	
	@Test
	public void testRunContinuous2(){
		//create a new array of size 1
		String[] argument = new String[1];
		
		//assign the first index of the array a string to control size of MainPanel
		argument[0] = "15";
		
		//declare integer to hold value of argument
		int xx;
		
		//assign xx with the string from argument, convert to int
		xx = Integer.parseInt(argument[0]);
		
		//do a virtual construction of the game
		GameOfLife.main(argument);
		
		//build the MainPanel of cells, with size from argument
		MainPanel _n = new MainPanel(xx);

		//create a new file that has fake data used in test
		String fileName = "preresult2.txt";
		
		//load fake data from file and store in arraylist
	    ArrayList<String> info = FileAccess.loadFile(fileName);
	    
	    //load fake data into grid
	    _n.load(info);
	    
	    //simulate a run of the MainPanel.runContinuous() method
	    //calculate the next iteration 100 times
	    for(int k = 0; k < 100; k++){
	    	_n.calculateNextIteration();
	    }
		
	    //stop the program
		_n.stop();
		
		//save the current state of the grid to a string
		String currentState = _n.toString();
		
		//save the current state to a file
		FileAccess.saveFile("runContinuousTest2.txt", currentState);
		
		//reload the file that was just saved to an arraylist
		ArrayList<String> checkContinuousRun = FileAccess.loadFile("runContinuousTest2.txt");
		
		//the continuous run that was just executed was loaded from a file
		//that will always produce the same dead end
		//compare that the results of the actual continuous run are equal to a file holding the 
		//expected deadend outcome
		ArrayList<String> checkContinuousRun2 = FileAccess.loadFile("postresult2.txt");
		
		//compare the results of the two files, and pass the test if they are identical
		assertEquals(checkContinuousRun, checkContinuousRun2);

	}//end testRunContinuous2() method
	
	@Test
	public void testRunContinuous3(){
		//create a new array of size 1
		String[] argument = new String[1];
		
		//assign the first index of the array a string to control size of MainPanel
		argument[0] = "15";
		
		//declare integer to hold value of argument
		int xx;
		
		//assign xx with the string from argument, convert to int
		xx = Integer.parseInt(argument[0]);
		
		//do a virtual construction of the game
		GameOfLife.main(argument);
		
		//build the MainPanel of cells, with size from argument
		MainPanel _n = new MainPanel(xx);

		//create a new file that has fake data used in test
		String fileName = "preresult3.txt";
		
		//load fake data from file and store in arraylist
	    ArrayList<String> info = FileAccess.loadFile(fileName);
	    
	    //load fake data into grid
	    _n.load(info);
	    
	    //simulate a run of the MainPanel.runContinuous() method
	    //calculate the next iteration 100 times
	    for(int k = 0; k < 100; k++){
	    	_n.calculateNextIteration();
	    }
		
	    //stop the program
		_n.stop();
		
		//save the current state of the grid to a string
		String currentState = _n.toString();
		
		//save the current state to a file
		FileAccess.saveFile("runContinuousTest3.txt", currentState);
		
		//reload the file that was just saved to an arraylist
		ArrayList<String> checkContinuousRun = FileAccess.loadFile("runContinuousTest3.txt");
		
		//the continuous run that was just executed was loaded from a file
		//that will always produce the same dead end
		//compare that the results of the actual continuous run are equal to a file holding the 
		//expected dead-end outcome
		ArrayList<String> checkContinuousRun2 = FileAccess.loadFile("postresult3.txt");
		
		//compare the results of the two files, and pass the test if they are identical
		assertEquals(checkContinuousRun, checkContinuousRun2);

	}//end testRunContinuous3() method

}//end SlowLifeTest class
