import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


// TODO: Auto-generated Javadoc
/**
 * A class that stores a list of Terms for the terms class and can be manipulated
 * and printed out in the for of a polynomial.
 * @author Larry Sanders
 */
public class Polynomial {
	
	
	/** The polynomial. */
	private ArrayList<Term> polynomial;
	
	/** The func name. */
	private String funcName;

    /**
	 * Creates empty Arraylist that will hold Term items.
	 */
	public Polynomial(){
		polynomial = new ArrayList<Term>();
	}
	
	
	/**
	 * Reads from the file
	 */
	public void Read(){
		String text = "/src/infile.txt";
		String dir = System.getProperty("user.dir");
		
		File file = new File(dir+text);
		
		try {
			Scanner in = new Scanner(file);
			
			String input = "";
		    String[] i ;
		    
			
			input = in.nextLine();
			i = input.split(";");
			funcName = i[0];
			
			//reads first line and  creates the equation
			for(int j = 1; j < i.length; j+=2 ){
				Insert(Integer.parseInt(i[j]), Integer.parseInt(i[j+1])); 
				Product();
			}
			
			Reverse();
			Product();
			while(in.hasNextLine()){
				input = in.nextLine();
				
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	  /**
  	 * Inserts the term into polynomial array list.
  	 *
  	 * @param x the coefficient of the new term
  	 * @param y the exponent of the new term
  	 */
	public void Insert(int x, int y){
		System.out.println("Insert function!");
		
		Term temp = new Term(x,y);
		
		polynomial.add(temp);

		for(int i = 0; i < polynomial.size(); i++){
			if(y > polynomial.get(i).getExponent()){
				Collections.swap(polynomial, polynomial.size()-1, i);
			    break;
			}
		}	
	}
	
	 /**
 	 * Deletes the term with that matches the coefficient and exponent.
 	 *
 	 * @param x the coefficient of the term to be deleted
 	 * @param y the exponent of the term to be deleted
 	 */
	
	public void Delete(int x, int y){
		System.out.println("Delete function has been called");
		;
		ArrayList<Term> temp = new ArrayList<Term>();
		for(Term t : polynomial){
			if(t.getCoefficient() == x && t.getExponent() == y)
			{
				temp.add(t);
			}
		}
		polynomial.removeAll(temp);		
	}
	
	
	/**
	    * Reverses the order of the terms of a Polynomial.
	    
	    */
	public void Reverse(){
		System.out.println("Reverse function has been called");
		Collections.reverse(polynomial);
	}
	
	
	/**
	 * Returns a polynomial as a String.
	 *
	 * @return the polynomial
	 */
	
	public void Product(){
		System.out.println("Product function called");
		System.out.print(funcName+ " = ");
		for(int i = 0; i < polynomial.size(); i++){
			if((i+1) == polynomial.size() || i==0)
			{
				System.out.print(polynomial.get(i).toString());
			}
			else if(polynomial.get(i).getCoefficient() > 0){
				
			
				System.out.print("+" + polynomial.get(i).toString());
			}
			else
				System.out.print(polynomial.get(i).toString());
		}
		
		System.out.println();
	
	}
}
