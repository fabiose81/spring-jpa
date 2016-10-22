package br.com.fabiose.perfil.enums;

/**
 * Created by fabioestrela on 07/10/16.
 */
public enum SexEnum {

    M("Masculino"), F("Feminino");

    private final String sex;

    SexEnum(String sex){
       this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
