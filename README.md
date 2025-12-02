
APIoneToManyCRUD
Avaliação Semestral de Análise e desenvolvimento de sistemas usando CRUD e SpringBoot

O sistema contém:

CRUD completo de Cliente

CRUD completo de Pedido

Relacionamento One-to-Many totalmente funcional

DTOs para evitar loops e controlar o que é retornado

Banco H2 para testes

Coleção do Postman pronta para uso

Tecnologias Utilizadas

Java 21

Spring Boot 3

Spring Web

Spring Data JPA

H2 Database

Gradle

DTOs

Postman

Estrutura do Projeto

src/main/java/com/example/demo ├── controller │ ├── ClienteController.java │ └── PedidoController.java ├── dto │ ├── ClienteDTO.java │ └── PedidoDTO.java ├── model │ ├── Cliente.java │ └── Pedido.java ├── repository │ ├── ClienteRepository.java │ └── PedidoRepository.java ├── service │ ├── ClienteService.java │ └── PedidoService.java AsApplication

A API ficará disponível em 8083 http://localhost:8083

Banco de dados H2 http://localhost:8083/h2-console

Método Endpoint Descrição GET /clientes Lista todos os clientes GET /clientes/{id} Busca cliente por ID POST /clientes Cria um novo cliente PUT /clientes/{id} Atualiza um cliente DELETE /clientes/{id} Remove um cliente

Exemplo: { "nome": "Ana" }

Método Endpoint Descrição GET /pedidos/{id} Busca pedido por ID POST /pedidos Cria um pedido PUT /pedidos/{id} Atualiza um pedido DELETE /pedidos/{id} Remove um pedido

Exemplo: { "descricao": "Primeiro pedido", "clienteId": 1 }

Autor: Jaqueline Pacheco
