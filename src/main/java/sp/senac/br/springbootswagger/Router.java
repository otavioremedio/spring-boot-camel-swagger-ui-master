package sp.senac.br.springbootswagger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class Router extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json)
        .dataFormatProperty("prettyPrint", "true")
        .contextPath("/api")
        .apiContextPath("/api-doc")
        .apiProperty("api.title", "User API").apiProperty("api.version", "1.0")
        .apiProperty("cors", "true");

//        rest("/user").description("User rest service")
//    	.consumes("application/json").produces("application/json")
//        .get("/{id}").description("Find user by id").outType(List.class)
//            .param().name("id").type(path).description("The id of the user to get").dataType("integer").endParam()
//            //.responseMessage().code(200).message("The user").endResponseMessage()
//            .to("bean:funcionarioService?method=getUser(${header.id})");
        
        
        from("timer://admti?fixedRate=true&delay=5s&period=10s").
        	setBody(constant("{\"username\":\"colex\",\"senha\":\"_@HRL&L3tF?Z7ccj4z&L5!nU2B!Rjs3_\"}")).        	
        to("http4://10.2.0.146:8480/admti/login").
        	process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					System.out.println(exchange.getIn().getHeader("Authorization"));
				}
			});        	
    }
}
