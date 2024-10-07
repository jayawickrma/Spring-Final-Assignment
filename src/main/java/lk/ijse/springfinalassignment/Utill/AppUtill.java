package lk.ijse.springfinalassignment.Utill;

import java.rmi.server.UID;
import java.util.UUID;

public class AppUtill {
    public static String customerId(){
        return "ID -" + UUID.randomUUID();
    }
    public static String itemCode(){
        return "CODE -" +UUID.randomUUID();
    }
}
