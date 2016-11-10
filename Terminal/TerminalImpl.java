package Terminal;

import Terminal.Exceptions.BadPinException;
import Terminal.Exceptions.InsufficientFundsException;
import Terminal.Exceptions.NoValidationException;

/**
 * Created by Владимир on 09.11.2016.
 */
public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final PinValidator pinValidator;

    public TerminalImpl(){
        pinValidator = new PinValidator();
        server = new TerminalServer();
    }

    public TerminalImpl(TerminalServer server, PinValidator pinValidator){
        this.pinValidator = pinValidator;
        this.server = server;
    }

    @Override
    public void logIn(int pin) throws BadPinException {
            pinValidator.checkPin(pin);
            server.connect();
    }

    @Override
    public int checkAccountBalance() throws NoValidationException {
        return server.getBalance();
    }

    @Override
    public void addMoney(int a) throws NoValidationException {
        server.addMoney(a);
    }

    @Override
    public void withdrawMoney(int a) throws NoValidationException, InsufficientFundsException {
        server.withdrawMoney(a);
    }
}
