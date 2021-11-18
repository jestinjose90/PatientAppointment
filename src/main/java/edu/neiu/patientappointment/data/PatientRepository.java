package edu.neiu.patientappointment.data;

import edu.neiu.patientappointment.models.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
