package hoegl.physikaufgabenGraph.runner;

import com.arangodb.springframework.core.ArangoOperations;
import hoegl.physikaufgabenGraph.model.Parameter;
import hoegl.physikaufgabenGraph.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

import java.util.Optional;

@ComponentScan("hoegl.physikaufgabenGraph")
public class ParameterRunner implements CommandLineRunner {

    @Autowired
    private ArangoOperations operations;

    @Autowired
    private ParameterRepository repository;

    @Override
    public void run(String... args) throws Exception {

       // operations.dropDatabase();

        final Parameter masse = new Parameter("t", "Zeit", "s");

        repository.save(masse);

        System.out.println("Parameter " + masse.getBezeichner() + " gespeichert.");

        final Optional<Parameter> foundMasse = repository.findById(masse.getBezeichnungID());

        assert foundMasse.isPresent();

        System.out.println(String.format("%s gefunden.", foundMasse.get()));
    }
}
