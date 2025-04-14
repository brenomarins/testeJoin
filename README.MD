# Aplicacao de controle de categorias e produtos

# Requisitos
- Java version "17.0.9" 2023-10-17 LTS
- Apache Maven 3.9.6
- PostgreSQL Engine 15.4

## 🔁 Endpoints disponíveis

### Categoria
- `GET /categorias` – Lista todas as categorias
- `GET /categorias/{id}` – Busca uma categoria pelo ID
- `POST /categorias` – Cria uma nova categoria
- `PUT /categorias/{id}` – Atualiza uma categoria existente
- `DELETE /categorias/{id}` – Deleta uma categoria

### Produto
- `GET /produtos` – Lista todos os produtos
- `GET /produtos/{id}` – Busca um produto pelo ID
- `POST /produtos` – Cria um novo produto
- `PUT /produtos/{id}` – Atualiza um produto existente
- `DELETE /produtos/{id}` – Deleta um produto

# Execução Local

Executar Serviço pela linha de comando

```
mvn spring-boot:run
```

Executar testes unitários pela linha de comando

```
mvn test
```

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

Desenvolvido com 💻 por [Breno Marins](https://github.com/brenomarins)
