package guru.springframework.sfpetclinic.model.services;

import org.springframework.data.annotation.Id;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(Id id);

    T save(T object);

    void delete(T object);

    void deleteById(Id id);

}
