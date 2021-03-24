package guru.springframework.sfpetclinic.model.services;

import guru.springframework.sfpetclinic.model.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName();
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
