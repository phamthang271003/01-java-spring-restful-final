package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.service.error.IdInvaLidException;

@RestController
public class HelloController {

    @GetMapping("/")
    public String getHelloWorld() throws IdInvaLidException {
        if (true)
            throw new IdInvaLidException("Id is invalid");
        return "Hello World (Hỏi Dân IT & Eric)";
    }
}
