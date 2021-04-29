package hoegl.physikaufgabenGraph.service;

import hoegl.physikaufgabenGraph.model.Parameter;
import hoegl.physikaufgabenGraph.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ParameterService {

    private final ParameterRepository paraRepository;

    @Autowired
    public ParameterService(ParameterRepository paraRepository) {
        this.paraRepository = paraRepository;
    }

    public Parameter addParameter(Parameter parameter){
        return paraRepository.save(parameter);
    }

    public List<Parameter> findAllParameters(){
        return (List<Parameter>) paraRepository.findAll();
    }

    public Parameter findParameterById(String id){
        return paraRepository.findById(id)
                .orElseThrow(() -> new ParameterNotFoundException("Parameter with id " +id + " was not found."));
    }

    public Parameter updateParameter(Parameter parameter){
        return paraRepository.save(parameter);
    }

    public void deleteParameter(String id){
        paraRepository.deleteById(id);
    }


    private class ParameterNotFoundException extends RuntimeException {
        public ParameterNotFoundException(String message) {
            super(message);
        }
    }
}
