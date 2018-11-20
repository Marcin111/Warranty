package primary.WarrantyManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import primary.WarrantyManagement.models.entities.Report;
import primary.WarrantyManagement.models.entities.Warranty;
import primary.WarrantyManagement.repositories.ReportRepository;
import primary.WarrantyManagement.repositories.WarrantyRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private WarrantyRepository warrantyRepository;
    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/")
    public String Home() {
        return "Home";
    }

    @GetMapping("/warranties")
    public String warrantyPage(Model model) {
        List<Warranty> warrantyList = new ArrayList<>();
        Iterable<Warranty> warrantyIterable = warrantyRepository.findAll();

        for (Warranty warranty : warrantyIterable) {
            warrantyList.add(warranty);
        }

        model.addAttribute("warranties", warrantyList);
        return "warranties";
    }

    @PostMapping("/addwarranty")
    public String addWarranty(@RequestParam(value = "name") String nameParam,
                              @RequestParam(value = "type") String type,
                              @RequestParam(value = "brand") String brand,
                              @RequestParam(value = "date") String date,
                              @RequestParam(value = "length") int length,
                              @RequestParam(value = "invoice") String invoice) {
        Warranty warranty = new Warranty(nameParam, type, brand, date, length, invoice);
        warrantyRepository.save(warranty);
        return "redirect:/warranties";
    }

    @GetMapping("/addwarranty")
    public String addWarranty() {
        return "addwarranty";
    }

    @GetMapping("/addreport")
    public String addReport(){
        return "addreport";
    }

    @PostMapping("/addreport")
    public String addReport(@RequestParam(value = "reportName") String reportName,
                            @RequestParam(value = "reportType") String reportType,
                            @RequestParam(value = "reportBrand") String reportBrand,
                            @RequestParam(value = "reportPurchased") String reportPurchased,
                            @RequestParam(value = "reportInvoiceId") String reportInvoiceId,
                            @RequestParam(value = "reportProblem") String reportProblem){
        Report report = new Report(reportName, reportType, reportBrand, reportPurchased, reportInvoiceId, reportProblem);
        reportRepository.save(report);
        return "redirect:/reports";
    }

    @GetMapping("/reports")
    public String reportPage(Model model){
        List<Report> reportList = new ArrayList<>();
        Iterable<Report> reportIterable = reportRepository.findAll();

        for (Report report : reportIterable){
            reportList.add(report);
        }
        model.addAttribute("reports", reportList);
        return "reports";
    }

}
