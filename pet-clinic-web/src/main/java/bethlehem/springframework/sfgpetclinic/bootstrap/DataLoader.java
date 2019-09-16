package bethlehem.springframework.sfgpetclinic.bootstrap;

import bethlehem.springframework.sfgpetclinic.model.*;
import bethlehem.springframework.sfgpetclinic.services.OwnerService;
import bethlehem.springframework.sfgpetclinic.services.PetTypeService;
import bethlehem.springframework.sfgpetclinic.services.SpecialityServices;
import bethlehem.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityServices specialityServices;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityServices specialityServices) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService=petTypeService;
        this.specialityServices = specialityServices;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology = specialityServices.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality saveSurgery = specialityServices.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveDentistry = specialityServices.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("David");
        owner1.setLastName("Dsouza");
        owner1.setAddress("Byculla");
        owner1.setCity("Bombay");
        owner1.setTelephone("8975791270");

        Pet davidsPet = new Pet();
        davidsPet.setPetType(saveDogPetType);
        davidsPet.setOwner(owner1);
        davidsPet.setBirthDate(LocalDate.now());
        davidsPet.setName("Solomon");
        owner1.getPets().add(davidsPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sarah");
        owner2.setLastName("Dsouza");
        owner2.setAddress("Nangargaon");
        owner2.setAddress("Lonavala");
        owner2.setTelephone("7588289056");

        Pet sarahsPet = new Pet();
        sarahsPet.setPetType(saveCatPetType);
        sarahsPet.setName("Gale");
        sarahsPet.setBirthDate(LocalDate.now());
        sarahsPet.setOwner(owner2);
        owner2.getPets().add(sarahsPet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Gale");
        vet1.setLastName("Jackson");
        vet1.getSpecialties().add(saveRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bobby");
        vet2.setLastName("Harry");
        vet2.getSpecialties().add(saveSurgery);
        vetService.save(vet2);

        System.out.println("Vets Owners......");
    }
}
