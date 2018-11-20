package primary.WarrantyManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import primary.WarrantyManagement.models.entities.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
}
