package com.nulabinc.backlog4j;

/**
 * Exception thrown when a api response contains error.
 *
 * @author nulab-inc
 */
public abstract class BacklogException extends RuntimeException {

    enum ErrorType {
        Undefined(-1),
        InternalError(1), LicenceError(2), LicenceExpiredError(3), AccessDeniedError(4),
        UnauthorizedOperationError(5), NoResourceError(6), InvalidRequestError(7),
        SpaceOverCapacityError(8), ResourceOverflowError(9), TooLargeFileError(10),
        AuthenticationError(11);

        ErrorType(int intValue) {
            this.intValue = intValue;
        }

        public int getIntValue() {
            return intValue;
        }

        public static ErrorType valueOf(final int anIntValue) {
            for (ErrorType d : values()) {
                if (d.getIntValue() == anIntValue) {
                    return d;
                }
            }
            return Undefined;
        }

        private int intValue;
    }

    public BacklogException(String message, Throwable cause) {
        super(message, cause);
    }

    public BacklogException(String message) {
        super(message);
    }

    public BacklogException(Throwable cause) {
        super(cause);
    }

    abstract public int getStatusCode();

    public ErrorType getErrorType(){
        return ErrorType.valueOf(getStatusCode());
    }
}
