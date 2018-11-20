package primary.WarrantyManagement.models.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Warranty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String brand;
    private String date;
    private int length;
    private String invoice;
    private Date warrantyAdded = new Date();

    @Embedded
    private AuditEntity audit = new AuditEntity();

    public Warranty(String name, String type, String brand, String date, int length, String invoice) {
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.date = date;
        this.length = length;
        this.invoice = invoice;
    }
}
