package edu.neiu.patientappointment.data;

import edu.neiu.patientappointment.models.Physician;
import org.springframework.data.repository.CrudRepository;

public interface PhysicianRepository extends CrudRepository<Physician,Long> {
}
