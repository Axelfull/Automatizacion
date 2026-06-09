# automatizacion_github_copilot

Repositorio privado para almacenar scripts, pruebas y automatizaciones relacionadas con el uso de GitHub Copilot y flujos de trabajo de CI/CD.

## Descripción

Este proyecto contiene ejemplos y utilidades para automatizar tareas comunes con GitHub (repositorios, actions, integración con la CLI, plantillas de PR, etc.). Está pensado como base para experimentar con Copilot en pipelines de automatización.

## Estructura sugerida

- /scripts — scripts de automatización (PowerShell, Bash, Python)
- /actions — GitHub Actions reutilizables
- /tests — pruebas automatizadas
- README.md — este archivo

## Requisitos

- Git 2.0+
- GitHub CLI (`gh`) para crear/administrar repositorios y autenticarse
- PowerShell (Windows) o Bash (Linux/macOS) según los scripts

## Inicio rápido (local -> remoto)

1. Inicializar repositorio local (si todavía no está):

   git init
   git add .
   git commit -m "Initial commit"
   git branch -M main

2. Crear repositorio privado en GitHub y subir (usando gh):

   gh auth login
   gh repo create automatizacion_github_copilot --private --source=. --remote=origin --push

3. Confirmar que el remoto existe:

   git remote -v

## Cómo contribuir

- Crear ramas con nombres descriptivos: `feature/nombre`, `fix/descripcion`.
- Hacer PRs hacia `main` y añadir una descripción clara de los cambios.

## Licencia

Este repositorio está privado por defecto. Añadir una licencia pública solo si se desea compartir.

## Contacto

Preguntas: rojas (local)

---

Archivo generado automáticamente: contenido inicial para README.md
