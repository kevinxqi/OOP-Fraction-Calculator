public class Fraction 
{
	//Private Fields--------------------------
	private long numerator;
	private long denominator;
	
	//Constructors ---------------------------
	public Fraction(long num, long denom) 
	{
		numerator = num;
		denominator = denom;
		if (denominator == 0) 
		{
			throw new IllegalArgumentException("denominator must not be 0");
		}
		else if(this.denominator < 0) 
		{
			denominator = Math.abs(denominator);
			numerator *= -1;
		}
	}
	
	public Fraction(long input)
	{
		this(input, 1);
	}
	
	public Fraction() 
	{
		this(0, 1);
	}
	
	//Methods----------------------------------
	public long getNumerator() 
	{
		return numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	public String toString() 
	{
		if(denominator == 1) 
		{
			return "" + numerator;
		}
		else 
		{
			return numerator + "/" + denominator;
		}

	}

	public double toDouble() {
		return (double) numerator/denominator;
	}

	public Fraction add(Fraction other) 
	{
		long storeDenom = this.denominator;
		long num1 = this.numerator;
		long denom1 = this.denominator;
		long num2 = other.numerator;
		long denom2 = other.denominator;
		num1 *= denom2;
		denom1 *= denom2;
		num2 *= storeDenom;
		denom2 *= storeDenom;
		return new Fraction(num1 + num2, denom1);
		
	}
	
	public Fraction subtract(Fraction other) 
	{
		long storeDenom = this.denominator;
		long num1 = this.numerator;
		long denom1 = this.denominator;
		long num2 = other.numerator;
		long denom2 = other.denominator;
		num1 *= denom2;
		denom1 *= denom2;
		num2 *= storeDenom;
		denom2 *= storeDenom;
		return new Fraction(num1 - num2, denom1);
	}
	
	public Fraction multiply(Fraction other) 
	{
		long num1 = this.numerator;
		long denom1 = this.denominator;
		long num2 = other.numerator;
		long denom2 = other.denominator;
		
		long newDenom = denom2 * denom1;
		long newNumer = num2 * num1;
		return new Fraction(newNumer, newDenom);	
	}

	public Fraction divide(Fraction other) 
	{
		long num1 = this.numerator;
		long denom1 = this.denominator;
		long num2 = other.numerator;
		long denom2 = other.denominator;
		if (other.numerator == 0) 
		{
			 new IllegalArgumentException("cannot divide by 0");
		}
		long storeDenom = other.denominator;
		denom2 = num2;
		//multiply by reciprocal
		num2 = storeDenom;
		long newDenom = denom2 * denom1;
		long newNumer = num2 * num1;
		return new Fraction(newNumer, newDenom);	
		
	}

	public boolean equals(Fraction other) 
	{
		if (other instanceof Fraction) 
		{
			return (((float) other.numerator / other.denominator) == ((float)this.numerator / this.denominator));
		}
		else
		{
			return false;
		}
	}

	public void toLowestTerms() 
	{
		long gcd = gcd(numerator, denominator);
		this.numerator /= gcd;
		this.denominator /= gcd;
	}

	public static long gcd(long num, long denom) 
	{
		while (num != 0  && denom != 0)
		{
			long remainder = num % denom;
			num = denom;
			denom = remainder;
		}
		return num;
	}
}

