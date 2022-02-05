package hackathon.group4.khis.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_patients_records")
public class PatientRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private String patientName;

    private String region;

    private String disease;

    private Long hospitalId;

    private String hospitalName;

}
