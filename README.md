# Final Optics Challenge - DIO - GFT - Java Development with AI

https://optics.up.railway.app/swagger-ui/index.html#/

RESTful API otica 2023 built in Java 17 with Spring Boot 3.

## Main Technologies
- **Java 17**: We will use the latest LTS version of Java to take advantage of the latest innovations that this robust and widely used language offers;
- **Spring Boot 3**: We will work with the newest version of Spring Boot, which maximizes developer productivity through its powerful auto-configuration premise;
- **Spring Data JPA**: We will explore how this tool can simplify our data access layer, facilitating integration with SQL databases;
- **OpenAPI (Swagger)**: We will create effective and easy-to-understand API documentation using OpenAPI (Swagger), perfectly aligned with the high productivity that Spring Boot offers;
- **Railway**: facilitates the deployment and monitoring of our solutions in the cloud, in addition to offering several databases as a service and CI/CD pipelines.

```mermaid
classDiagram
    class Order {
        +int id
        +int status
        +datetime dtOrder
        +string dtDelivery
        +string timeOrder
        +int lens
        +int valueLens
        +string materialLens
        +string typeLens
        +int frame
        +int valueFrame
        +string materialFrame
        +string typeFrame
        +string esfLongOe
        +string esfCloseOd
        +string esfCloseOe
        +string cilLongOd
        +string cilLongOe
        +string cilCloseOd
        +string cilCloseOe
        +string eixoLongOd
        +string eixoLongOe
        +string eixoCloseOd
        +string eixoCloseOe
        +string dnpLongOd
        +string dnpLongOe
        +string dnpCloseOd
        +string dnpCloseOe
        +string heigthLongOd
        +string heigthLongOe
        +string heigthCloseOd
        +string heigthCloseOe
        +string dm
        +string adicao
        +string vert
        +string hor
        +string ponte
        +string obs
        +string markaLens
        +string markaFrame
        +string indication
        +int valueIndication
        +int totalLens
        +int totalFrame
        +string indicationStore
        +int valueStore
        +Employee employee
        +Customer customer
        +Store store
        +StatusOrder statusOrder
        +List~PaymentMethod~ paymentMethods
    }

    class Employee {
        +int id
        +string name
        +int status
        +Store store
    }

    class Store {
        +int id
        +string title
        +int status
    }

    class Customer {
        +int id
        +string cpf
        +string nome
        +string telefone
        +int status
    }

    class StatusOrder {
        +int id
        +string title
        +int status
    }

    class PaymentMethod {
        +int id
        +string nome
        +int plot
        +datetime datePay
        +int value
        +int status
    }

    Order --> Employee
    Order --> Customer
    Order --> Store
    Order --> StatusOrder
    Order --> PaymentMethod
    Employee --> Store
```
