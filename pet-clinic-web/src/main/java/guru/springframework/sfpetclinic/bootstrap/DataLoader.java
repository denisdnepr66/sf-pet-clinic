package guru.springframework.sfpetclinic.bootstrap;

import guru.springframework.sfpetclinic.model.*;
import guru.springframework.sfpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);


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

        Visit catVisit = new Visit();
        catVisit.setPet(olegsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Bob");
        vet1.setLastName("Smith");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alan");
        vet2.setLastName("Robs");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
