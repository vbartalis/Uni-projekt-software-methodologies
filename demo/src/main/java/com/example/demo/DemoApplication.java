package com.example.demo;

import com.example.demo.controller.ItemController;
import com.example.demo.controller.QuestController;
import com.example.demo.database.DatabaseHandler;
import com.sun.faces.config.ConfigureListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.faces.webapp.FacesServlet;
import javax.servlet.Servlet;
import javax.xml.crypto.Data;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ItemController.setItems(DatabaseHandler.getAllItemsFromDatabase());
		QuestController.setQuests(DatabaseHandler.getAllQuestsFromDatabase());

		SpringApplication.run(DemoApplication.class, args);
	}

	/*
	 * Below sets up the Faces Servlet for Spring Boot
	 */
	@Bean
	public FacesServlet facesServlet() {
		return new FacesServlet();
	}

	@Bean
	public ServletRegistrationBean<Servlet> facesServletRegistration() {
		ServletRegistrationBean<Servlet> registration = new ServletRegistrationBean<Servlet>(facesServlet(), "*.jsf");
		return registration;
	}

	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
	}
}
