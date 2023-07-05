package core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Service.AnimalService;
import core.models.Animal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/animal")
public class AnimalController {
    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping (value = "/list")
    public List<Animal> getList(@RequestParam int length) throws JsonProcessingException {
        return service.getAnimalListByLength(length);
    }
    @GetMapping (value = "/create")
    public Animal getJson(@RequestParam String type, String name, int age) throws JsonProcessingException {
        return service.getAnimalJson(type, name, age);
    }
}