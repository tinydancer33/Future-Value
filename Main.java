package murach.fv;

import java.text.NumberFormat;
import java.util.Scanner;


//Name: Erica Osborn
//Date: 09/14/19
//Description: Modifying future value application.

public class Main {

    public static void main(String[] args) {
        // display a welcome message
        System.out.println("Welcome to the Future Value Calculator");
        System.out.println();

        Scanner sc = new Scanner(System.in);        
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {

            // get input from user
            System.out.print("Enter monthly investment:   ");
            double monthlyInvestment = Double.parseDouble(sc.nextLine());

            System.out.print("Enter yearly interest rate: ");
            double yearlyInterestRate = Double.parseDouble(sc.nextLine());

            System.out.print("Enter number of years:      ");
            int years = Integer.parseInt(sc.nextLine());                        
            
            // convert yearly values to monthly values
            double monthlyInterestRate = yearlyInterestRate / 12 / 100;
            int months = years * 12;        

            // calculate the future value
            double futureValue = 0;
            int i = 1;
            final double YEARLY_FEE = 50.00;
           
            while (i <= months) {
                futureValue =  (futureValue + monthlyInvestment) + (futureValue * monthlyInterestRate);
                    i ++;
                if (months % 12 ==0){
                     futureValue = futureValue - YEARLY_FEE;
                }
                    
                    
            } 
            
            //currency formatting to YEARLY_FEE and prints to console
                System.out.println("Yearly fee:                  " +
                        NumberFormat.getCurrencyInstance().format(YEARLY_FEE));
                System.out.println();


            // format and display the result
            System.out.println("Future value:               " + 
                    NumberFormat.getCurrencyInstance().format(futureValue));
            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
        System.out.println("Bye!");
    }
}