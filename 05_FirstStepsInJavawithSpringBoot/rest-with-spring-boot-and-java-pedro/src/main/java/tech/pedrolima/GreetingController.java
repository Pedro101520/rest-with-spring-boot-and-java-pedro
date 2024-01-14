package tech.pedrolima;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//RestController  indica que esta classe é responsável por manipular solicitações HTTP e retornar respostas.
@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s! ";
	//Aqui é o contador
	private final AtomicLong counter = new AtomicLong();
	
	// indica que este método será chamado quando uma solicitação for feita para a rota (endpoint) "/greeting".
	//O /greeting retorna em um JSON as informações
	@RequestMapping("/greeting")
	public Greeting greeting(
			//Aqui é a parte do RESQUEST, que é informado no navegador, onde
			//para alterar a varivael name, tem que informar name na URL e depois
			//que o código é executado exibe o nome informado, caso não infromado imprime o nome padrão, world
			@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
