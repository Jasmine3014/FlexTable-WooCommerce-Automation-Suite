# QA Automation – WordPress 6.8.3 (FlexTable & WooCommerce)

### Overview
This project is an automation test suite for WordPress 6.8.3 using **Playwright** and **Page Object Model (POM)**.  
It tests two main areas:  

1. **FlexTable Plugin** – table creation, customization, and frontend display.  
2. **WooCommerce Checkout** – end-to-end checkout and user order history.

The project ensures all functionalities work correctly and generates test evidence for validation.

---

### Prerequisites
- Node.js >= 16  
- npm (comes with Node.js)  
- Playwright  
- A WordPress 6.8.3 site with FlexTable & WooCommerce installed  
- IDE like VS Code, IntelliJ IDEA, or WebStorm  
- Git  
- **XAMPP / WAMP / MAMP** (if running WordPress locally)  

> ⚠️ Java / JDK is **not required** for this project.

---

### Project Setup

1. Clone the repository:

```bash
git clone https://github.com/Jasmine3014/FlexTable-WooCommerce-Automation-Suite.git

```

2. Install dependencies:
 ```console 
 npm install
 npx playwright install

```

3. Set up environment variables:
  - Create a .env file in the root folder:
  
```console 
WP_URL=
WP_USERNAME=
WP_PASSWORD=

```
4. Run the tests:
 ```console 
 npx playwright test

```
