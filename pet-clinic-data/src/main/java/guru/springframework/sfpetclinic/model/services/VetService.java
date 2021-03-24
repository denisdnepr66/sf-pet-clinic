package guru.springframework.sfpetclinic.model.services;

import guru.springframework.sfpetclinic.model.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet Vet);
    Set<Vet> findAll();
}
