import java.util.Scanner;

public class App {
    public static void main(String args[]) {
        int balance = 0, withdraw = 0, deposit = 0, transfer = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("|---- ATM Machine at your service ----|");
        System.out.println("-------------------------------------------");
        System.out.println("Enter the amount of money you want to open your bank account with:");
        balance = sc.nextInt();
        while (true) {
            System.out.println("-------------------------------------------");
            System.out.println("|   Choose 1 for Withdraw                 |");
            System.out.println("-------------------------------------------");
            System.out.println("|   Choose 2 for Deposit                  |");
            System.out.println("-------------------------------------------");
            System.out.println("|   Choose 3 for Check Balance            |");
            System.out.println("-------------------------------------------");
            System.out.println("|   Choose 4 for Transaction History      |");
            System.out.println("-------------------------------------------");
            System.out.println("|   Choose 5 for Transfer Money           |");
            System.out.println("-------------------------------------------");
            System.out.println("|   Choose 6 for EXIT                     |");
            System.out.println("-------------------------------------------");
            System.out.println("Choose the operation you want to perform:");
            int want = sc.nextInt();
            switch (want) {
                case 1:
                    System.out.print("Enter money to be withdrawn:");
                    withdraw = sc.nextInt();
                    if (balance >= withdraw) {
                        balance = balance - withdraw;
                        System.out.println("---------------------------------------------");
                        System.out.println("|   Money Withdraw Successfully !!!          |");
                        System.out.println("|   Please collect your money                |");
                        System.out.println("---------------------------------------------");
                    } else {
                        System.out.println("Insufficient Balance");
                        System.out.println("Please Check Your Balance");
                    }
                    break;

                case 2:
                    System.out.println("Enter money to be deposited:");
                    deposit = sc.nextInt();
                    balance = balance + deposit;
                    System.out.println("---------------------------------------------");
                    System.out.println("| Your Money has been successfully depsited |");
                    System.out.println("---------------------------------------------");
                    break;

                case 3:
                    System.out.println("Balance : " + balance);
                    break;

                case 4:
                    System.out.println("|Transaction History|");
                    System.out.println("|Deposited Ammount : " + deposit + "|");
                    System.out.println("|Withdrawn Ammount : " + withdraw + "|");
                    System.out.println("|Transferred Ammount : " + transfer + "|");
                    break;

                case 5:
                    long ACCNO;
                    int amount;
                    System.out.println("Enter The Account No (11 digited unique number of anyone's bank account): ");
                    ACCNO = sc.nextLong();
                    long n = ACCNO;
                    int c = (int) Math.floor(Math.log10(n) + 1);
                    if (c != 11) {
                        System.out.println("Invalid account number given : It is not 11 digited.\nPlease Check!");
                    } else {
                        System.out.println("Enter The Amount  : ");
                        amount = sc.nextInt();
                        if (balance >= amount) {
                            transfer = amount;
                            balance = balance - amount;
                            System.out.println("---------------------------------------------");
                            System.out.println("|Transfer Money Successfully to Account no.: " + ACCNO + " !!!");
                            System.out.println("---------------------------------------------");
                        } else {
                            System.out.println("Insufficient Balance");
                            System.out.println("Please Check Your Balance");
                        }
                    }
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}