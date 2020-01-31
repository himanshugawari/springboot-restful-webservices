
User -> Posts


Retrieve all Users - GET /users

Create a User - POST /users

Retrieve one User - GET /users/{id} -> /users/1

Delete a User - DELETE /users/{id} -> /users/1

Retrieve all posts for a User - GET /users/{id}/posts

Create a posts for a User - POST /users/{id}/posts

Retrieve details of a post - GET /users/{id}/posts/{post_id}


----------------------------------------------------------------------

Links from course examples

Basic Resources

http://localhost:8080/hello-world

http://localhost:8080/hello-world-bean

http://localhost:8080/hello-world/path-variable/Himanshu

http://localhost:8080/users/

http://localhost:8080/users/1


JPA Resources

http://localhost:8080/jpa/users/

http://localhost:8080/jpa/users/1

http://localhost:8080/jpa/users/10001/posts


Filtering

http://localhost:8080/filtering

http://localhost:8080/filtering-list


Actuator

http://localhost:8080/actuator


Versioning

http://localhost:8080/v1/person

http://localhost:8080/v2/person

http://localhost:8080/person/param
params=[version=1]

http://localhost:8080/person/param
params=[version=2]

http://localhost:8080/person/header
headers=[X-API-VERSION=1]

http://localhost:8080/person/header
headers=[X-API-VERSION=2]

http://localhost:8080/person/produces
produces=[application/vnd.company.app-v1+json]

http://localhost:8080/person/produces
produces=[application/vnd.company.app-v2+json]


Swagger

http://localhost:8080/swagger-ui.html

http://localhost:8080/v2/api-docs


H2-Console

http://localhost:8080/h2-console
