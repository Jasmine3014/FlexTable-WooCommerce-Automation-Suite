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

### **Test Cases**

🅰️ Part A — FlexTable: Automation Test Cases
1️⃣ Test Case 1: Verify WordPress Login Functionality
Objective: Ensure the user can successfully log in to the WordPress Admin Panel.

Steps:

1. Navigate to the WordPress login page.

2. Enter valid username and password.

3. Click the Log In button.

Expected Result:

- User is redirected to the WordPress Dashboard without errors.

2️⃣ Test Case 2: Verify FlexTable Plugin Activation Status
Objective: Validate that the FlexTable plugin is active; if not, install and activate it.

Steps:

1. Navigate to Plugins → Installed Plugins.

2. Search for the FlexTable plugin.

3. If plugin is inactive, click Activate.

4. If plugin is not installed, upload the plugin ZIP or install it from the repository and activate it.

Expected Result:

- FlexTable plugin is active and visible under the WordPress Plugins list.

3️⃣ Test Case 3: Navigate to FlexTable Dashboard
Objective: Confirm that the FlexTable Dashboard loads correctly.

Steps:

1. From WP Admin, navigate to FlexTable → Dashboard.

2. Wait for the page to fully load.

Expected Result:

- FlexTable Dashboard UI is displayed without errors.

4️⃣ Test Case 4: Create a New Table Using Google Sheet Input
Objective: Create a new FlexTable using a Google Sheet URL, table title, and table description.

Steps:

1. On FlexTable Dashboard, click Create New Table.

2. Enter the Google Sheet URL, Table Title, and Table Description.
    Note: you can use this sample sheet link

3. Fetch & Save the table.

4. Return to the Dashboard.

Expected Result:

- A new table entry appears in the FlexTable Dashboard list.

- Table name is displayed correctly.

5️⃣ Test Case 5: Verify Table Display Using Shortcode
Objective: Confirm the table renders correctly on the frontend using its shortcode.

Steps:

1. Copy the table shortcode from the FlexTable Dashboard.

2. Create a new page via WP-CLI or WP Admin and insert the shortcode.

3. Open the frontend page and verify that 3–5 random table cells match the Google Sheet data.

Expected Result:

- Table matches the Google Sheet data.

- No broken layout or data mismatch.

6️⃣ Test Case 6: Enable 'Show Table Title' and 'Show Table Description Below Table
Objective: Verify layout options under Table Customization → Layout.

Steps:

1. Open Edit Table for the table.

2. Go to Table Customization → Layout.

3. Enable 'Show Table Title' and 'Show Table Description Below the Table'.

4. Click Fetch & Save.

5. Visit the table on the frontend.

Expected Result:

- Table title appears above the table.

- Table description appears below the table.

7️⃣ Test Case 7: Enable Entry Info & Pagination
Objective: Verify Show Entry Info and Show Pagination options appear on the frontend.

Steps:

1. Navigate to Edit Table page.

2. Go to Layout → Table Bottom Elements.

3. Enable Show Entry Info and Show Pagination.

4. Click Fetch & Save.

5. Visit the frontend table page and validate by class/Style.

Expected Result:

- Entry Info displays correctly.

- Pagination is visible and functional.

- No layout issues (validated by class/Style).

8️⃣ Test Case 8: Update 'Rows Per Page & Table Height'
Objective: Ensure styling options apply correctly on the frontend.

Steps:

1. Go to Table Customization → Styling.

2. Select a random value for Rows per page.

3. Select a value for Table height.

4. Click Fetch & Save.

5. Visit the frontend and validate by class/Style.

Expected Result:

- Rows per page matches selected value.

- Table height matches selected value.

9️⃣ Test Case 9: Delete the Table and Verify Frontend Removal
Objective: Ensure deleted tables no longer load on the frontend.

Steps:

1. Go to FlexTable Dashboard.

2. Delete the table.

3. Revisit the page containing the shortcode.

Expected Result:

- Table does not display.

- Proper error or empty state message appears.


🅱️ Part B — WooCommerce Test Scenarios
1️⃣ Scenario 1: End-to-End Checkout Flow
A user adds products to the cart, enters billing/shipping info, selects payment, and completes the order.

Expected Results:

- Cart totals calculated correctly including tax/shipping.

- Payment is processed successfully.

- Order appears correctly in WooCommerce backend.

2️⃣ Scenario 2: User Account Order History
Verify that registered users can view their complete order history.

Expected Results:

- Completed orders appear in user account order history.

- Order details match backend records.
