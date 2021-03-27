package guru.springframework.sfpetclinic.bootstrap;

import guru.springframework.sfpetclinic.model.model.Owner;
import guru.springframework.sfpetclinic.model.model.Vet;
import guru.springframework.sfpetclinic.model.services.OwnerService;
import guru.springframework.sfpetclinic.model.services.VetService;
import guru.springframework.sfpetclinic.model.services.map.OwnerServiceMap;
import guru.springframework.sfpetclinic.model.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Denys");
        owner1.setLastName("Shyshliannykov");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(1L);
        owner2.setFirstName("Oleg");
        owner2.setLastName("Ivanov");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Bob");
        vet1.setLastName("Smith");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Alan");
        vet2.setLastName("Robs");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
