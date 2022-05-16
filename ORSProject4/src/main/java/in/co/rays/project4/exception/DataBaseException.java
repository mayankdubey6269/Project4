package in.co.rays.project4.exception;
/**
 * DatabaseException is propogated by DAO classes when an unhandled Database
 * exception occurred
 *
 * @author Mayank Dubey

 *
 */
public class DataBaseException extends Exception {

    /**
     *            : Error message
     */
    public DataBaseException(String msg) {
        super(msg);
    }
}
