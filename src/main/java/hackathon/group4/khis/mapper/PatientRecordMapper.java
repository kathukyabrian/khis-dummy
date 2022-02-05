package hackathon.group4.khis.mapper;

import hackathon.group4.khis.domain.PatientRecord;
import hackathon.group4.khis.dto.PatientRecordDTO;
import org.springframework.stereotype.Service;

@Service
public class PatientRecordMapper {

    public PatientRecordDTO toDTO(PatientRecord patientRecord, String identifier){

        PatientRecordDTO patientRecordDTO = new PatientRecordDTO();
        patientRecordDTO.setPatientId(patientRecord.getPatientId());
        patientRecordDTO.setPatientName(patientRecord.getPatientName());
        patientRecordDTO.setDisease(patientRecord.getDisease());
        patientRecordDTO.setRegion(patientRecord.getRegion());
        patientRecordDTO.setHospitalId(patientRecord.getHospitalId());
        patientRecordDTO.setHospitalName(patientRecord.getHospitalName());
        patientRecordDTO.setIdentifier(identifier);

        return patientRecordDTO;
    }
}
