public class Calculator {
	

	
    public static String calculate(String input) {
    	String[] stroka = input.split(" ");
    	boolean buly = false;
    	boolean bulyStr = false;
    	String[] ops = new String[] {"+", "-", "*", "/", "%"};
    	for (String el : ops) {
    		if (el.equals(stroka[1])) {
    			buly = true;
    		}
    	}
    	if (stroka[1].equals("+") || stroka[1].equals("-")) {
			bulyStr = true;
			boolean str11 = stroka[0].toLowerCase().equals(stroka[2].toLowerCase());
			boolean str22 = stroka[0].equals(stroka[2]);
			if (str11 && !str22 && stroka[1].equals("-")) {
				bulyStr = false;
			}
    	}
    	if (buly) {
	    	try {
	    		double numOne = Double.parseDouble(stroka[0]);
	    		double numTwo = Double.parseDouble(stroka[2]);
	    		return Double.toString(calculate(numOne, numTwo, stroka[1]));
	    	} catch (Exception e) {
	    		if (bulyStr) {
	    			return calculate(stroka[0], stroka[2], stroka[1]);
	    		} else {
	    			throw new IllegalArgumentException();
	    		}
	    	}
    	} else {
    		throw new IllegalArgumentException();
    	}
    	
    	
    }

    private static String calculate(String a, String b, String operation) throws IllegalArgumentException {
    	String stroka = a;
    	System.out.println(operation);
        if (operation.equals("+")) {
        	return a+b;
        } else if(operation.equals("-")) {
        	for (char el : b.toLowerCase().toCharArray()) {
        		for (char el2 : a.toLowerCase().toCharArray()) {
        			if (el == el2) {
        				stroka = stroka.replaceAll(String.valueOf(el).toUpperCase(), " ");
        				stroka = stroka.replaceAll(String.valueOf(el).toLowerCase(), " ");
        			}
        		}
        	}
        }
        return stroka.trim();
    }

    private static double calculate(double a, double b, String operation) throws IllegalArgumentException {
        switch(operation) {
        	case "+":
        		return a+b;
        	case "-":
        		return a-b;
        	case "*":
        		return a*b;
        	case "/":
        		try {
        			return a/b;
        		} catch (Exception e) {
        		}
        	case "%":
        		return a%b;
        	default:
        		return 0;
        }
    }

    public static int getNumbers(int a, int b) throws IllegalArgumentException {
        int num = a+b;
        int count = 0;
        while (num != 0) {
        	if ((num%10)%2==0) {
        		count ++;
        	}
        	num = num/10;
        }
        return count;
    }

    public static String getMinimalType(String input) throws IllegalArgumentException {
    	long num = Long.parseLong(input); 
    		if (num <=127 && num >=-128) {
    			return "Byte";
    		} else if((num<=32767 && num>=128) | (num>=-32767 && num<=-129)) {
    			return "Short";
    		} else if((num<=2147483647 && num>=32768) | (num>=-2147483647 && num<=-32769)) {
    			return "Int";
    		} else {
    			return "Long";
    		}
    	
    }
}