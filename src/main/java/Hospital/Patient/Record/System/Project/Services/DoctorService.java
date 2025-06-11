package Hospital.Patient.Record.System.Project.Services;

import Hospital.Patient.Record.System.Project.Models.Doctor;
import Hospital.Patient.Record.System.Project.Repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository DoctorRepo;

    // Fetch All Doctors
    public List<Doctor> getAllDoctors() {
        return DoctorRepo.findAll();
    }

    // Add New Doctors
    public void addDoctors(Doctor doctor) {
        DoctorRepo.save(doctor);
    }

    // Update Doctor Details
    @Transactional
    public void updateDoctor(Doctor updatedDoctor, int id) {
        if (DoctorRepo.existsById(id)) {
            Doctor existingDoctor = DoctorRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Doctor not found with id: " + id));

            // Update the fields of the existing doctor with the values from the updatedDoctor
            existingDoctor.setName(updatedDoctor.getName());
            existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
            existingDoctor.setAvailability(updatedDoctor.getAvailability());
        }
    }
}