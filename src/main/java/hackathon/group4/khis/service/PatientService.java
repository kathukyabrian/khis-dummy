package hackathon.group4.khis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hackathon.group4.khis.domain.PatientRecord;
import hackathon.group4.khis.dto.PatientRecordDTO;
import hackathon.group4.khis.mapper.PatientRecordMapper;
import hackathon.group4.khis.repository.PatientRepository;
import hackathon.group4.khis.util.HttpUtil;
import lombok.extern.log4j.Log4j2;
import okhttp3.MediaType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Log4j2
@Service
public class PatientService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final PatientRepository patientRepository;

    private final PatientRecordMapper patientRecordMapper;

    public PatientService(PatientRepository patientRepository, PatientRecordMapper patientRecordMapper) {
        this.patientRepository = patientRepository;
        this.patientRecordMapper = patientRecordMapper;
    }

    // save 
    public PatientRecordDTO save(PatientRecord patientRecord){

        log.debug("Request to save patient record : {}",patientRecord);

        String identifier = UUID.randomUUID().toString();

        PatientRecord savedPatientRecord = patientRepository.save(patientRecord);

        PatientRecordDTO patientRecordDTO = patientRecordMapper.toDTO(savedPatientRecord, identifier);


        log.debug("About to forward to API");

        String url = "http://172.16.197.108:7609/api/gateway/record";

        String patientRecordStr = null;
        try {
            patientRecordStr = objectMapper.writeValueAsString(patientRecordDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String fromDATIMStr = "";
        try {
            fromDATIMStr = HttpUtil.post(url, patientRecordStr, MediaType.get("application/json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        PatientRecordDTO fromDATIM = null;
        try {
            fromDATIM = objectMapper.readValue(fromDATIMStr, PatientRecordDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return fromDATIM;
    }
}
