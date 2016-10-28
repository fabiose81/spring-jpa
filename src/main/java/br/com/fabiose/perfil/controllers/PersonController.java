package br.com.fabiose.perfil.controllers;

/**
 * Created by fabioestrela on 07/10/16.
 */


import br.com.fabiose.perfil.models.PersonModel;
import br.com.fabiose.perfil.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonService personService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll(){
        try{
            return ResponseEntity.ok(this.personService.getAll());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable("id")int id){
        try{
            return ResponseEntity.ok(this.personService.findById(id));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addPerson(@RequestBody PersonModel personModel){
        try{
            return ResponseEntity.ok(this.personService.addPerson(personModel));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/remove", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity removePerson(@RequestBody PersonModel personModel){
        try{
            return ResponseEntity.ok(this.personService.removePerson(personModel));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updatePerson(@RequestBody PersonModel personModel){
        try{
            return ResponseEntity.ok(this.personService.updatePerson(personModel));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
