package hackathon.group4.khis.dto;

import lombok.Data;

@Data
public class PatientRecordDTO {
    private Long patientId;

    private String patientName;

    private String region;

    private String disease;

    private Long hospitalId;

    private String hospitalName;

    private String identifier;
}
