package bethlehem.springframework.sfgpetclinic.services.map;

import bethlehem.springframework.sfgpetclinic.model.Speciality;
import bethlehem.springframework.sfgpetclinic.model.Vet;
import bethlehem.springframework.sfgpetclinic.services.SpecialityServices;
import bethlehem.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityServices specialityServices;

    public VetServiceMap(SpecialityServices specialityServices) {
        this.specialityServices = specialityServices;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialties().size() > 0) {
            object.getSpecialties().forEach(speciality -> {
                if (speciality.getId() == 0) {
                    Speciality savedSpeciality = specialityServices.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }
}
