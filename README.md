# SkillHub

**SkillHub** es una aplicación de demostración full-stack para mostrar conocimientos en desarrollo backend y frontend.

## 🚀 Tecnologías
**Backend**
- Java 17
- Spring Boot 3 (Web, Data JPA, Validation)
- Liquibase (migraciones)
- Lombok / MapStruct
- OpenAPI (SpringDoc)

**Frontend**
- Angular 17
- Angular Material + TailwindCSS

**Base de Datos**
- MySQL 8 (Docker)
- Adminer (UI para consultas)

## 🧰 Requisitos
- JDK 17 (instalado y configurado)
- Node 20 LTS
- Docker Desktop (instalado y corriendo)
- Git para control de versiones

## 🏗️ Arranque rápido
*(Cuando estén creados los subproyectos)*

1️⃣ Infraestructura:
```bash
docker compose -f infra/docker-compose.yml up -d
