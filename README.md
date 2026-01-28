# Java Selenium Automation Framework
### Selenium • Cucumber • TestNG • SnakeYAML

This project is a **Java-based UI test automation framework** designed to test web applications using **Behavior-Driven Development (BDD)**.  
It combines **Selenium WebDriver**, **Cucumber**, and **TestNG**, with **dynamic configuration via `application.yml`** using **SnakeYAML** and a **Driver Factory pattern** for browser management.

The framework is structured to be **scalable, maintainable, and easy to extend**, following clean automation architecture principles.

---

## ✨ Features

- Web UI automation using Selenium WebDriver
- BDD-style test scenarios with Cucumber
- Test execution and reporting via TestNG
- Dynamic configuration using `application.yml`
- Centralized WebDriver management with Driver Factory
- Page Object Model (POM)
- Multi-browser support
- Headless execution support

---

## 🔁 Test Automation Flow

### 1️⃣ Configure
Test execution settings such as browser type, headless mode, base URL, and timeouts are defined in `application.yml`.  
These properties are loaded at runtime using **SnakeYAML**, allowing configuration changes without code changes.

---

### 2️⃣ Initialize Driver
Before executing each scenario, the framework initializes the WebDriver through a **Driver Factory**.  
The factory reads the configuration and creates the correct browser instance, applying timeouts and execution mode.

---

### 3️⃣ Execute Scenarios
Cucumber scenarios describe application behavior in a human-readable format using `.feature` files.  
Each scenario is mapped to step definitions, which interact with the application through **Page Objects**.

---

### 4️⃣ Validate
Assertions are performed using **TestNG** to validate UI elements, page state, and application behavior.

---

### 5️⃣ Tear Down
After scenario execution, the WebDriver is closed properly to ensure clean execution and avoid resource leaks.

---

## 🧱 Framework Architecture

The framework follows a **layered automation architecture**:

- **Feature Layer**  
  Cucumber `.feature` files describing business scenarios.

- **Step Definition Layer**  
  Implementation of test steps and orchestration logic.

- **Page Layer**  
  Page Object Model encapsulating UI interactions.

- **Driver Layer**  
  WebDriver lifecycle and browser management.

- **Configuration Layer**  
  YAML-based runtime configuration using SnakeYAML.

This separation of concerns improves maintainability and scalability.

---

## ⚙️ Configuration Strategy

All environment-specific values are externalized in `application.yml`, including:

- Browser selection
- Headless execution flag
- Base URL
- Implicit and explicit timeouts

SnakeYAML maps the configuration directly to Java objects, ensuring type safety and clarity.

---

## ▶️ Test Execution

Tests are executed using **TestNG**, integrated with **Cucumber** for scenario management.

```bash
mvn clean test
