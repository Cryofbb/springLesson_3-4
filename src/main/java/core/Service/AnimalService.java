package core.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.models.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> getAnimalListByLength(int leng) throws JsonProcessingException;
    Animal getAnimalJson(String type, String name, int age) throws JsonProcessingException;
}
