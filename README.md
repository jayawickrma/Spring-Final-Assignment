

---

# Spring Assignment Phase-02 Project <br>

# Point of Sale Backend with Spring



## Overview
The **Point of Sale (POS) Backend** is a high-performance RESTful API tailored for retail environments, specifically designed to streamline operations in grocery stores.

Developed using Spring Boot and MySQL, this backend solution ensures seamless customer, product, order, and inventory management.

## Key Features
- **Item Management:** Create, update, retrieve, and delete items in the store's inventory.
- **Customer Management:** Full CRUD operations for managing customer profiles.
- **Order Management:** Place and manage customer orders, handle discounts, calculate subtotals, and track balances.
- **Transactions:** Ensures data integrity with complex transactional operations during order processing.

## Technologies Used
- **Backend Framework:** Spring Boot with Jakarta EE integration
- **Database:** MySQL
- **Build Tool:** Maven
- **Containerization:** Tomcat 11
- **Java Version:** 21

## Prerequisites
- **Java 17 or higher**
- **Maven 3.6+**
- **MySQL 8.0+**

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributing
Contributions are welcome! Please see the [CONTRIBUTING](CONTRIBUTING) file for guidelines.


### Dependencies Used:
1. **jakarta.servlet-api**
2. **spring-webmvc**
3. **junit-jupiter-api**
4. **junit-jupiter-engine**
5. **lombok**
6. **hibernate-core**
7. **spring-data-jpa**
8. **mysql-connector-java**
9. **jackson-databind**
10. **slf4j-api**
11. **logback-classic**
12. **modelmapper**

### Spring Concepts and Annotations Used:
1. **@Bean** – Defines an object managed by Spring.
2. **@Service** – Applied to all service classes to denote a service layer component.
3. **@ComponentScan** – Scans for `@Bean` objects in a package-wise or class-wise manner.
4. **@Configuration** – Marks the class as a Spring configuration class.
5. **@RestController** – Enables the class to handle HTTP requests and responses, similar to a servlet.
6. **@EnableWebMvc** – Enables all Spring Web features for this project.
7. **@MultipartConfig** – Allows handling of file uploads, including images.
8. **@EnableJpaRepositories** – Enables JPA repositories for the project.
9. **@EnableTransactionManagement** – Enables transaction management.
10. **@RequestMapping** – Maps incoming URLs to corresponding methods.
11. **@GetMapping** – Retrieves data from the database.
12. **@PostMapping** – Saves new data to the database.
13. **@PutMapping / @PatchMapping** – Updates existing data.
14. **@DeleteMapping** – Deletes data.
15. **@Autowired** – Automatically injects dependencies into Spring-managed components.
16. **@RequestPath** –in Spring is used to map HTTP requests to specific handler methods in controller classes.
17. **@Multipart** -there are many request parts.
18. **@Repository** -Spring will manage this class.this class must be dao layer.
19. **@Transactional** -transaction will manage by this annottion.

---


