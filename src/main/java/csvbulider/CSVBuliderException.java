package csvbulider;

public class CSVBuliderException extends Throwable {

  public enum ExceptionType {
        CENSUS_FILE_PROBLEM, UNABLE_TO_PARSE,RUNTIME_EXCEPTION;
    }
    public  ExceptionType type;

    public CSVBuliderException(String message, ExceptionType type) {
        super(message);
        this.type=type;
    }

}
