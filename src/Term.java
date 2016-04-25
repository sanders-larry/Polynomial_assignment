
// TODO: Auto-generated Javadoc
/**
 * The Class Term.
 * Larry sanders
 */
public class Term {

	/** The coeff. */
	private int coeff;
	
	/** The expo. */
	private int expo;
	
	/**
	 * Instantiates a new term.
	 *
	 * @param coeff the coeff
	 * @param expo the expo
	 */
	public Term(int coeff, int expo){
		this.coeff= coeff;
		this.expo = expo;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String out;
		if(expo == 0)
		{
			out = String.valueOf(coeff) ; 
			
		}
		else if(expo == 1)
		{
			out = (coeff+ "x");
		}
		else
		{
			out = (coeff+ "x^" + expo);
		}

		return out;		
	}
	
	/**
	 * Gets the coefficient.
	 *
	 * @return the coefficient
	 */
	public int getCoefficient(){
		return coeff;
	}
	
	/**
	 * Gets the exponent.
	 *
	 * @return the exponent
	 */
	public int getExponent(){
		return expo;
	}
}
