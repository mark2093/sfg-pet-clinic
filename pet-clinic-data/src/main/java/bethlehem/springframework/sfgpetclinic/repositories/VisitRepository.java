package bethlehem.springframework.sfgpetclinic.repositories;

import bethlehem.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository  extends CrudRepository<Visit, Long> {
}
