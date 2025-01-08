# Online Food Delivery Project(CRM)

## Overview
This project is an **Online Food Delivery System** built using the **MERN Stack** (MongoDB, Express.js, React, Node.js) and **Spring Boot**. The system supports role-based access for customers and restaurant owners, providing a seamless and user-friendly experience for ordering food online.

---

## Features
- **User Management**: Role-based access for customers and restaurant owners.
- **Authentication**: Secure signup and login using JWT.
- **Restaurant Management**: Add, edit, delete restaurants, and manage menus.
- **Order Management**: Create and track orders, with payment integration using Stripe.
- **Cart Management**: Add, update, and clear items in the cart.
- **Search**: Search functionality for restaurants and food items.
- **Admin Panel**: Manage users, restaurants, orders, and ingredients.
- **Notifications**: Email notifications using Nodemailer and Spring Mail.

---

## Technologies Used

### Frontend (React)
- **React**: Component-based UI development.
- **Tailwind CSS**: Utility-first CSS framework.
- **MUI**: Component library for a modern UI.
- **Redux**: State management.
- **Axios**: For API communication.

### Backend (Node.js and Spring Boot)
- **Node.js**: Server-side JavaScript runtime.
- **Express.js**: Web application framework.
- **Spring Boot**: Backend framework for Java-based services.
- **Spring Security**: Authentication and authorization.
- **MySQL**: Database for the Spring Boot backend.
- **MongoDB**: NoSQL database for the MERN stack.
- **JWT**: Authentication.
- **Stripe**: Payment gateway.
- **Nodemailer/Spring Mail**: Email notifications.

---

## API Endpoints

### Cart Controller
- `PUT /api/cart`
- `PUT /api/cart/clear`
- `PUT /api/cart/add`
- `PUT /api/cart-item/add`
- `DELETE /api/cart-item/{id}/remove`

### Admin Restaurant Controller
- `PUT /api/admin/restaurants/{id}`
- `DELETE /api/admin/restaurants/{id}`
- `PUT /api/admin/restaurants/{id}/status`
- `POST /api/admin/restaurants`
- `GET /api/admin/restaurants/user`

### Admin Order Controller
- `PUT /api/admin/order/{orderId}/{orderStatus}`
- `GET /api/admin/order/restaurant/{id}`

### Ingredient Controller
- `PUT /api/admin/ingredients/{id}/stock`
- `POST /api/admin/ingredients`
- `POST /api/admin/ingredients/category`
- `GET /api/admin/ingredients/restaurant/{id}`
- `GET /api/admin/ingredients/restaurant/{id}/category`

### Admin Food Controller
- `PUT /api/admin/food/{id}`
- `DELETE /api/admin/food/{id}`
- `POST /api/admin/food`

### Auth Controller
- `POST /auth/signup`
- `POST /auth/signin`

### Restaurant Controller
- `POST /api/restaurants/{id}/favourites`
- `GET /api/restaurants`
- `GET /api/restaurants/{id}`
- `GET /api/restaurants/search`

### Order Controller
- `POST /api/order`
- `POST /api/order/user`

### Category Controller
- `POST /api/admin/category`
- `GET /api/category/restaurant/{id}`

### User Controller
- `GET /api/users/profile`

---

## Database Models

### User
```java
public class User {
    Long id;
    String fullName;
    String email;
    String password;
    String role;
    List<Order> orders;
    List<Restaurant> favorites;
    List<Address> addresses;
    String status;
}
```

### Restaurant
```java
public class Restaurant {
    Long id;
    User owner;
    String name;
    String description;
    String cuisineType;
    Address address;
    ContactInformation contactInformation;
    String openingHours;
    List<Review> reviews;
    List<Order> orders;
    int numRating;
    List<String> images;
    Date registrationDate;
    boolean open;
    List<Food> foods;
}
```

### Food
```java
public class Food {
    Long id;
    String name;
    String description;
    double price;
    String foodCategory;
    List<String> images;
    boolean available;
    Restaurant restaurant;
    boolean isVegetarian;
    boolean isSeasonal;
    List<Ingredient> ingredients;
    Date creationDate;
}
```

### Order
```java
public class Order {
    Long id;
    User customer;
    Restaurant restaurant;
    double totalAmount;
    String orderStatus;
    Date createdAt;
    Address deliveryAddress;
    List<OrderItem> items;
    Payment payment;
    int totalItem;
    double totalPrice;
}
```

---

## Folder Structure

```
project_root/
|
├── src/
│   ├── controllers/        // Controllers handle request/response logic
│   │   ├── itemController.js
│   │   └── ...
│   │
│   ├── models/            // Database models/schema
│   │   ├── itemModel.js
│   │   └── ...
│   │
│   ├── routes/            // API routes
│   │   ├── itemRoutes.js
│   │   └── ...
│   │
│   ├── services/          // Business logic and data processing
│   │   ├── itemService.js
│   │   └── ...
│   │
│   └── app.js             // Entry point of the application
|
├── .env                   // Environment variables
├── package.json           // Project dependencies and metadata
└── ...
```

---

## Setup and Installation

### Frontend Setup
1. Clone the repository:
    ```bash
    git clone <repository-url>
    ```

2. Navigate to the project directory:
    ```bash
    cd project_root
    ```

3. Install dependencies:
    ```bash
    npm install
    ```

4. Set up the environment variables in the `.env` file.

5. Start the backend server:
    ```bash
    npm start
    ```

6. Start the React frontend:
    ```bash
    cd frontend
    npm start
    ```

### Backend Setup (Spring Boot)
1. Clone the backend repository:
    ```bash
    git clone https://github.com/AbdualimovBotir/Online-Food-Delivery-Project
    ```

2. Open the project in IntelliJ IDEA.

3. Configure the `application.properties` file with your database credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    jwt.secret=your_jwt_secret
    ```

4. Run the application:
    ```bash
    ./mvnw spring-boot:run
    ```

---

## Contributing
Contributions are welcome! Please fork this repository and submit a pull request for any changes or improvements.

---

## License
This project is licensed under the Apache 2.0 License.

---

## Authors
- Your Name
- Additional Contributors

