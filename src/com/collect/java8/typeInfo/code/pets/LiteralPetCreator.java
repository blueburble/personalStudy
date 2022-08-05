package com.collect.java8.typeInfo.code.pets;

import com.collect.java8.typeInfo.code.PetCreator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator {
    public static final List<Class<? extends Pet>> ALL_TYPES =
         Collections.unmodifiableList(Arrays.asList(
          Pet.class, Dog.class, Cat.class, Rodent.class,
         Mutt.class, Pug.class, EgyptianMau.class,
             Manx.class, Cymric.class, Rat.class,
           Mouse.class, Hamster.class));

    private static final List<Class<? extends Pet>> Types = ALL_TYPES.subList(ALL_TYPES.indexOf(Mutt.class), ALL_TYPES.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return Types;
    }
}
