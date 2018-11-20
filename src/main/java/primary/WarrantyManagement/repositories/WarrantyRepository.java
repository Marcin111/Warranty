package primary.WarrantyManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import primary.WarrantyManagement.models.entities.Warranty;

@Repository
public interface WarrantyRepository extends JpaRepository<Warranty, Integer> {



}
