package hoegl.physikaufgabenGraph.controller;

import hoegl.physikaufgabenGraph.model.Parameter;
import hoegl.physikaufgabenGraph.service.ParameterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parameter")
public class ParameterResource {

    private final ParameterService parameterService;

    public ParameterResource(ParameterService parameterService){
        this.parameterService = parameterService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Parameter>> getAllParameters(){
       Iterable<Parameter> parameters = parameterService.findAllParameters();
       return new ResponseEntity<>(parameters, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Parameter> getParameterById(@PathVariable("id") String id){
        Parameter parameter = parameterService.findParameterById(id);
        return new ResponseEntity<>(parameter, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Parameter> addParameter(@RequestBody Parameter parameter){
        Parameter newParameter = parameterService.addParameter(parameter);
        return new ResponseEntity<>(newParameter, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Parameter> updateParameter(@RequestBody Parameter parameter){
        Parameter updatedParameter = parameterService.updateParameter(parameter);
        return new ResponseEntity<>(updatedParameter, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteParameter(@PathVariable("id") String id){
        parameterService.deleteParameter(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
