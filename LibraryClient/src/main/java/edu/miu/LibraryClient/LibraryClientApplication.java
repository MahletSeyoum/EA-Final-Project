package edu.miu.LibraryClient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LibraryClientApplication implements CommandLineRunner {

	RestTemplate restTemplate = new RestTemplate();

	String url1 = "http://localhost:8081/customers";
	String url2 = "http://localhost:8081/loans";

	public static void main(String[] args) {
		SpringApplication.run(LibraryClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CustomerList customerList = restTemplate.getForObject(url1, CustomerList.class);
		System.out.println(customerList);
	}
}
