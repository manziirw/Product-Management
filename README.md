# **Project Description: Product Management System**

Welcome to the Product Management System project, a comprehensive Spring Boot application designed to manage products, categories, and reviews effectively. This project showcases the integration of various Spring Boot features, such as RESTful APIs, data binding, pagination, sorting, and custom queries, all while maintaining robust error handling and logging mechanisms.

## Features

### 1.	Product Management

      o	Create, update, delete, and retrieve products.

      o	Search products by name, category, and price range.

      o	Paginate and sort product listings.

## 3.	Category Management

      o	Retrieve all categories.

      o	Associate products with categories (Many-to-One relationship).

## 4.	Review 

      o	Add reviews for products.

      o	Retrieve reviews by product (One-to-Many relationship).

## 5.	Custom Queries

      o	List products within a specific category.

      o	Fetch products priced above a certain threshold with pagination.

## 6.	API Response Handling

      o	Unified API response structure for success and error responses.

      o	Detailed messages and status codes for client interactions.

## 7.	Logging Interceptor

      o	Logs request details at key stages (pre-handle, post-handle, after-completion).

      o	Enhances monitoring, debugging, and auditing of request lifecycle.

# **Technologies Used**

      •	Spring Boot: Framework for building the application.

      •	Spring Data JPA: Data access and persistence.

      •	PostgreSQL: Relational database for data storage.

      •	Maven:Project management and build tool.

      •	Mognodb (NoSQL database):for storing unstructured data

## **How to Use**

### 1.	Clone the Repository:

      git clone https://github.com/manziirw/Product-Management.git

### 2.	Build the Project:

      mvn clean install

### 3.	Run the Application:

      mvn spring-boot:run

### 4.	Access the API:

      o	Use tools like Postman  to interact with the API endpoints.

      o	Example: Get all products with pagination:

      GET http://localhost:5000/api/products/all?page=0&size=5&sortBy=name

# API Endpoints:

      They are so many endpoints but let highlight some of them

### **o	Product Endpoints:**

      GET /api/products/all: Retrieve all products with pagination and sorting.

### **o	Category Endpoints:**

      	GET /api/categories/all: Retrieve all categories.

### **o	Review Endpoints:**

      	POST /api/products/reviews/add: Add a review for a product.

      	GET /api/products/reviews/{productId}: Get reviews for a product.

# **Logging and Monitoring**

•	LoggingInterceptor: Monitors HTTP requests and logs details at various stages for enhanced observability and debugging.

This project aims to provide a solid foundation for product management systems, showcasing best practices in Spring Boot development, and demonstrating effective use of various Spring and Java technologies.
