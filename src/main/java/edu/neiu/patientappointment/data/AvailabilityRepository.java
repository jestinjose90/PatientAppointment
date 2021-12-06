package edu.neiu.patientappointment.data;

import edu.neiu.patientappointment.models.Availability;
import org.springframework.data.repository.CrudRepository;

public interface AvailabilityRepository extends CrudRepository<Availability,Long> {
}
