package hoegl.physikaufgabenGraph.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import hoegl.physikaufgabenGraph.model.Parameter;

public interface ParameterRepository extends ArangoRepository<Parameter, String> {

    

}
