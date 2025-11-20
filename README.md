
# Parking Backend (Spring Boot)

- Java 17 / Spring Boot 3 / Maven
- H2 en memoria
- JWT simple para login
- Endpoints (todos bajo `/api`):
  - `POST /api/auth/login` {username,password} -> {token, username}
  - `GET /api/config` -> {ratePerMinute, capacity}
  - `GET /api/occupancy` -> {inCount, capacity}
  - `POST /api/vehicles/enter` {plate}
  - `POST /api/vehicles/exit` {plate, method}
  - `GET /api/vehicles?from=YYYY-MM-DD&to=YYYY-MM-DD&q=ABC`
  - `DELETE /api/vehicles/{id}`

CORS habilitado para `http://186.64.113.173`.

## Ejecutar
```bash
mvn spring-boot:run
```
Usuario inicial: **admin / admin123** (seed en `DataLoader`).

H2 console: `http://localhost:8080/h2-console`
