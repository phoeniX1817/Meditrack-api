package Hospital.Patient.Record.System.Project.Repositories;

import Hospital.Patient.Record.System.Project.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
