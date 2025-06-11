package Hospital.Patient.Record.System.Project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Hospital.Patient.Record.System.Project.Models.Doctor;
import Hospital.Patient.Record.System.Project.Services.DoctorService;
import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @PostMapping("/doctors/add")
    public ResponseEntity<String> addDoctors(@Valid @RequestBody Doctor doctor) {
        doctorService.addDoctors(doctor);
        return ResponseEntity.ok("Doctor added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAvailability(@Valid @RequestBody Doctor doctor, @PathVariable int id) {
        doctorService.updateDoctor(doctor, id);
        return ResponseEntity.ok("Doctor updated successfully");
    }
}
