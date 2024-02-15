
# Web API <img src="https://cdn.worldvectorlogo.com/logos/clojure-1.svg" style="width: 50px; height: 50px;"> + <img src="https://cdn.worldvectorlogo.com/logos/postgresql.svg" style="width: 50px; height: 50px;">



Simple Web CRUD using Clojure and PostgreSQL



SQL:
```sql
CREATE DATABASE produto;

CREATE TABLE items (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    description VARCHAR(255)
);

```

<hr>

## Use:

```bash
$ clone git@github.com:Ujs74wiop6/api-clojure.git
```

First of all, fill in your Postgres information

$ /crud/src/crud/repository/**migrations.clj**

```bash
(def db {:dbtype ""
         :dbname "produto" 
         :user ""
         :password ""})

```

Downloading the dependencies

```bash
$ lein deps
```
Running the project

```bash
$ lein run
```

## End-points

Creating the product:

```bash
curl -X POST localhost:3000/produto -H "Content-Type: application/json" -d '{"title":"Teste00", "description":"Teste00"}'
```

Listing all products:

```bash
curl -X GET localhost:3000/produto
```
Finding a product:

```bash
curl -X GET localhost:3000/produto/id
```

Updating a product:

```bash
curl -X PUT localhost:3000/produto/id -H "Content-Type: application/json" -d '{"title":"...", "description":"..."}'
```

Removing a product:

```bash
curl -X DELETE localhost:3000/produto/id
```


Caso se deparar com algum tipo de problema de Authentication com seu PostgreSQL:
[Link do StackoverFlow](https://stackoverflow.com/questions/64210167/unable-to-connect-to-postgres-db-due-to-the-authentication-type-10-is-not-suppor)
