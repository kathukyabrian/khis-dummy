package hackathon.group4.khis.repository;

import hackathon.group4.khis.domain.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientRecord, Long> {
}
