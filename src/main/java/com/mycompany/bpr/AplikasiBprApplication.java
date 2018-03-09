/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bpr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author bubun
 */
@SpringBootApplication
@EnableTransactionManagement
public class AplikasiBprApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplikasiBprApplication.class, args);
	}
}
