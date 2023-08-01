package Parser;

import java.util.Scanner;

public class Parser {
	public static void main(String[] args) {
		// TODO напишите консольное приложение
        Scanner input = new Scanner(System.in);
		
		Movements movements = null;
		
		String stroka;
		while (true) {
			System.out.print("1 - Сумма расходов\n2 - Сумма доходов\n3 - Расходы по организациям в виде строк\n0 - выход");
            stroka = input.next();
            System.out.println();
            
            if (stroka.equals("0")) {
            	break;
            } else if (stroka.equals("1")) {
            	System.out.println(movements.getExpenseSum());
            } else if (stroka.equals("2")) {
            	System.out.println(movements.getIncomeSum());
            } else if (stroka.equals("3")) {
            	System.out.println(movements.getListOfExpenses());
            }
			
			
		}
		
	}

}