package br.com.fabiose.perfil.services;



/**
 * Created by fabioestrela on 07/10/16.
 */


import br.com.fabiose.perfil.models.PersonModel;
import br.com.fabiose.perfil.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonModel> getAll() {
        return this.personRepository.getAll();
    }

    public PersonModel findById(int id) {
        return this.personRepository.findById(id);
    }

    public PersonModel addPerson(PersonModel personModel){
        return this.personRepository.addPerson(personModel);
    }

    public PersonModel removePerson(PersonModel personModel){
        return this.personRepository.removePerson(personModel);
    }

    public PersonModel updatePerson(PersonModel personModel){
        return this.personRepository.updatePerson(personModel);
    }
}
