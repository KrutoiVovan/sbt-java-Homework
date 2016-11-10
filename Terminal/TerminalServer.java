package Terminal;

import Terminal.Exceptions.InsufficientFundsException;
import Terminal.Exceptions.NoValidationException;

/**
 * Created by Владимир on 09.11.2016.
 */
public class TerminalServer {

    private int balance;
    private boolean validation;

    public TerminalServer(){
        validation = false;
        balance = 1000;
    }

    public void connect() {
        System.out.println("Sucessfully connected!");
        validation = true;
    }
    public void addMoney(int a) throws NoValidationException{
        if (validation == false) throw new NoValidationException();
        balance += a;
    }
    public void withdrawMoney(int a) throws NoValidationException, InsufficientFundsException{
        if(validation == false) throw new NoValidationException();
        if(a > balance) throw new InsufficientFundsException();
        balance -=a;
    }

    public int getBalance() throws NoValidationException {
        if (validation == false) throw new NoValidationException();
        return balance;
    }
}
