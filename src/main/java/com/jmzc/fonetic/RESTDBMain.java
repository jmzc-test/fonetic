package com.jmzc.fonetic;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/*
@EnableAutoConfiguration
@ComponentScan
@Configuration
*/

/*
 * @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan
 */
@SpringBootApplication
public class RESTDBMain
{
	
	
    static public void main(String[] args) 
    {
        SpringApplication.run(RESTDBMain.class, args);
    }
}