package Hospital.Patient.Record.System.Project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Hospital.Patient.Record.System.Project.Models.Patient;
import Hospital.Patient.Record.System.Project.Services.PatientService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/patients")  // Changed to consistent plural naming
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Controller to View All Patients
    @GetMapping("/")
    public ResponseEntity<List<Patient>> getAllPatients() {

        return ResponseEntity.ok(patientService.getAllPatients());
    }

    // Controller to Add new Patients
    @PostMapping("/add")
    public ResponseEntity<String> addPatients(@Valid @RequestBody Patient patient) {
        patientService.addPatients(patient);
        return ResponseEntity.ok("Patient added successfully");
    }

    // Controller to Update the Existing Patient
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePatient(@Valid @RequestBody Patient patient, @PathVariable int id) {
        patientService.updatePatient(patient, id);
        return ResponseEntity.ok("Patient updated successfully");
    }

    // Delete Existing Patients
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}
