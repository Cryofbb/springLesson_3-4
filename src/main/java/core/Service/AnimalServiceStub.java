package core.Service;

import com.github.javafaker.Faker;
import core.models.Animal;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalServiceStub implements AnimalService{
    Faker faker = new Faker();

    @Override
    public List<Animal> getAnimalListByLength(int leng) {
        List<Animal> animalList = new ArrayList<>();
        for (int i = 0; i < leng; i++) {
            Animal animal = new Animal(faker.animal().name(), faker.pokemon().name(), faker.number().numberBetween(1,100));
            animalList.add(animal);
        }
        return animalList;
    }
    @Override
    public Animal getAnimalJson(String type, String name, int age){
        return new Animal(type, name, age);
    }
}
