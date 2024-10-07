package lk.ijse.springfinalassignment.Exeptions;

public class DataPersistExeption extends RuntimeException{
    public DataPersistExeption() {
        super();
    }

    public DataPersistExeption(String message) {
        super(message);
    }

    public DataPersistExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
