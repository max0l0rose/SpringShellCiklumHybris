package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.persistence.EntityManager;

public class Main {

    @Autowired
    private EntityManager entityManager;

    public static void main(String[] args) {
        System.out.println("1");
        SpringApplication.run(Main.class, args);
        System.out.println("2");
    }
}





@ShellComponent
class AppCommand1
        //extends SecuredCommand
{

    //@CliCommand(value = {"comA", "ca"})
    @ShellMethod(key = {"commanda", "ca"}, value = "commandA descript...")
    public String commandA(
            //@CliOption(key = "p1") String p1
            @ShellOption(arity = 3, defaultValue = "deffffff")
                    String text,
            @ShellOption(defaultValue = "Text2")
                    String text2
    ) {
        return text + text2;
    }

}
