# Theatre Shows Sample Service

This is a minimal Spring Boot sample microservice for managing theatre shows (create, update, delete, list).
It demonstrates:
- Spring Boot 3 (Java 17)
- Spring Data JPA (Postgres)
- Redis (cache) wiring (auto-config)
- OAuth2 Resource Server (JWT)
- Actuator endpoints for health/metrics
- Dockerfile and basic Kubernetes manifests

## Build
mvn clean package

## Run locally
Requires a running Postgres and Redis. Example:
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/shows \
SPRING_DATASOURCE_USERNAME=postgres \
SPRING_DATASOURCE_PASSWORD=postgres \
REDIS_HOST=localhost \
java -jar target/shows-service-0.0.1-SNAPSHOT.jar

## Docker
docker build -t shows-service:local .

## Kubernetes
kubectl apply -f k8s/namespace.yaml
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml

## Added
- `openapi/openapi.yaml` — full OpenAPI spec
- Integration test using Testcontainers (`src/test/.../ShowIntegrationTest.java`)
- Helm chart under `helm/shows`
