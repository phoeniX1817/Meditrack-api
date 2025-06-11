package Hospital.Patient.Record.System.Project.Services;

import Hospital.Patient.Record.System.Project.Models.Patient;
import Hospital.Patient.Record.System.Project.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepo;

    // Method to Add New Patients
    public void addPatients(Patient patient) {

        patientRepo.save(patient);
    }

    // Method to View All Patients
    public List<Patient> getAllPatients() {

        return patientRepo.findAll();
    }

    // Update the existing Patient
    public void updatePatient(Patient patient, int id) {
        if (patientRepo.existsById(id)) {
            Patient existingPatient = patientRepo.findById(id).get();
            existingPatient.setName(patient.getName());
            existingPatient.setAge(patient.getAge());
            existingPatient.setPhoneNo(patient.getPhoneNo());
            patientRepo.save(existingPatient);
        }
    }

    // Delete the existing Patient
    public void deletePatient(int id) {
        if (patientRepo.existsById(id)) {
            patientRepo.deleteById(id);
        } else {
            throw new RuntimeException("Patient with ID " + id + " does not exist.");
        }
    }
}
