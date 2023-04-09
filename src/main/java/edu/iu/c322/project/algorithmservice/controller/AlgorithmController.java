package edu.iu.c322.project.algorithmservice.controller;

import edu.iu.c322.project.algorithmservice.repository.AlgorithmRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/algorithm")
public class AlgorithmController {

    private AlgorithmRepository repository;

    public AlgorithmController (AlgorithmRepository repository){
        this.repository = repository;
    }



}
