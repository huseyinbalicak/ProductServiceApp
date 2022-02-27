# Mini Product Service App

### About the project

**Products Service** was developed for product operations. 
Its a simple CRUD operations.

You can list,  add, update, delete the product.

Tech Stack:
* [Java     11](#) * [Spring Boot](#)
* [Spring DataJpa](#) * [H2 Database](#)
* [JUnit5](#) * [Docker](#)
* [Git](#)

### Project run
We can run two different ways:

### with Docker
1. go to this github adress git clone https://github.com/...
2. docker build -t [imageName:version] [dockerfilePath] .
3. docker run --name [containerName] -p 8080:8080 [image]
4. this my image you can run :
> docker run --name product-service-container -p 8080:8080 [imageName:version]

 
### with Maven
1. go to this github adress git clone https://github.com/...
2. mvn clean install
3. mvn springboot:run

> `http://localhost:8080` will run that port

## HTTP Client Structure

|      Controller          | Metot  |            Adres                  |                  Description                |
| :-------------------:    | :----: | :-------------------------:       | :-----------------------------------------: |
|  **ProductController**   |  GET   |   localhost:8080/products         |        Will List All products               |
|                          |  GET   |  localhost:8080/products/{id}     |        will get product with id             |
|                          |  POST  |   localhost:8080/products         |             create a product                |
|                          |  PUT   |  localhost:8080/products/{id}     |       will update product with id           |
|                          | DELETE |  localhost:8080/products/{id}     |         will delete product with id         |
