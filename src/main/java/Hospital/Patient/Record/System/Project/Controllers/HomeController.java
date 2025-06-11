package Hospital.Patient.Record.System.Project.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
            Welcome to Hospital Patient Record System API
            Available endpoints:\n

            - GET /patients - Get all patients\n
            - POST /patients/add - Add a new patient\n
            - PUT /patients/update/{id} - Update a patient\n
            - DELETE /patients/delete/{id} - Delete a patient\n
            - GET /api/doctors - Get all doctors\n
            - POST /api/doctors/add - Add a new doctor\n
            - PUT /api/update/{id} - Update a doctor\n
            """;
    }
} 