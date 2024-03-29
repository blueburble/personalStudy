package com.collect.java8.annotation.code;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.lang.annotation.ElementType;
import java.util.Set;

public class SimpleProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for(TypeElement t : annotations){
            System.out.println(t);
        }
        for(Element el : roundEnv.getElementsAnnotatedWith(Simple.class)){
            display(el);
        }

        return false;
    }

    private void display(Element el){
        System.out.println("=====" + el + "======");
        System.out.println(el.getKind() + ":" + el.getModifiers() + ":" + el.getSimpleName() + ":" + el.asType());
        if(el.getKind().equals(ElementKind.CLASS)){
            TypeElement te = (TypeElement) el;
            System.out.println(te.getQualifiedName());
            System.out.println(te.getSuperclass());
            System.out.println(te.getEnclosedElements());
        }
    }
}
