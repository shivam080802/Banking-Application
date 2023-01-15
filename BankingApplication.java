import java.util.*;

import javax.lang.model.util.ElementScanner14;

public class BankingApplication {

    public static void main(String args[])
    {
        BankAccount obj1 = new BankAccount("XYZ","BA001");
        obj1.showMenu();

    }
}


class BankAccount
{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid)
    {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount)
    {
        if(amount !=0)
        {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount)
    {
        if(amount!=0)
        {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }
    void getPreviousTransaction()
    {
        if(previousTransaction > 0)
        {
            System.out.println("Deposited : "+previousTransaction);
        }
        else if(previousTransaction < 0)
        {
            System.out.println("Withdrawn : "+previousTransaction);
        }
        else{
            System.out.println("No transaction Occured");
        }
    }

    void showMenu()
    {
        char option = '\0';
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome "+customerName);
        System.out.println("Your ID is "+customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C.Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do{
            System.out.println("================================================================");
            System.out.println("Enter an option");
            System.out.println("================================================================");
            option = scan.next().charAt(0);
            System.out.println("\n");

            switch(option)
            {
                case 'A':
                System.out.println("--------------------");
                System.out.println("Balance = "+balance);
                System.out.println("--------------------");
                System.out.println("\n");
                break;

                case 'B':
                System.out.println("--------------------");
                System.out.println("Enter an amount to deposit: ");
                System.out.println("--------------------");
                int amount1 = scan.nextInt();
                deposit(amount1);
                System.out.println("\n");
                break;

                case 'C':
                System.out.println("--------------------");
                System.out.println("Enter an amount to be withdrawn: ");
                System.out.println("--------------------");
                int amount2 = scan.nextInt();
                withdraw(amount2);
                System.out.println("\n");
                break;

                case 'D':
                System.out.println("--------------------");
                getPreviousTransaction();
                System.out.println("--------------------");
                System.out.println("\n");
                break;
                
                case 'E':
                System.out.println("***************************************************");

                default:
                System.out.println("Invalid option");
                break;

            }

        }while(option != 'E');

        System.out.println("Thankyou for using our services");
    }
}