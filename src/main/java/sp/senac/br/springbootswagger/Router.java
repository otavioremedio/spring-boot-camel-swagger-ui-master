package sp.senac.br.springbootswagger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

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
//        log("${header.Authorization}").
//    	process(new Processor() {
//			@Override
//			public void process(Exchange exchange) throws Exception {
//				exchange.setProperty("token", (exchange.getIn().getHeader("Authorization")));
//			}
//		}).
        
        rest("/admti").
        	consumes("application/json").produces("application/json").
        	get("/user").
            to("direct:admti");
        
        from("direct:admti").
        	removeHeaders("CamelHttp*").
        	setBody(constant("{\"username\":\"colex\",\"senha\":\"_@HRL&L3tF?Z7ccj4z&L5!nU2B!Rjs3_\"}")).       
        to("http4://admti-service.cloud.sp.senac.br/admti/login").
        	setHeader("Authorization", simple("${header.Authorization}")).
        	setHeader(Exchange.HTTP_QUERY, simple("sistema=448&username=otavio.remedio")).
        to("http4://admti-service.cloud.sp.senac.br/admti/api/usuario")
	       .process(new Processor() {
	    	@Override
	    	public void process(Exchange exchange) throws Exception {
	    		String usuario = exchange.getIn().getBody(String.class);
	    		UsuarioDto contact = new ObjectMapper().readValue(usuario, UsuarioDto.class);
	    		System.out.println(usuario);
	    		System.out.println(contact.getSistemasPerfis());
	    		exchange.getOut().setBody(contact);
	    	}
	    });    	
    }
}


//process(new Processor() {
//	@Override
//	public void process(Exchange exchange) throws Exception {
//		UsuarioDto usuario = exchange.getIn().getBody(UsuarioDto.class);
//		System.out.println(usuario.getCodUnidade());
//	}
//});