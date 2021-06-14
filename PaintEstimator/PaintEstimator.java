import java.util.Scanner;
import java.lang.Math;     // Note: Needed for math functions

//This allows the program to check to ensure the input is a positive number
public class PaintEstimator {
	public static boolean isNumeric(String inputValue) { 
	if (inputValue == null) { 
		return false; } 
		try { 
			double d = Double.parseDouble(inputValue); 
			} 
		catch (NumberFormatException nfe) { 
			return false; 
			} 
		return true; }
		
// The one and only main
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in); 
	  String inputValue = "";
      double wallHeight = 0.0;
      double wallWidth = 0.0;
      double wallArea = 0.0;
      double gallonsPaintNeeded = 0.0;
      double cansNeeded = 0;
	  boolean startover = true;
	  
      final double squareFeetPerGallons = 350.0;
      final double gallonsPerCan = 1.0;

//Opens loop
	  while (startover == true) {
	  startover = false;  //Sets the startover boolean to false to allow it to exit if the exit input is not entered
		  while (isNumeric (inputValue) == false) {
		  System.out.println ("To exit the program enter -1"); 
		  System.out.println ("Enter wall height (feet): ");  //requests input of wall height
		  inputValue = scnr.next();  /receives input value
//this section send the input value to the isNumeric check to ensure that the input value is a positive number
		  	if (isNumeric (inputValue) == false){
			System.out.println ("Value entered must be a positive number");
			}
			else {
		  wallHeight = Double.parseDouble(inputValue);
			if (wallHeight == 0){
			startover = true; // This sets startover to True if the exit input value is entered
			break;
			}		
			if (wallHeight == -1) 
				return;
				}
		  }
//This section checks to see if Startover has changed to false 
		  if (startover == false) {
		  while (isNumeric (inputValue) == false) {
		  System.out.println ("Enter wall width (feet): ");
			inputValue = scnr.next();
			if (isNumeric (inputValue) == false){
			System.out.println ("Value entered must be a positive number");
			}
			else {
		  wallWidth = Double.parseDouble(inputValue);;
		  			if (wallWidth == 0){
			startover = true;
			break;
			}				
			if (wallWidth == -1) 
				return;
		  }
		 }
		if (startover == false) {
		  // Calculate and output wall area
			wallArea = wallHeight * wallWidth;
			System.out.println("Wall area: " + wallArea +   " square feet");
		  // Calculate and output the amount of paint in gallons needed to paint the wall
			gallonsPaintNeeded = wallArea / squareFeetPerGallons;
			System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons");
		  
		  // Calculate and output the number of 1 gallon cans needed to paint the wall, rounded up to nearest integer
			cansNeeded = gallonsPaintNeeded / gallonsPerCan;  //Hint: this line is missing two operations
			System.out.println("Cans needed: " + cansNeeded + " can(s)");  
		  }
			if (startover == false)
		  return;
			}
		}
	}
}

