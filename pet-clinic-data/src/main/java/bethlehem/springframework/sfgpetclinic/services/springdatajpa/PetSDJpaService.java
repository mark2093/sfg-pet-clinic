package bethlehem.springframework.sfgpetclinic.services.springdatajpa;

import bethlehem.springframework.sfgpetclinic.model.Pet;
import bethlehem.springframework.sfgpetclinic.repositories.PetRepository;
import bethlehem.springframework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;

import java.util.HashSet;
import java.util.Set;

@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    public final PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets= new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
