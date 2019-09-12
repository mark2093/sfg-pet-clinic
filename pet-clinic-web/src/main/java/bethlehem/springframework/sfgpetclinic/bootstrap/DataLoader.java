package bethlehem.springframework.sfgpetclinic.bootstrap;

import bethlehem.springframework.sfgpetclinic.model.Owner;
import bethlehem.springframework.sfgpetclinic.model.Vet;
import bethlehem.springframework.sfgpetclinic.services.OwnerService;
import bethlehem.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("David");
        owner1.setLastName("Dsouza");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Sarah");
        owner2.setLastName("Dsouza");

        ownerService.save(owner2);

        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
        vet1.setFirstName("Gale");
        vet1.setLastName("Jackson");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bobby");
        vet2.setLastName("Harry");

        vetService.save(vet2);

        System.out.println("Vets Owners......");


    }
}