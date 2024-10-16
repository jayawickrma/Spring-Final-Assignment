package lk.ijse.springfinalassignment.customeStatusCode;



import lk.ijse.springfinalassignment.dto.CustomerStatus;
import lk.ijse.springfinalassignment.dto.ItemStatus;
import lk.ijse.springfinalassignment.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErroStatus implements CustomerStatus, ItemStatus, OrderStatus {
    private int statusCode;
    private String statusMessage;
}
