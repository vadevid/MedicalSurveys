package my.project.medicalsurveys.auth;

import jakarta.transaction.Transactional;
import my.project.medicalsurveys.config.JwtService;
import my.project.medicalsurveys.entity.Doctor;
import my.project.medicalsurveys.entity.Patient;
import my.project.medicalsurveys.entity.Role;
import my.project.medicalsurveys.entity.User;
import my.project.medicalsurveys.model.request.LoginRequest;
import my.project.medicalsurveys.model.request.RegisterDoctorRequest;
import my.project.medicalsurveys.model.request.RegisterPatientRequest;
import my.project.medicalsurveys.model.response.AuthenticationResponse;
import my.project.medicalsurveys.model.response.LoginResponse;
import my.project.medicalsurveys.repository.DoctorRepository;
import my.project.medicalsurveys.repository.PatientRepository;
import my.project.medicalsurveys.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 AuthenticationManager authenticationManager,
                                 DoctorRepository doctorRepository,
                                 PatientRepository patientRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Transactional
    public AuthenticationResponse registerPatient(RegisterPatientRequest request) throws Exception {
        User oldUser = userRepository.findByLogin(request.getLogin());
        if (oldUser != null) throw new Exception(String.format("Пользователь с логином '%s' уже существует.", request.getLogin()));
        User user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setSecondName(request.getSecondName());
        user.setFirstName(request.getFirstName());
        user.setMiddleName(request.getMiddleName());
        user.setRole(Role.PATIENT_ROLE);
        userRepository.save(user);
        Patient newPatient = new Patient();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        newPatient.setUser(user);
        newPatient.setSex(request.getSex());
        newPatient.setBirthdate(LocalDate.parse(request.getBirthdate(), formatter));
        newPatient.setEmail(request.getEmail());
        patientRepository.save(newPatient);
        var jwtToken = jwtService.generateToken(user);
        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken(jwtToken);
        return response;
    }

    @Transactional
    public AuthenticationResponse registerDoctor(RegisterDoctorRequest request) throws Exception {
        User oldUser = userRepository.findByLogin(request.getLogin());
        if (oldUser != null) throw new Exception(String.format("Пользователь с логином '%s' уже существует.", request.getLogin()));
        User user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setSecondName(request.getSecondName());
        user.setFirstName(request.getFirstName());
        user.setMiddleName(request.getMiddleName());
        user.setRole(Role.DOCTOR_ROLE);
        userRepository.save(user);
        Doctor newDoctor = new Doctor();
        newDoctor.setUser(user);
        newDoctor.setType(request.getType());
        doctorRepository.save(newDoctor);
        var jwtToken = jwtService.generateToken(user);
        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken(jwtToken);
        return response;
    }

    public LoginResponse login(LoginRequest request) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        User user = userRepository.findByLogin(request.getLogin());
        if (user == null) throw new Exception(String.format("Пользователь с логином '%s' не найден", request.getLogin()));
        var jwtToken = jwtService.generateToken(user);
        LoginResponse response = new LoginResponse();
        response.setToken(jwtToken);
        response.setId(user.getId());
        response.setRole(user.getRole().name());
        return response;
    }
}
