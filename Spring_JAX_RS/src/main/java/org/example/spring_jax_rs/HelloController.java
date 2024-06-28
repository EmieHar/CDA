package org.example.spring_jax_rs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/hello/{name}")
    public String sayHelloToName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/data")
    public ArrayList<DomainBean> get() {

        ArrayList<DomainBean> arr = new ArrayList<>();

        DomainBean userOne = new DomainBean();
        userOne.setId("1");
        userOne.setName("Joni");
        userOne.setData("ldsp f sefsf ");

        DomainBean userTwo = new DomainBean();
        userTwo.setId("2");
        userTwo.setName("toto");
        userTwo.setData("time rgpergke");

        arr.add(userOne);
        arr.add(userTwo);

        return arr;
    }
}
