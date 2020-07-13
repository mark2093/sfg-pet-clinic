package bethlehem.springframework.sfgpetclinic.repositories;

import bethlehem.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
