package hackathon.group4.khis.web.rest;

import hackathon.group4.khis.domain.PatientRecord;
import hackathon.group4.khis.dto.PatientRecordDTO;
import hackathon.group4.khis.service.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/khis")
public class PatientResource {

    private final PatientService patientService;

    public PatientResource(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/records")
    public PatientRecordDTO save(@RequestBody PatientRecord patientRecord){

        PatientRecordDTO savedPatientRecord = patientService.save(patientRecord);

        return savedPatientRecord;
    }
}
