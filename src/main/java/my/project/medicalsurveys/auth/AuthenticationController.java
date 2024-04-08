package my.project.medicalsurveys.auth;

import my.project.medicalsurveys.model.request.LoginRequest;
import my.project.medicalsurveys.model.request.RegisterDoctorRequest;
import my.project.medicalsurveys.model.request.RegisterPatientRequest;
import my.project.medicalsurveys.model.response.AuthenticationResponse;
import my.project.medicalsurveys.model.response.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register_patient")
    public ResponseEntity<AuthenticationResponse> registerPatient(
            @RequestBody RegisterPatientRequest request
            ) throws Exception {
        return ResponseEntity.ok(service.registerPatient(request));
    }

    @PostMapping("/register_doctor")
    public ResponseEntity<AuthenticationResponse> registerDoctor(
            @RequestBody RegisterDoctorRequest request
            ) throws Exception {
        return ResponseEntity.ok(service.registerDoctor(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request
            ) throws Exception {
        return ResponseEntity.ok(service.login(request));
    }
}
