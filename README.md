## 인프런 스프링 시큐리티 강의 2024.03 version

### start.spring.io dependencies

- Lombok
- Mustache
- Spring Boot DevTools
- Spring Data JPA
- MySQL Driver
- Spring Security
- Spring Web

### MySQL DB와 사용자 생성

```SQL
create user 'cos'@'%' identified by 'cos1234';
GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
create database security;
use security;
```

