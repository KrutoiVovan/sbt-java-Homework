package Terminal;

import Terminal.Exceptions.BadPinException;
import Terminal.Exceptions.InsufficientFundsException;
import Terminal.Exceptions.NoValidationException;

/**
 * Created by Владимир on 09.11.2016.
 */
public interface Terminal {
        public void logIn(int pin) throws BadPinException;
        public int checkAccountBalance() throws NoValidationException;
        public void addMoney(int a) throws NoValidationException;
        public void withdrawMoney(int a) throws NoValidationException, InsufficientFundsException;
}
