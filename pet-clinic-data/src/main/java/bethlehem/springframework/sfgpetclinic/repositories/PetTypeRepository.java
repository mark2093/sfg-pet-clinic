package bethlehem.springframework.sfgpetclinic.repositories;

import bethlehem.springframework.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
