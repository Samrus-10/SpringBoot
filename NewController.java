package sam.rus.optionSpringBoot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.rus.springMvc.model.Time;
import sam.rus.optionSpringBoot.model.dto.BodyDto;
import sam.rus.optionSpringBoot.model.dto.MessageDTO;
import sam.rus.optionSpringBoot.model.dto.NameDTO;
import sam.rus.optionSpringBoot.myService.TestBugService;
import sam.rus.optionSpringBoot.myService.ValidService;
import sam.rus.optionSpringBoot.repository.CarRepository;
import sam.rus.springMvc.repository.TimeRepository;

import java.time.Instant;

@RestController
@RequestMapping("/home")
@AllArgsConstructor
public class NewController {

    private ValidService service;
    private TestBugService serviceTest;
    private CarRepository carRepository;
    private TimeRepository timeRepository;

    @GetMapping("/1")
    public ResponseEntity<String> getHomeName(@RequestParam String name) {
        return ResponseEntity.ok(
                name
        );
    }

    @GetMapping("/house")
    public ResponseEntity<String> some(@RequestParam String name) {
        return ResponseEntity.ok(
                name
        );
    }

    @PostMapping
    public ResponseEntity<MessageDTO> getMessage(@RequestBody BodyDto bodyDto) {
        service.valid(bodyDto.getNumber());
        return ResponseEntity.ok(MessageDTO.builder().massage("all good.").build());
    }


    @PutMapping("/test")
    public ResponseEntity<MessageDTO> getTestBug(@RequestBody NameDTO name) {
        serviceTest.createdElementInBD(name);
        return ResponseEntity.ok(MessageDTO.builder().massage("Test did good").build());
    }

//    @ExceptionHandler(MyExec.class)
//    public ResponseEntity<MessageDTO> handlerExeption(MyExec exception) {
//        System.out.println("============================In Handler============================");
//        return ResponseEntity
//                .status(exception.getCode())
//                .body(MessageDTO.builder().massage(exception.getMessage()).build());
//    }


}
