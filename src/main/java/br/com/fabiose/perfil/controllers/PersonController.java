package br.com.fabiose.perfil.controllers;

/**
 * Created by fabioestrela on 07/10/16.
 */


import br.com.fabiose.perfil.models.PersonModel;
import br.com.fabiose.perfil.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonService personService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public List<PersonModel> getAll(){
        return this.personService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public PersonModel getById(@PathVariable("id")int id){
        return this.personService.getById(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonModel addPerson(@RequestBody PersonModel personModel){
       return this.personService.addPerson(personModel);
    }

    @CrossOrigin
    @RequestMapping(value = "/remove", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonModel removePerson(@RequestBody PersonModel personModel){
        return this.personService.removePerson(personModel);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonModel updatePerson(@RequestBody PersonModel personModel){
        return this.personService.updatePerson(personModel);
    }
}
