# API Automation Framework with RestAssured

A comprehensive API testing framework built with **RestAssured**, **TestNG**, and **Maven** for automated testing of REST APIs. This framework demonstrates best practices in API test automation with support for JWT authentication, extensive reporting, and CI/CD integration.

![API Automation CI](https://github.com/NikhilHDK18/API-Automation-Framework-with-RestAssured/workflows/API%20Automation%20CI/badge.svg)

## 🚀 Features

- **Multi-API Support**: Configurable framework supporting multiple APIs (PetStore & DummyJSON)
- **JWT Authentication Flow**: Complete implementation of JWT authentication with access/refresh tokens
- **Product API Testing**: Comprehensive product listing, filtering, and validation tests
- **POJO-based Requests**: Type-safe API requests using Plain Old Java Objects
- **Comprehensive Reporting**: HTML reports using ExtentReports with detailed test logs
- **Context Management**: Centralized auth and response context for managing state across tests
- **Positive & Negative Testing**: Extensive test coverage with both positive and negative scenarios
- **Custom Assertions**: Reusable assertion utilities for cleaner test code
- **CI/CD Ready**: GitHub Actions workflow for automated test execution
- **Logging**: SLF4J with Logback for detailed test execution logs
- **Data-Driven Testing**: Reusable test data utilities

## 📋 Prerequisites

- **Java**: JDK 8 or higher
- **Maven**: 3.6+
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code with Java extensions

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| RestAssured | 5.4.0 | REST API testing library |
| TestNG | 7.4.0 | Testing framework |
| ExtentReports | 4.1.7 | HTML reporting |
| Jackson | 2.17.1 | JSON serialization/deserialization |
| Lombok | 1.18.28 | Reduce boilerplate code |
| Logback | 1.2.13 | Logging framework |
| Maven | 3.x | Build automation |

## 📁 Project Structure

```
API-Automation-Framework-with-RestAssured-main/
├── .github/
│   └── workflows/
│       └── api-tests.yml              # GitHub Actions CI/CD workflow
│
├── src/test/
│   ├── java/
│   │   ├── api/                       # API endpoint layer
│   │   │   ├── AuthApi.java          # Auth-related endpoints
│   │   │   ├── JwtAuthApi.java       # JWT authentication endpoints
│   │   │   ├── ProductApi.java       # Product-related endpoints
│   │   │   └── UserApi.java          # User information endpoints
│   │   │
│   │   ├── base/                      # Base test setup
│   │   │   └── BaseTest.java         # Base test class with common setup
│   │   │
│   │   ├── config/                    # Configuration management
│   │   │   └── ApiConfig.java        # API configuration management
│   │   │
│   │   ├── context/                   # Context/state management
│   │   │   ├── AuthContext.java      # Authentication context for tokens
│   │   │   └── ResponseContext.java  # Response context for sharing data
│   │   │
│   │   ├── pojo/                      # Plain Old Java Objects (models)
│   │   │   ├── AuthResponse.java     # Authentication response model
│   │   │   ├── LoginRequest.java     # Login request model
│   │   │   └── RefreshTokenRequest.java  # Refresh token request model
│   │   │
│   │   ├── reporting/                 # Reporting and logging
│   │   │   ├── ExtentManager.java    # ExtentReports configuration
│   │   │   ├── ExtentTestListener.java    # TestNG listener for reporting
│   │   │   ├── ReportLogger.java     # Custom logger for reports
│   │   │   └── ReportPostProcessor.java   # Report post-processing
│   │   │
│   │   ├── tests/                     # Test classes
│   │   │   ├── CreateUserPositiveTest.java         # User creation positive scenarios
│   │   │   ├── CreateUserNegativeTest.java         # User creation negative scenarios
│   │   │   ├── JwtAuthFlowTest.java                # JWT authentication flow tests
│   │   │   ├── JwtAuthPositiveTest.java            # JWT positive scenarios
│   │   │   ├── JwtAuthNegativeTest.java            # JWT negative scenarios
│   │   │   ├── JwtRefreshTokenTest.java            # JWT refresh token tests
│   │   │   ├── ProductListingPositiveTest.java     # Product listing tests
│   │   │   ├── ProductCategoryFilteringTest.java   # Product filtering tests
│   │   │   └── ProductDataValidationTest.java      # Product validation tests
│   │   │
│   │   └── utils/                     # Utility classes
│   │       ├── AssertUtils.java      # Custom assertion utilities
│   │       ├── JwtTestData.java      # Test data for JWT operations
│   │       └── TestData.java         # Test data for user operations
│   │
│   └── resources/                     # Test resources
│       ├── config.properties         # Configuration properties
│       └── logback.xml              # Logging configuration
│
├── pom.xml                           # Maven dependencies and build configuration
├── testng.xml                        # TestNG suite configuration
├── README.md                         # Project documentation
└── AGENTS.md                         # Agents documentation
```

## 📂 Framework Components

### API Layer (`api/`)
- **AuthApi.java**: Handles PetStore authentication endpoints
- **JwtAuthApi.java**: Manages JWT authentication for DummyJSON API
- **ProductApi.java**: Product-related API operations (listing, filtering)
- **UserApi.java**: User information and profile endpoints

### Base Layer (`base/`)
- **BaseTest.java**: Common test setup, configuration, and teardown logic

### Configuration (`config/`)
- **ApiConfig.java**: Centralized API configuration with support for multiple APIs

### Context Management (`context/`)
- **AuthContext.java**: Manages authentication tokens and cookies across tests
- **ResponseContext.java**: Shares response data between test methods

### POJOs (`pojo/`)
- **AuthResponse.java**: Models authentication response with tokens
- **LoginRequest.java**: Login request payload
- **RefreshTokenRequest.java**: Token refresh request payload

### Reporting (`reporting/`)
- **ExtentManager.java**: Configures ExtentReports
- **ExtentTestListener.java**: TestNG listener for report generation
- **ReportLogger.java**: Custom logging utility for reports
- **ReportPostProcessor.java**: Post-processes and enhances reports

### Test Classes (`tests/`)

#### User Management Tests
- **CreateUserPositiveTest**: Valid user creation scenarios
- **CreateUserNegativeTest**: Invalid data and error handling

#### JWT Authentication Tests
- **JwtAuthPositiveTest**: Valid login scenarios
- **JwtAuthNegativeTest**: Invalid credentials handling
- **JwtAuthFlowTest**: End-to-end authentication flow
- **JwtRefreshTokenTest**: Token refresh functionality

#### Product API Tests
- **ProductListingPositiveTest**: Product listing and retrieval
- **ProductCategoryFilteringTest**: Category-based filtering
- **ProductDataValidationTest**: Product data structure validation

### Utilities (`utils/`)
- **AssertUtils.java**: Custom assertion methods for common validations
- **JwtTestData.java**: Test data provider for JWT operations
- **TestData.java**: Test data provider for user operations

## ⚙️ Installation & Setup

### 1. Clone the Repository

```bash
git clone https://github.com/NikhilHDK18/API-Automation-Framework-with-RestAssured.git
cd API-Automation-Framework-with-RestAssured
```

### 2. Install Dependencies

```bash
mvn clean install
```

### 3. Configure API Base URLs

Edit `src/test/resources/config.properties`:

```properties
petstore.base.url=https://petstore.swagger.io/v2
dummyjson.base.url=https://dummyjson.com
```

## 🏃 Running Tests

### Run All Tests

```bash
mvn clean test
```

### Run Specific Test Suite

```bash
# Run JWT Authentication tests
mvn test -Dtest=JwtAuthPositiveTest

# Run Product API tests
mvn test -Dtest=ProductListingPositiveTest

# Run User Management tests
mvn test -Dtest=CreateUserPositiveTest
```

### Run Using TestNG XML

```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run from IDE

Right-click on `testng.xml` and select **Run**

## 📊 Test Reports

After test execution, reports are generated in:

- **ExtentReports HTML**: `target/extent-report.html`
- **TestNG Reports**: `target/surefire-reports/`

Open the HTML report in a browser for detailed test execution results with screenshots and logs.

## 🧪 Test Coverage

### JWT Authentication Tests (6 test classes)

- **JwtAuthPositiveTest**: Valid login scenarios with POJO
- **JwtAuthNegativeTest**: Invalid credentials and error handling
- **JwtAuthFlowTest**: Complete authentication flow
- **JwtRefreshTokenTest**: Token refresh functionality

### User Management Tests (2 test classes)

- **CreateUserPositiveTest**: Successful user creation scenarios
- **CreateUserNegativeTest**: Validation and error scenarios

### Product API Tests (3 test classes)

- **ProductListingPositiveTest**: Product retrieval and listing
- **ProductCategoryFilteringTest**: Category-based product filtering
- **ProductDataValidationTest**: Product data structure and field validation

## 🔑 Key Concepts

### 1. API Configuration

The framework supports multiple APIs through `ApiConfig`:

```java
protected void usePetStoreApi() {
    ApiConfig.setApi(ApiType.PETSTORE);
}

protected void useDummyJsonApi() {
    ApiConfig.setApi(ApiType.DUMMYJSON);
}
```

### 2. Authentication Context

Centralized management of authentication tokens:

```java
AuthContext.setAccessToken(auth.getAccessToken());
AuthContext.setRefreshToken(auth.getRefreshToken());
AuthContext.setCookies(response.getCookies());
```

### 3. Response Context

Share response data between test methods:

```java
ResponseContext.setResponse(response);
Response savedResponse = ResponseContext.getResponse();
```

### 4. POJO-Based Requests

Type-safe API requests using POJOs:

```java
LoginRequest loginRequest = JwtTestData.validLoginRequest();
Response response = JwtAuthApi.login(loginRequest);
AuthResponse auth = response.as(AuthResponse.class);
```

### 5. Custom Assertions

Reusable assertion utilities:

```java
AssertUtils.assertStatusCode(response, 200);
AssertUtils.assertResponseTime(response, 5000);
AssertUtils.assertJsonPath(response, "$.username", "testuser");
```

### 6. Enhanced Reporting

Comprehensive logging in reports:

```java
ReportLogger.info("Starting login test");
ReportLogger.pass("Login successful");
ReportLogger.fail("Login failed");
ReportLogger.warning("Token expiring soon");
```

## 🔄 CI/CD Integration

The project includes GitHub Actions workflow (`.github/workflows/api-tests.yml`) that:

- Triggers on push/PR to main branch
- Sets up Java 17 environment
- Caches Maven dependencies
- Runs all tests
- Uploads ExtentReports as artifacts
- Provides test execution status badges

## 🎯 Best Practices Implemented

1. **Layered Architecture**: Clear separation between API, test, and utility layers
2. **Page Object Model Pattern**: Separation of endpoints and test logic
3. **Data-Driven Testing**: Reusable test data in utility classes
4. **Centralized Configuration**: Single source for API configurations
5. **Context Management**: Shared authentication and response state across tests
6. **Comprehensive Logging**: Detailed logs for debugging
7. **Custom Assertions**: Reusable assertion methods for common validations
8. **Test Independence**: Tests can run independently without dependencies
9. **SOLID Principles**: Single Responsibility, Open/Closed principles
10. **DRY Principle**: Don't Repeat Yourself - reusable components

## 📝 Sample Test Examples

### JWT Authentication Test

```java
@Test(priority = 1)
public void loginWithPojo() {
    ReportLogger.info("Starting login using POJO-based request");
    
    Response response = JwtAuthApi.login(JwtTestData.validLoginRequest());
    
    AssertUtils.assertStatusCode(response, 200);
    
    AuthResponse auth = response.as(AuthResponse.class);
    AuthContext.setAccessToken(auth.getAccessToken());
    
    ReportLogger.pass("Login successful and tokens captured");
}
```

### Product Filtering Test

```java
@Test(priority = 1)
public void filterProductsByCategory() {
    ReportLogger.info("Testing product category filtering");
    
    Response response = ProductApi.getProductsByCategory("smartphones");
    
    AssertUtils.assertStatusCode(response, 200);
    AssertUtils.assertJsonPath(response, "$.products[0].category", "smartphones");
    
    ReportLogger.pass("Product filtering by category successful");
}
```

### Custom Assertion Example

```java
@Test
public void validateProductData() {
    Response response = ProductApi.getProduct(1);
    
    // Using custom assertion utilities
    AssertUtils.assertStatusCode(response, 200);
    AssertUtils.assertResponseTime(response, 3000);
    AssertUtils.assertJsonPath(response, "$.id", 1);
    AssertUtils.assertNotNull(response, "$.title");
}
```

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👤 Author

**Nikhil Hadke**
- GitHub: [@NikhilHDK18](https://github.com/NikhilHDK18)
- LinkedIn: [Nikhil Hadke](https://linkedin.com/in/nikhilhadke777)

## 🙏 Acknowledgments

- [RestAssured Documentation](https://rest-assured.io/)
- [TestNG Documentation](https://testng.org/)
- [ExtentReports](https://www.extentreports.com/)
- [DummyJSON API](https://dummyjson.com/)
- [PetStore API](https://petstore.swagger.io/)

## 📞 Support

If you encounter any issues or have questions, please:
- Open an issue on GitHub
- Check existing documentation
- Review the test examples in the project

## 📈 Project Stats

- **Total Test Classes**: 9
- **API Endpoints Covered**: 15+
- **Test Scenarios**: 30+
- **Code Coverage**: Comprehensive API layer coverage
- **Reporting**: ExtentReports with detailed logs

---

⭐ If you find this project helpful, please consider giving it a star!
