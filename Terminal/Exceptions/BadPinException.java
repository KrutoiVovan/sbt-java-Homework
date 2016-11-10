package Terminal.Exceptions;

/**
 * Created by Владимир on 09.11.2016.
 */
public class BadPinException extends RuntimeException {
    private int pin;

    public BadPinException(int pin){
        this.pin = pin;
    }
    @Override
    public String getMessage(){
        return "Incorrect pin = "+ pin;
    }

}
