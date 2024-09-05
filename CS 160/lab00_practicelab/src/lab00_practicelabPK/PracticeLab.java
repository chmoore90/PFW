/*
* Chloe Moore
* CS 16000-01 – 02/03, Fall Semester 2023
* Practice Lab: introduction to labs
*/
package lab00_practicelabPK;

public class PracticeLab
{
	public static void main(String[] args) {
		//declare variables
		String firstName = "Blueberry";
		String lastName = "Strawberry";
		String middleName = "Apple-Sauce";
		
		int iEleven = 11;
		int iThree = 3;
		double dEleven = 11;
		double dThree = 3;
		
		int iNumber = 8;
		int iPrime = 5;
		
		//method call statements
		nameDisplay();
		nameDisplay(firstName, middleName, lastName);
		System.out.println("\nCheck whether the name is Blueberry Asian-Pear Strawberry?");
		nameDisplay(firstName, "Asian-Pear", lastName);
		nameDisplay(lastName);
		System.out.println();// add new print line
		
		divideDisplay();
		divideDisplay(iEleven, dEleven, iThree, dThree);
		
		squareCubeRoot(7);
		
		computeDisplay(iEleven, iThree, iNumber, iPrime);


	}//end of main

	public static void nameDisplay() {
		System.out.print("Blueberry");
		System.out.print("Strawberry");
		System.out.print("Blueberry ");
		System.out.print("Strawberry\n");
		System.out.print("Blueberry" + " ");
		System.out.print("Strawberry\n");
		System.out.print("Blueberry" + "Strawberry");
		System.out.print("Blueberry Strawberry");
		System.out.print("Blueberry" + " " + "Strawberry");
		System.out.print("Blueberry" + "Apple-Sauce" + " " + "Strawberry");
	}//end of nameDisplay
	
	/**
	 * 
	 * @param fName String class, first name
	 * @param mName String class, middle name
	 * @param lastName String class, last name
	 */
	public static void nameDisplay(String fName, String mName, String lastName) {
		//observe the outputs from the print, println, and printf methods.
		System.out.println( ); //leave a line space.
		System.out.print(fName + " ");//add a space after fName
		System.out.print(mName);
		System.out.print(" "  + lastName + "\n");
		System.out.print(fName + " " + mName + " " + lastName + "\n");
		System.out.println(fName + " " + mName + " " + lastName);//add spaces between the names
		System.out.println(lastName + ", " + fName + " " + mName);
		System.out.printf("My full name is %s %s %s.\n", fName, mName, lastName);
		System.out.printf("My name is \"%s, %s %s.\"\n", lastName, fName, mName);//added quotations by using the backslash
	}//end of nameDisplay
	
	/**
	 * 
	 * @param fName String class, first name
	 */
	public static void nameDisplay(String fName) {
		String mName="W.M.";
		System.out.println(fName + " " + mName + " " + "Appleseed" + "!");
	}//end nameDisplay
	
	public static void divideDisplay() {
		int a = 1/2;
		int b = 11/3;
		int c = 4/5;
		double d = 1/2.;
		double e = 11/3.;
		double f = 4./5;
		System.out.printf("%d\t%d\t%d\t%.1f\t%f\t%.1f", a, b, c, d, e, f);
		System.out.print("\n\tThe first three variables are integer results of division. These results are rounded to the lowest integer.\nSome of the results are zero because they are between zero and one, so they round to zero.\n\tThe last three are floating decimal results of division. These results are a decimal numbers.\nThe number of decimal places displayed can be limited by adding \".<some number>\" before the \"f\"."); 
	}//end of divideDisplay
	
	/**
	 * 
	 * @param i11 int type, 11
	 * @param d11 double type, 11
	 * @param i3 int type, 3
	 * @param d3 double type, 3
	 */
	public static void divideDisplay(int i11, double d11, int i3, double d3) {
		System.out.printf("\n\nSolution for Problem 8:"
				+ "\n" + i11/i3 + "\t" + i3/i11 + "\t" + d3/i11 + "\t" + d11/i3 + "\t" + i3/d11
				+ "\n" + i11/d3 + "\t" + d11/d3 + "\t" + i11/(double)i3 + "\t" + (double)i11/i3
				+ "\n" + (double)(i11/i3) + "\t" + (double) (i3/i11) + "\t" + (int)(d11/d3) + "\t" + (int)(d3/d11));
		System.out.printf("\n\nSolution for Problem 9:"
				+ "\n(int)iEleven/dThree = " + (int)i11/d3
				+ "\n(int)(iEleven/dThree) = " + (int)(i11/d3)
				+ "\n(int)(iEleven/dThree *1000)/1000. " + (int)(i11/d3*1000)/1000.);
	}//end of divideDisplay
	
	/**
	 * 
	 * @param num int type, 7
	 */
	public static void squareCubeRoot(int num){ 
		System.out.println("\n");
		System.out.println("sqrt(" + num + ") = " + Math.sqrt(num));
		System.out.println("cbrt(" + num + ") = " + Math.cbrt(num));
		
		System.out.printf("sqrt(%d) = %.2f", num, Math.sqrt(num));//2 decimal places
		System.out.printf("\ncbrt(%d) = %.2f", num, Math.cbrt(num));
		
		System.out.printf("\nsqrt(%d) = %.4f", num, Math.sqrt(num));//4 decimal places
		System.out.printf("\ncbrt(%d) = %.4f", num, Math.cbrt(num));
	}//end of squareCubeRoot
	
	/**
	 * 
	 * @param i11 int type, 11
	 * @param i3 int type, 3
	 * @param iNumber int type, 8
	 * @param iPrime int type, 5
	 */
	public static void computeDisplay(int i11, int i3, int iNumber, int iPrime){
		System.out.printf("\n\niEleven / 2 * 2 = %d", (i11/2*2));
		System.out.printf("\niThree * iNumber + iEleven / iPrime = %d", (i3*iNumber+i11/iPrime));
		System.out.printf("\niThree / iEleven - iNumber + iThree * iPrime = %d", (i3/i11-iNumber+i3*iPrime));
		
		System.out.printf("\n\niEleven / (2 * 2) = %d", (i11/(2*2)));
		System.out.printf("\niThree * (iNumber + iEleven) / iPrime = %d", (i3*(iNumber+i11)/iPrime));
		System.out.printf("\niThree / (iEleven – iNumber) + iThree * iPrime = %d", (i3/(i11-iNumber)+i3*iPrime));
		System.out.printf("\niThree / (iEleven – iNumber + iThree) * iPrime = %d", (i3/(i11-iNumber+i3)*iPrime));
		System.out.printf("\niThree / iEleven – (iNumber + iThree) * iPrime = %d", (i3/i11-(iNumber+i3)*iPrime));
	}//end computeDisplay
	
	
}//end of PracticeLab