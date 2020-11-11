package com.nbsteam11.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*******
 * <p>
 * Title: NBSTeam11 Class.
 * </p>
 * 
 * <p>
 * Description: This is the entry point of the web based application which runs
 * on start.
 * </p>
 *
 * @author Keshav Sharma and Puneet Garg
 * 
 * @version 1.00 2019-11-05
 * 
 */

@SpringBootApplication
@ComponentScan("com.nbsteam11")
public class NBSTeam11 {

	public static void main(String[] args) {
		SpringApplication.run(NBSTeam11.class, args);
	}

}
