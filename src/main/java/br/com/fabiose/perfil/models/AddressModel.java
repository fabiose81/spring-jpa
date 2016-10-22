package br.com.fabiose.perfil.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by fabioestrela on 07/10/16.
 */


@Entity
@Table(name = "address")
public class AddressModel implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_address", sequenceName = "address_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_address")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "number")
    private Integer number;

    @Column(name = "zipcode")
    private Integer zipcode;

    @Column(name = "more_information")
    private String moreInformation;

    @JsonIgnore
    @JoinColumn(name = "id_person")
    @ManyToOne
    private PersonModel personModel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getMoreInformation() {
        return moreInformation;
    }

    public void setMoreInformation(String moreInformation) {
        this.moreInformation = moreInformation;
    }

    public PersonModel getPersonModel() {
        return personModel;
    }

    public void setPersonModel(PersonModel personModel) {
        this.personModel = personModel;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", description=" + description
                + ", number=" + number + ", zipcode="
                + zipcode + ", more_information=" + moreInformation + "]";
    }
}
