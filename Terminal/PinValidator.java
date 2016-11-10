package Terminal;

import Terminal.Exceptions.BadPinException;

/**
 * Created by Владимир on 09.11.2016.
 */
public class PinValidator {
    public void checkPin(int pin) throws BadPinException {
        if(pin != 1111)
            throw new BadPinException(pin);
    }
}
