import java.util.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class myMain {
    public static void main(String[] args){
        myATMinterface obj = new myATMinterface.myATMWorking();
        int atmNumber= 5123;
        int atmPassword=666;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to ABC Bank ATM! Please enter your ATM Number: ");
        int myatmNum=sc.nextInt();
        System.out.println("Please enter your ATM Pin: ");
        int atmPin = sc.nextInt();
        System.out.println("Please wait till we complete the validation process....");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(myatmNum==atmNumber && atmPin==atmPassword){
            System.out.println("Thank you for waiting! Your validation was successfull. Please choose function you want to perform:-");
            while(true){
                System.out.println("1. Transactions History\n2. Deposit Money\n3. Withdraw Money\n4. Transfer Money\n5. Quit");
                System.out.println("Enter any choice: ");
                int option=sc.nextInt();
                if(option==1){
                    obj.TransactionHistory();
                }
                else if(option==2){
                    System.out.println("Please enter the amount of money you want to deposit to your bank account: ");
                    double deposit = sc.nextDouble();
                    obj.deposit(deposit);
                }
                else if(option ==3){
                    System.out.println("Please enter the amount you want to withdraw from your bank account.");
                    double withdrawl=sc.nextDouble();
                    obj.withdrawl(withdrawl);
                }
                else if(option==4){
                    System.out.println("Please enter the name of the Bank Account you want to transfer your money to: ");
                    String name = sc.next();
                    System.out.println("Please enter the amount you want to transfer to "+name+" bank: ");
                    double trans = sc.nextDouble();
                    obj.Transfer(trans,name);
                }
                else if(option==5){
                    System.out.println("Thank You for choosing ABC Bank ATM! Please collect your card.");
                    System.exit(0);
                }
                else{
                    System.out.println("Please enter option from 1 to 5.");
                }
            }
        }
        else{
            System.out.println("Looks Like you entered an incorrect ATM details. Please recheck the details and try again.");
            System.out.println("Thank you for using ABC Bank ATM!");
            System.exit(0);
        }
    }
}
