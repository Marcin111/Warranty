package primary.WarrantyManagement.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarrantyDTO {

    private Long id;
    private String name;
    private String type;
    private String brand;
    private String date;
    private int length;
    private String invoice;
    private Long idOfUser;
    private Date created;

}
