//The Chain of Responsibility pattern allows multiple objects to handle a request without //explicitly specifying the receiver, forming a chain where each object in the chain either handles //the request or passes it to the next handler.
import java.util.Scanner;

// Client class
public class ATMDispenseChain {
    private DispenseChain c1;

    public ATMDispenseChain() {
        // initialize the chain
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // process the request
            atmDispenser.c1.dispense(new Currency(amount));
        }
    }
}

// Interface for the chain
interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(Currency cur);
}

// Concrete handler class for $10 dispenser
class Dollar10Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 10) {
            int num = cur.getAmount() / 10;
            int remainder = cur.getAmount() % 10;
            System.out.println("Dispensing " + num + " $10 notes");
            if (remainder != 0)
                this.chain.dispense(new Currency(remainder));
        } else {
            this.chain.dispense(cur);
        }
    }
}

// Concrete handler class for $20 dispenser
class Dollar20Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 20) {
            int num = cur.getAmount() / 20;
            int remainder = cur.getAmount() % 20;
            System.out.println("Dispensing " + num + " $20 notes");
            if (remainder != 0)
                this.chain.dispense(new Currency(remainder));
        } else {
            this.chain.dispense(cur);
        }
    }
}

// Concrete handler class for $50 dispenser
class Dollar50Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 50) {
            int num = cur.getAmount() / 50;
            int remainder = cur.getAmount() % 50;
            System.out.println("Dispensing " + num + " $50 notes");
            if (remainder != 0)
                this.chain.dispense(new Currency(remainder));
        } else {
            this.chain.dispense(cur);
        }
    }
}

// Currency class
class Currency {
    private int amount;

    public Currency(int amt) {
        this.amount = amt;
    }

    public int getAmount() {
        return this.amount;
    }
}