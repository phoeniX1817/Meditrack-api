package Hospital.Patient.Record.System.Project.Repositories;


import Hospital.Patient.Record.System.Project.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository  extends JpaRepository<Doctor ,Integer> {

}
