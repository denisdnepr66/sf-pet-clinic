package guru.springframework.sfpetclinic.bootstrap;

import guru.springframework.sfpetclinic.model.Owner;
import guru.springframework.sfpetclinic.model.Pet;
import guru.springframework.sfpetclinic.model.PetType;
import guru.springframework.sfpetclinic.model.Vet;
import guru.springframework.sfpetclinic.services.OwnerService;
import guru.springframework.sfpetclinic.services.PetTypeService;
import guru.springframework.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Denys");
        owner1.setLastName("Shyshliannykov");
        owner1.setAddress("321 Some Street");
        owner1.setCity("Warsaw");
        owner1.setTelephone("48235746190");

        Pet denyssPet = new Pet();
        denyssPet.setPetType(savedDogPetType);
        denyssPet.setOwner(owner1);
        denyssPet.setBirthDate(LocalDate.now());
        denyssPet.setName("Rosco");
        owner1.getPets().add(denyssPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Oleg");
        owner2.setLastName("Ivanov");
        owner2.setAddress("321 Some Street");
        owner2.setCity("Warsaw");
        owner2.setTelephone("48235746590");

        Pet olegsPet = new Pet();
        olegsPet.setPetType(savedCatPetType);
        olegsPet.setOwner(owner2);
        olegsPet.setBirthDate(LocalDate.now());
        olegsPet.setName("Meow");
        owner2.getPets().add(olegsPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Bob");
        vet1.setLastName("Smith");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alan");
        vet2.setLastName("Robs");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
