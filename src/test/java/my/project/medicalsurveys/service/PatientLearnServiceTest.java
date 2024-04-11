package my.project.medicalsurveys.service;

import my.project.medicalsurveys.entity.PatientLearn;
import my.project.medicalsurveys.repository.PatientLearnRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
public class PatientLearnServiceTest {

    @Autowired
    PatientLearnService patientLearnService;

    @MockBean
    PatientLearnRepository patientLearnRepository;

    @Test
    void checkPatientModuleTest() {
        PatientLearn patientLearn = new PatientLearn();
        patientLearn.setPatientId(1);
        patientLearn.setLearnModuleId(1);
        PatientLearn newPatientLearn = new PatientLearn();
        newPatientLearn.setPatientId(1);
        newPatientLearn.setLearnModuleId(1);
        newPatientLearn.setActive(false);
        Mockito.doReturn(patientLearn).when(patientLearnRepository).findByPatientIdAndLearnId(1, 1);
        Mockito.doReturn(newPatientLearn).when(patientLearnRepository).update(patientLearn);

        PatientLearn result = patientLearnService.checkPatientLearn(1, 1);
        assertNotNull(result);
        assertEquals(1, result.getPatientId());
        assertEquals(1, result.getLearnModuleId());
        assertFalse(result.isActive());
    }
}
