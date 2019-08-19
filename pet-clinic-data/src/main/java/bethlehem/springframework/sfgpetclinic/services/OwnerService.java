package bethlehem.springframework.sfgpetclinic.services;

import bethlehem.springframework.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);


}
