package bethlehem.springframework.sfgpetclinic.repositories;

import bethlehem.springframework.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
