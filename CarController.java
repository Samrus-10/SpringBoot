package sam.rus.optionSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sam.rus.optionSpringBoot.model.Car;
import sam.rus.optionSpringBoot.model.Person;
import sam.rus.optionSpringBoot.repository.CarRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarRepository carRepository;
    private List<String> list = Arrays.asList("one", "two", "three", "four", "five");

    @GetMapping
    public ResponseEntity<List<String>> getCars() {
        List<String> resultListCar = Arrays.asList("Bmv", "Merc", "Wolf");

        return ResponseEntity.ok(
                resultListCar
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getCar(@PathVariable long id) {
        return  ResponseEntity.ok(
                list.get((int)id)
        );
    }

    @GetMapping("/dog")
    public ResponseEntity<List<String>> getDogs() {
        String name = "sam";
        return ResponseEntity.ok(Arrays.asList("Yrik", "Vova", "Dogi", "Mura", "Leo"));
    }

    @GetMapping("/empty")
    @ResponseStatus(value = HttpStatus.OK)
    public void empty() {
    }

    @PostMapping
    public ResponseEntity<String> person(@Valid @RequestBody Person person) {
        System.out.println(person);
        return ResponseEntity.ok(person.toString());
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public void handlerExeption(Exception exception) {
        System.out.println("============================In Handler============================");
        System.out.printf("exception: %s%n \n", exception.getMessage());
    }

}