
This automation framework built using **Java, Selenium WebDriver, TestNG**, and **Maven**. 
---

## 🚀 Tech Stack

- Java 17  
- Maven 3.9.x  
- Selenium WebDriver 4.19  
- TestNG 7.9  
- IntelliJ IDEA  
- Git & GitHub  

---

## 🛠️ Setup Instructions (From Scratch)

### ✅ 1. Install JDK (Java 17)

- Download JDK:  
  https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

#### Set JAVA_HOME:
- Go to **Environment Variables**  
- Add `JAVA_HOME` → `C:\Program Files\Java\jdk-17`  
- Add `%JAVA_HOME%\bin` to system `Path`

#### Verify Installation:
```bash
java -version
javac -version
```
---

### ✅ 2. Install Maven

- Download Maven:  
  https://maven.apache.org/download.cgi
- Extract `apache-maven-3.9.x-bin.zip` to: `C:\apache-maven-3.9.x`

#### Set MAVEN_HOME:
- `MAVEN_HOME` → `C:\apache-maven-3.9.x`  
- Add `%MAVEN_HOME%\bin` to system `Path`

#### Verify:
```bash
mvn -version
```

---

### ✅ 3. Install IntelliJ IDEA

- Download:  
  https://www.jetbrains.com/idea/download

Steps:
- Open IntelliJ → File → New Project → Maven
- Open your existing Maven project using `pom.xml`
- IntelliJ will auto-download dependencies

---

### ✅ 4. Install Git & Connect to GitHub

- Download Git:  
  https://git-scm.com/download/win

During install, select:
✅ **Git from the command line and 3rd-party software**

#### Verify:
```bash
git --version
```

---

## 📦 Clone This Project

```bash
git clone https://github.com/YourUsername/flipkart-automation.git
cd flipkart-automation
```

---

## 📁 Project Structure

```
src
├── main
│   └── java
│       └── base
│           └── BaseTest.java
├── test
│   └── java
│       └── Module
│           └── Flipcart
│               ├── page
│               │   ├── FlipkartPage.java
│               │   └── NestedFramesPage.java
│               └── test
│                   ├── FlipkartTest.java
│                   └── NestedFramesTest.java
pom.xml
README.md
```

---

## 🧪 How to Run the Project

### Option 1: From IntelliJ
- Right-click on any test class (e.g., `FlipkartTest`)
- Select **Run 'FlipkartTest'**

### Option 2: Using Maven (if `testng.xml` is configured)
```bash
mvn clean test
```

---

## ✅ Test Cases Covered

### 🔹 Flipkart
- Launch Flipkart
- Hover on Fashion → Kids → Boys & Girls Jeans
- Sort by Price Low to High
- Click product → Select size → Add to Cart
- Verify product name and price in cart

### 🔹 DemoQA
- Nested Frames → Print Child Iframe text
- Alerts → Handle 4 types of alerts
- Drag and Drop → Acceptable item only
- Browser Windows → Handle new window and validate text

---

## 💡 Notes

- Headless Mode:
  Uncomment or configure this in `BaseTest.java` to run tests without opening browser:
  ```java
  options.addArguments("--headless=new");
  options.addArguments("--window-size=1920,1080");
  ```

---

