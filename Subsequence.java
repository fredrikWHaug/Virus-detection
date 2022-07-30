
public class Subsequence {

    public final String subsequence;
    private int amount;

    public Subsequence(String subsequence, int amount) {
        this.subsequence = subsequence;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int newAmount) {
        amount = newAmount;
    }

    public String toString() {
        return "(" + subsequence + ", " + amount + ")";
    }

}