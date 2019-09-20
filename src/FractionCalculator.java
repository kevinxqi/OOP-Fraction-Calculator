import java.util.Scanner;

public class FractionCalculator 
{
	static long num;
	static long denom;
	
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) 
	{
		System.out.println("This program is a fraction calculator");
		System.out.println("It will add, subtract, multiply, and divide fractions until you type Q to quit.");
		System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
		System.out.println("-----------------------------------------------");
		System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
		String operator = getOperation(input);
		while (!(operator.equals("q") || operator.equals("Q"))) 
		{
			System.out.print("Please enter a fraction (a/b) or (a): ");
			Fraction fractionOne = getFraction(input);
			System.out.print("Please enter a fraction (a/b) or (a): ");
			Fraction fractionTwo = getFraction(input);
			if(operator.equals("+")) 
			{
				Fraction result = fractionOne.add(fractionTwo);
				if(result.getNumerator() == 0) 
				{
					System.out.println(fractionOne.toString() + " " + operator + " " + fractionTwo.toString() + " = " + 0);
				}
				else {
					result.toLowestTerms();
					if(result.getNumerator() == result.getDenominator()) {
						System.out.println(fractionOne.toString() + " " + operator + " " + fractionTwo.toString() + " = " + 1);
					}
					else 
					{
						System.out.println(fractionOne.toString() + " " + operator + " " + fractionTwo.toString() + " = " + result.toString());
					}
				}
				
			}
			else if(operator.equals("-")) 
			{
				Fraction result = fractionOne.subtract(fractionTwo);
				if(result.getNumerator() == 0) 
				{
					System.out.println(fractionOne.toString() + " " + operator + " " + fractionTwo.toString() + " = " + 0);
				}
				else 
				{
					result.toLowestTerms();
					if(result.getNumerator() == result.getDenominator()) {
						System.out.println(fractionOne.toString() + " " + operator + " " + fractionTwo.toString() + " = " + 1);
					}
					else 
					{
						System.out.println(fractionOne.toString() + " " + operator + " " + fractionTwo.toString() + " = " + result.toString());
					}
				}
				
			}
			else if(operator.equals("*")) 
			{
				Fraction result = fractionOne.multiply(fractionTwo);
				if(result.getNumerator() == 0) 
				{
					System.out.println(fractionOne.toString() + " " + operator + " " + fractionTwo.toString() + " = " + 0);
				}
				else 
				{
					result.toLowestTerms();
					if(result.getNumerator() == result.getDenominator()) {
						System.out.println(fractionOne.toString() + " " + operator + " " + fractionTwo.toString() + " = " + 1);
					}
					else 
					{
						System.out.println(fractionOne.toString() + " " + operator + " " + fractionTwo.toString() + " = " + result.toString());
					}
				}
				
			}
			else if(operator.equals("/")) 
			{
				Fraction result = fractionOne.divide(fractionTwo);
				if(result.getNumerator() == 0) 
				{
					System.out.println(fractionOne.toString() + " " + operator + " " + fractionTwo.toString() + " = " + 0);
				}
				else
				{
					result.toLowestTerms();
					if(result.getNumerator() == result.getDenominator()) {
						System.out.println(fractionOne.toString() + " " + operator + " " + fractionTwo.toString() + " = " + 1);
					}
					else 
					{
						System.out.println(fractionOne.toString() + " " + operator + " " + fractionTwo.toString() + " = " + result.toString());
					}
				}
				
			}
			else if(operator.equals("=")) 
			{
				boolean result = fractionOne.equals(fractionTwo);
				System.out.println(fractionOne.toString() + " " + operator + " " + fractionTwo.toString() + " is " + result);
				
			}
			System.out.println("-----------------------------------------------");
			System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
			operator = getOperation(input);
		}
		System.out.println("END");
		
		
	}
	
	public static String getOperation(Scanner input) 
	{
		String operator = input.nextLine();
		while (!( (operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*") || operator.equals("=") || operator.equals("q") || operator.equals("Q")))) 
		{
			System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
			operator = input.nextLine();
		}
		return operator;
	}


	public static boolean validFraction(String input) 
	{
		boolean result = false;
		if(input.contains("-")) 
		{
			if(input.charAt(0) == '-') 
			{
				if(input.contains("/")) 
				{
					String numerator = input.substring(1, input.indexOf('/'));
					String denominator = input.substring(input.indexOf('/')+1);
					if(isNumber(numerator) == true && isNumber(denominator) == true && !denominator.equals("0")) 
					{
						num = Integer.parseInt(input.substring(0, input.indexOf('/')));
						denom = Integer.parseInt(denominator);
						result = true;
					}
				}
				else 
				{
					if(isNumber(input.substring(1)) == true) 
					{
						result = true;
					}
				}
			}
	
		}
		else 
		{
			if(input.contains("/")) 
			{
				String numerator = input.substring(0, input.indexOf('/'));
				String denominator = input.substring(input.indexOf('/')+1);
				if(isNumber(numerator) == true && isNumber(denominator) == true && !denominator.equals("0")) 
				{
					num = Integer.parseInt(numerator);
					denom = Integer.parseInt(denominator);
					result = true;
				}
			}
			else 
			{
				if(isNumber(input) == true) 
				{
					result = true;
				}
			}
		}
		return result;
		
	}

	
	public static boolean isNumber(String input) 
	{
		if (input.length() !=0) 
		{
			for (int i=0; i<input.length(); i++) 
			{
				if(Character.isDigit(input.charAt(i)) == false)
				{
					return false;
				}
			}
			return true;
		}
		else 
		{
			return false;
		}

	}

	public static Fraction getFraction(Scanner input) 
	{
		String fraction = input.nextLine();
		while (validFraction(fraction) == false) 
		{
			System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
			fraction = input.nextLine();
		}
		if (!fraction.contains("/")) 
		{
			return new Fraction(Integer.parseInt(fraction));
		}
		else 
		{
			return new Fraction(num, denom);
		}

	}
}
