package group.lab1FINAL;

import group.lab1FINAL.Model.Employee;
import group.lab1FINAL.Model.Restaurant;
import group.lab1FINAL.Model.RestaurantEmployee;
import group.lab1FINAL.Model.Review;
import group.lab1FINAL.Repo.EmployeeRepo;
import group.lab1FINAL.Repo.ReviewRepo;
import group.lab1FINAL.Repo.RestaurantRepo;
import group.lab1FINAL.Repo.RestaurantEmployeeRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Lab1FinalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Lab1FinalApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("http://localhost:8080");
//			}
//		};
//	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

	@Autowired
	private EmployeeRepo repo;
	@Autowired
	private ReviewRepo repo2;

	@Autowired
	private RestaurantRepo repo3;

	@Autowired
	private RestaurantEmployeeRepo repo4;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {


		Employee employee1 = new Employee("20",3400,"Adrian","McDonalds",false);
		Employee employee2 = new Employee("22",2500,"Alin","Gym nocal food!",false);
		Employee employee3 = new Employee("18",2900,"Rafa","Some basement foodinc",false);
		Employee employee4 = new Employee("18",2600,"Mana","Hospital",false);
		Employee employee5 = new Employee("21",3500,"Iannis","McDonalds",false);
		Employee employee6 = new Employee("20",6400,"Dani","Denmark legoland",false);
		Employee employee7 = new Employee("18",3100,"Maricica","McDonalds",false);
		Employee employee8 = new Employee("18",2900,"Aioanei","McDonalds",false);
		Employee employee9 = new Employee("20",4500,"Varga","Corporate scam restaurant",false);
		Employee employee10 = new Employee("21",5000,"Barbosa","Pirate bay",false);

		repo.save(employee1);
		repo.save(employee2);
		repo.save(employee3);
		repo.save(employee4);
		repo.save(employee5);
		repo.save(employee6);
		repo.save(employee7);
		repo.save(employee8);
		repo.save(employee9);
		repo.save(employee10);

		Review rev1 = new Review("adrian","adrianadrian", 6.9f,"8.11.2002",false,employee1);
		Review rev2 = new Review("alin","alinalin", 6.9f,"8.12.2012",false,employee2);
		Review rev3 = new Review("rafa","rafarafa", 9.5f,"5.3.2012",true,employee3);
		Review rev4 = new Review("Morello","rece", 5.3f,"4.5.2015",false,employee1);
		Review rev5 = new Review("Istvan","nu stie sa comunice", 3.9f,"8.12.2002",false,employee1);
		Review rev6 = new Review("Vorg","mi-a adus kfc", 2.4f,"6.12.2013",false,employee1);
		Review rev7 = new Review("Varg","vargvarg", 8.9f,"8.11.2002",true,employee9);
		Review rev8 = new Review("harbuz","Se descurca", 9.9f,"19.2.2023",true,employee5);
		Review rev9 = new Review("Varagas","se misca repede", 9.4f,"26.12.2022",true,employee9);
		Review rev10 = new Review("Ale","e amabil", 10.0f,"8.11.2022",true,employee6);
		repo2.save(rev1);
		repo2.save(rev2);
		repo2.save(rev3);
		repo2.save(rev4);
		repo2.save(rev5);
		repo2.save(rev6);
		repo2.save(rev7);
		repo2.save(rev8);
		repo2.save(rev9);
		repo2.save(rev10);

		Restaurant res1 = new Restaurant("McDonalds", "Fast af",6.9f, "12.6.1998","Cluj");
		Restaurant res2 = new Restaurant("Gym nocal food!", "Proteins",7.2f, "15.8.2018","Cluj");
		Restaurant res3 = new Restaurant("Some basement foodinc", "Drive thru",5.5f, "12.6.1998","Cluj");
		Restaurant res4 = new Restaurant("Hospital", "If its bad, we'll treat you",2.1f, "12.6.1998","Suceava");
		Restaurant res5 = new Restaurant("Irish", "OChick",8.1f, "12.6.1998","Cluj");
		Restaurant res6 = new Restaurant("Denmark legoland", "Better than legos",9.9f, "12.6.1968","Odense");
		Restaurant res7 = new Restaurant("Rosa", "Food coma",10.0f, "1.12.1928","Cluj");
		Restaurant res8 = new Restaurant("Mexican truck", "America express continua",8.2f, "12.6.2002","Mexico city");
		Restaurant res9 = new Restaurant("Corporate scam restaurant", "Dont look at the price",9.5f, "12.6.2022","Cluj");
		Restaurant res10 = new Restaurant("Pirate bay", "Plunder the booty",7.6f, "12.6.2009","Cluj");

		repo3.save(res1);
		repo3.save(res2);
		repo3.save(res3);
		repo3.save(res4);
		repo3.save(res5);
		repo3.save(res6);
		repo3.save(res7);
		repo3.save(res8);
		repo3.save(res9);
		repo3.save(res10);


		RestaurantEmployee re1 = new RestaurantEmployee(0,"Mihai",8,false,false,employee1,res1);
		RestaurantEmployee re2 = new RestaurantEmployee(1,"Ibric",12,false,false,employee2,res2);
		RestaurantEmployee re3 = new RestaurantEmployee(25,"Domnisoara Cristina",22,false,false,employee3,res3);
		RestaurantEmployee re4 = new RestaurantEmployee(0,"Dan Varga",12,false,false,employee4,res4);
		RestaurantEmployee re5 = new RestaurantEmployee(2,"Jannibal Legonardus",7,true,false,employee6,res6);
		RestaurantEmployee re6 = new RestaurantEmployee(0,"Jeff Bezos",12,false,false,employee9,res9);
		RestaurantEmployee re7 = new RestaurantEmployee(1,"Sabina of Black Pearl",12,false,false,employee10,res10);
		RestaurantEmployee re8 = new RestaurantEmployee(1,"Mihai",6,true,true,employee5,res1);
		RestaurantEmployee re9 = new RestaurantEmployee(7,"Mihai",10,false,true,employee7,res1);
		RestaurantEmployee re10 = new RestaurantEmployee(5,"Mihai",4,true,false,employee8,res1);

		repo4.save(re1);
		repo4.save(re2);
		repo4.save(re3);
		repo4.save(re4);
		repo4.save(re5);
		repo4.save(re6);
		repo4.save(re7);
		repo4.save(re8);
		repo4.save(re9);
		repo4.save(re10);




	}
}
