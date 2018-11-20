package primary.WarrantyManagement.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reportId;
    private String reportName;
    private String reportType;
    private String reportBrand;
    private String reportPurchased;
    private String reportInvoiceId;
    private String reportProblem;
    private String reportStatus = "New";
    private Date reportUpdate = new Date();
    private Date reportAdded = new Date();

    @Embedded
    private AuditEntity audit = new AuditEntity();

    public Report(String reportName, String reportType, String reportBrand, String reportPurchased, String reportInvoiceId, String reportProblem) {
        this.reportName = reportName;
        this.reportType = reportType;
        this.reportBrand = reportBrand;
        this.reportPurchased = reportPurchased;
        this.reportInvoiceId = reportInvoiceId;
        this.reportProblem = reportProblem;
    }
}
