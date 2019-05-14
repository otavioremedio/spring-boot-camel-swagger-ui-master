package sp.senac.br.springbootswagger;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
	
	private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
     
    @Bean
    public DataSource getDataSource() {
    	config.setJdbcUrl( "jdbc:oracle:thin:@//10.9.0.30:1532/hrhev" );
        config.setUsername( "rhcolex" );
        config.setPassword( "rhcolex" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
        
        return ds;
    }
}