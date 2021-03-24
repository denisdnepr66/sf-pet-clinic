package guru.springframework.sfpetclinic.model.services;

import guru.springframework.sfpetclinic.model.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName();

}
