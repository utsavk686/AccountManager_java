package wipro;
import java.util.*;

public class NewBankingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double account1Balance = 25000; 
        double account2Balance = 50000; 

        while (true) {
            System.out.println("Select Account:");
            System.out.println("1. Account 1");
            System.out.println("2. Account 2");
            System.out.println("3. Exit");
            System.out.println("---------------------------------------");
            
            System.out.print("Enter your choice: ");
            int accountChoice = sc.nextInt();

            
            double currentBalance = 0;
            String accountName = "";

            
            if (accountChoice == 1) {
                currentBalance = account1Balance;
                accountName = "Account 1";
            } else if (accountChoice == 2) {
                currentBalance = account2Balance;
                accountName = "Account 2";
            } else if (accountChoice == 3) {
                System.out.println("Thank you for using our services!");
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid account.");
                continue;
            }

            while (true) {
                System.out.println("\n--- " + accountName + " Operations ---");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Transfer Money");
                System.out.println("5. Switch Account");
                System.out.println("---------------------------------------");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1: 
                        System.out.println(accountName + " Balance: " + currentBalance);
                        System.out.println("*************************");
                        break;
                        

                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double deposit = sc.nextDouble();
                        currentBalance += deposit;
                        System.out.println("Deposited " + deposit + ". New balance: " + currentBalance);
                        System.out.println("*************************");
                        break;

                    case 3: 
                        System.out.print("Enter amount to withdraw: ");
                        double withdraw = sc.nextDouble();
                        if (withdraw <= currentBalance) {
                            currentBalance -= withdraw;
                            System.out.println("Withdrew " + withdraw + ". New balance: " + currentBalance);
                        } else {
                            System.out.println("Insufficient balance!");
                        }
                        System.out.println("*************************");
                        break;

                    case 4: 
                        System.out.print("Enter amount to transfer: ");
                        double transfer = sc.nextDouble();
                        if (transfer <= currentBalance) {
                            if (accountChoice == 1) {
                                currentBalance -= transfer;
                                account2Balance += transfer;
                                System.out.println("Transferring amount........");
                                System.out.println("Transferred " + transfer + " to Account 2");
                            } else {
                                currentBalance -= transfer;
                                account1Balance += transfer;
                                System.out.println("Transferring amount........");
                                System.out.println("Transferred " + transfer + " to Account 1");
                            }
                        } else {
                            System.out.println("Insufficient balance!");
                        }
                        System.out.println("*************************");
                        break;

                    case 5: 
                        System.out.println("Switching account...");
                        
                        if (accountChoice == 1) {
                            account1Balance = currentBalance;
                        } else {
                            account2Balance = currentBalance;
                        }
                        System.out.println("*************************");
                        break;

                    default:
                        System.out.println("Please Select a Valid Input.");
                }

                if (choice == 5) {
                    break; 
                }
            }
        }
        sc.close();
    }
}
