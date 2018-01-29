package validation;
import java.util.Scanner;
public class MainClass {
	public static boolean isValid(long number){
		int numOfDigits = MainClass.getSize(number);
		if(numOfDigits>=13 && numOfDigits<=16 ){
			boolean prefixNum =MainClass.prefixMatched(number,numOfDigits);
			if(prefixNum==true){
				int sumEven= MainClass.sumOfDoubleEvenPlace(number);
				int sumOdd= MainClass.sumOfOddPlace(number);
				int result = sumEven + sumOdd;
				if(result%10==0)
					return true;
				else
					return false;
			}	
			else
				return false;
		}
		else
			return false;
	}
	
	public static boolean prefixMatched(long number,int d){
		int prefixNum =(int)( number/(Math.pow(10,d-1)));
		if(prefixNum>=4 && prefixNum<=6)
			return true;
		else if(prefixNum==3){
			int secondNum =(int)( number/(Math.pow(10,d-2)));
			if(secondNum ==37)
				return true;
			else 
				return false;
		}
		else return false;
	} 
	
	public static int getSize(long d){
		long num =d ;
		int counter=0;
		while(num!=0){
			num/=10;
			counter++;
		}
		return counter;
	}
	
	public static int sumOfDoubleEvenPlace(long number){
		int sumEven=0;
		long x;
		int evenDigit;
		int doubleEvenDigit;
		while(number!=0){
			number /=10;
			x = (number);
			evenDigit =(int) (x%10);
			number /=10;
			doubleEvenDigit = MainClass.getDigit(evenDigit);
			sumEven += doubleEvenDigit;
		}
		return sumEven;	  
	}
	
	public static int getDigit(int number){
		int doubleDigit = number*2;
		if(doubleDigit<=9)
			return doubleDigit;
		else{
			int firstDigit = doubleDigit %10;
			int secondDigit = doubleDigit/10;
			return (firstDigit + secondDigit );
		}		
	}
	
	public static int sumOfOddPlace(long number){
		int sumOdd=0;
		while(number!=0){
			sumOdd +=(int) (number%10);
			number /= 100;
		}
		return sumOdd;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		//take Credit card numbers from user
		System.out.println("Please enter your Credit card number as a long integer");
		long creditCard= input.nextLong();
		//System.out.println(creditCard);
		//calling isValid method to check Credit card number
		boolean validation= MainClass.isValid(creditCard);
		if(validation==true)
			System.out.println(creditCard +" is Valid");	
		else
			System.out.println(creditCard +" is invalid");			
	}
}
