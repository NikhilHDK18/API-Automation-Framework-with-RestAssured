# AGENTS.md

## Project Overview
This repository contains an API Automation Framework built using:
- Java
- RestAssured
- Maven
- TestNG

The framework supports multiple base URLs and environments via
`ApiConfig` and `config.properties`.

---

## Coding & Design Rules
- Do NOT hardcode base URLs in test or base classes
- All base URLs must come from:
  - ApiConfig
  - config.properties
- Prefer POJOs for request/response bodies
- Use meaningful method and class names
- Follow existing package structure

---

## Testing Rules
- Tests should be written using TestNG
- Assertions must be clear and descriptive
- Prefer reusable endpoint/helper methods
- Avoid duplicating test logic

---

## Git & Merge Rules
- When resolving conflicts:
  - Prefer newer framework changes
  - ApiConfig-based configuration overrides older setups
- Do NOT reintroduce removed configs or deprecated patterns
- Avoid committing `.idea` files unless necessary

---

## Reporting
- Use ExtentReports for test reporting
- Any new listener must integrate with existing Extent setup

---

## AI Agent Instructions
- Follow existing project structure
- Do not refactor unrelated files
- Ask before introducing new dependencies
- Keep changes minimal and consistent
