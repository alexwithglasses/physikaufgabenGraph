package hoegl.physikaufgabenGraph;

import hoegl.physikaufgabenGraph.runner.ParameterRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhysikaufgabenGraphApplication {

	public static void main(String[] args) {

		Class<?>[]runner = new Class<?>[]{ParameterRunner.class};
		System.exit(SpringApplication.exit(SpringApplication.run(runner, args)));
	}

}
