package br.com.fabiose.perfil.models;

import br.com.fabiose.perfil.enums.SexEnum;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Cascade;
/**
 * Created by fabioestrela on 07/10/16.
 */


@Entity
@Table(name = "person")
public class PersonModel implements Serializable{

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private SexEnum sex;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "personModel",  cascade={CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
            org.hibernate.annotations.CascadeType.DELETE,
            org.hibernate.annotations.CascadeType.MERGE,
            org.hibernate.annotations.CascadeType.PERSIST,
            org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private Set<AddressModel> addressModels = new HashSet<AddressModel>(0);


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Set<AddressModel> getAddressModels() {
        return addressModels;
    }

    public void setAddressModels(Set<AddressModel> addressModels) {
        this.addressModels = addressModels;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name
                + ", age=" + age + ", sex="
                + sex + "]";
    }
}
