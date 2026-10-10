import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class Account {
    protected String id;
    protected int balance;

    Account(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    abstract boolean withdraw(int amount);
}

class SavingsAccount extends Account {
    SavingsAccount(String id, int balance) {
        super(id, balance);
    }

    boolean withdraw(int amount) {
        if (balance - amount < 1000) {
            System.out.println(id + " rejected: minimum balance 1000");
            return false;
        }

        balance -= amount;
        System.out.println(id + " balance " + balance);
        return true;
    }
}

class CurrentAccount extends Account {
    CurrentAccount(String id, int balance) {
        super(id, balance);
    }

    boolean withdraw(int amount) {
        if (balance - amount < -5000) {
            System.out.println(id + " rejected: overdraft limit 5000");
            return false;
        }

        balance -= amount;
        System.out.println(id + " balance " + balance);
        return true;
    }
}

public class BankAccountWithdrawal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            if (parts[0].equals("Savings")) {
                accounts.put(
                    parts[1],
                    new SavingsAccount(parts[1], Integer.parseInt(parts[2]))
                );
            } else if (parts[0].equals("Current")) {
                accounts.put(
                    parts[1],
                    new CurrentAccount(parts[1], Integer.parseInt(parts[2]))
                );
            } else if (parts[0].equals("WITHDRAW")) {
                String id = parts[1];
                int amount = Integer.parseInt(parts[2]);

                Account account = accounts.get(id);

                if (account == null) {
                    System.out.println("Account not found");
                } else {
                    account.withdraw(amount);
                }
            }
        }

        sc.close();
    }
}