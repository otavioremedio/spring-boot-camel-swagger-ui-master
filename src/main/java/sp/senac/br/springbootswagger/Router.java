package sp.senac.br.springbootswagger;

import static org.apache.camel.model.rest.RestParamType.path;

import java.awt.List;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class Router extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        rest("/user").description("User rest service")
    	.consumes("application/json").produces("application/json")
        .get("/{id}").description("Find user by id").outType(List.class)
            .param().name("id").type(path).description("The id of the user to get").dataType("int").endParam()
            //.responseMessage().code(200).message("The user").endResponseMessage()
            .to("bean:funcionarioService?method=getUser(${header.id})");  
    }
}
