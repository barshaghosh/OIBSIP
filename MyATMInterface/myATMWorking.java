import java.util.HashMap;
import java.util.Map;

interface myATMinterface {
    public void TransactionHistory();

    public void deposit(double deposit);

    public void withdrawl(double withdrawl);

    public void Transfer(double trans, String name);


    public class myATMWorking implements myATMinterface {
        myATM atm = new myATM();
        Map<Double, String> transfer = new HashMap<>();

        @Override
        public void TransactionHistory() {
            for (Map.Entry<Double, String> t : transfer.entrySet()) {
                System.out.println(t.getKey() + "" + t.getValue());
            }
            System.out.println("You have Rs. " + atm.getAvailableBalance() + " in your account currently.");
        }

        @Override
        public void deposit(double deposit) {
            transfer.put(deposit, " rupees was successfully deposited in your bank account.");
            atm.setAvailableBalance(atm.getAvailableBalance() + deposit);
            TransactionHistory();
        }

        @Override
        public void withdrawl(double withdrawl) {
            if (withdrawl < atm.getAvailableBalance()) {
                transfer.put(withdrawl, " was successfully withdrawn from your bank account. Please collect the cash below.");
                atm.setAvailableBalance(atm.getAvailableBalance() - withdrawl);
                TransactionHistory();
            } else {
                System.out.println("Sorry you do not have enough balance in your account to proceed.");
            }
        }

        @Override
        public void Transfer(double trans, String name) {
            if (atm.getAvailableBalance() < trans) {
                System.out.println("Transfer fails because of unavailability of sufficient transaction amount.");
            } else {
                atm.setAvailableBalance(atm.getAvailableBalance()-trans);
                System.out.println("Amount of Rs. "+ trans+ " successfully transferred to "+ name + " bank!");
                TransactionHistory();
            }
        }
    }
}
