# Entidad financiera

## Descripción

Esta API permite a los usuarios suscribirse a fondos de inversión.
Está construida con Java y Spring Boot, proporcionando endpoints para gestionar clientes, fondos y suscripciones.

## Como iniciar el proyecto.

### Construir la imagen:

```docker build -t ahorrafacil .```

### Ejecutar el contenedor:

```docker run -d -p 8080:8080 ahorrafacil```

Esto desplegara la aplicación en el puerto 8080.

![The San Juan Mountains are beautiful!](/assets/images/san-juan-mountains.jpg "San Juan Mountains")

## Requisitos para correr el proyecto:

-Java 17 y Postgre 17 

## Arquitectura Hexagonal

```
/com/ahorrafacil
│
├── /application
│   ├── /services
│   └── /usecases
│
├── /domain
│   ├── /model
│   └── /ports
│
├── /infra
│   ├── /config
│   │   └── ApplicationConfig.java
│   ├── /controllers
│   │   ├── BranchController.java
│   │   ├── ClientController.java
│   │   ├── FinancialAccountController.java
│   │   ├── ProductController.java
│   │   └── SubscriptionController.java
│   ├── /entities
│   │   ├── AvailabilityEntity.java
│   │   ├── BranchEntity.java
│   │   ├── ClientEntity.java
│   │   ├── FinancialAccountEntity.java
│   │   ├── ProductEntity.java
│   │   └── SubscriptionEntity.java
│   ├── /repositories
│   │   ├── JpaAvailabilityRepository.java
│   │   ├── JpaBranchRepository.java
│   │   ├── JpaBranchRepositoryAdapter.java
│   │   ├── JpaClientRepository.java
│   │   ├── JpaClientRepositoryAdapter.java
│   │   ├── JpaFinancialAccountRepository.java
│   │   ├── JpaFinancialAccountRepositoryAdapter.java
│   │   ├── JpaProductRepository.java
│   │   ├── JpaProductRepositoryAdapter.java
│   │   ├── JpaSubscriptionRepository.java
│   │   └── JpaSubscriptionRepositoryAdapter.java
│
└── /test
```






