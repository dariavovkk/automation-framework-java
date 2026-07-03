# T-Mobile Web Test Automation (Recruitment Task 1)

This repository contains an automated E2E test scenario for the T-Mobile online store, built using the BDD approach and the Selenide framework.

## Tech Stack
* **Java 21**
* **Maven** (Build tool)
* **Selenide 7+** (WebDriver wrapper based on Selenium 4)
* **Cucumber 7+** (BDD framework)
* **JUnit 5** (Test runner)

## Architecture Best Practices
* **Page Object Pattern (PO):** Elements and interactions are strictly isolated into dedicated page classes (`MainPage`, `ProductsListPage`, `ProductDetailsPage`, `CartPage`).
* **SOLID Principles:** Adheres to the Single Responsibility Principle (SRP) — each page class manages only its respective screen.
* **Dynamic Locators:** Avoids hardcoded selectors; product selection and cart verification use parameterized, context-aware queries.
* **Robust Flakiness Protection:** Critical actions (cookie compliance banners and key dynamic buttons) utilize fallback JavaScript execution (`executeJavaScript`) to bypass overlay or rendering delays.

## Getting Started

### Prerequisites
Ensure you have the following installed:
* **JDK 21** or higher
* **Maven**
* **Google Chrome** browser

### Execution
To run the test execution cycle and generate reports, execute the following command in the project root directory:
```bash
mvn clean test