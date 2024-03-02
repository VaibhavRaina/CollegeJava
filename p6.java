class SavingAccount {
    static double annualInterestRate;
    private double savingsBalance;

    SavingAccount(double num) {
        savingsBalance = num;
    }

    double calculateMonthlyInterest() {
        double res = savingsBalance + (savingsBalance * annualInterestRate) / 12;
        return res;
    }

    static void modifyinterestRate(int AnnualInterestRate) {
        annualInterestRate = AnnualInterestRate;
    }

}

public class p6 {
    public static void main(String[] args) {
        SavingAccount saver1 = new SavingAccount(2000);
        SavingAccount saver2 = new SavingAccount(3000);
        saver1.annualInterestRate = 4;
        saver2.annualInterestRate = 4;
        System.out.println(saver1.calculateMonthlyInterest());
        System.out.println(saver2.calculateMonthlyInterest());
        saver1.modifyinterestRate(5);
        saver2.modifyinterestRate(5);
        System.out.println(saver1.calculateMonthlyInterest());
        System.out.println(saver2.calculateMonthlyInterest());
    }
}
