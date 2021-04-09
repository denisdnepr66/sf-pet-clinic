package guru.springframework.sfpetclinic.repositories;

import guru.springframework.sfpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
