package edu.miu.BookCatalogClient;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookCatalogClientApplication implements CommandLineRunner {

	RestTemplate restTemplate = new RestTemplate();

	String url = "http://localhost:8080/books";

	public static void main(String[] args) {
		SpringApplication.run(BookCatalogClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BookList books = restTemplate.getForObject(url, BookList.class);
		System.out.println(books);
	}
}
