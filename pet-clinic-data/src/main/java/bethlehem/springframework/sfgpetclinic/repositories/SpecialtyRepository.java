package bethlehem.springframework.sfgpetclinic.repositories;

import bethlehem.springframework.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository  extends CrudRepository<Speciality, Long> {
}
