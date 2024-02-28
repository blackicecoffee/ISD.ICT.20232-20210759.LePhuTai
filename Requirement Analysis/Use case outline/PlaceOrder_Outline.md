# Use case: Place order

### **Brief description:** Allow customer to place and pay for their order
### **Actors:** Customer

### **Precondition:** Customer has browsed or searched for products and added them to the cart.

### **Basic Flow:**

1. **Customer:** Reviews cart and selects products to purchase.
2. **Customer:** Requests to place order.
3. **System:**
    - Checks inventory for each product in the cart.
    - If inventory is sufficient, continue to step 4.
4. **System:** Displays delivery information form.
5. **Customer:** Enters or updates delivery information (recipient name, email, phone number, province/city, address).
6. **System:**
    - Calculates or recalculates delivery fee based on weight and location.
    - Displays temporary invoice:
        - List of products in cart
        - Quantity
        - Product prices
        - Total product price (excluding VAT)
        - Total product price (including VAT)
        - Delivery fee
        - Total amount to be paid
7. **Customer:** Reviews and confirms invoice information.
8. **Customer:** Selects rush order delivery (optional).
9. **Customer:** Adjusts delivery method or purchased items (if necessary).
10. **System:** Recalculates delivery fees and updates invoice.
11. **Customer:** Selects and provides information for a payment method supported by VNPay.
12. **System:** Processes payment through VNPay.
13. **System:**
    - On successful payment:
        - Displays transaction details (ID, cardholder name, amount, date/time).
        - Sends order and transaction information to the customer's email.
        - Changes order status to "pending processing."
        - Records transaction and order information.
14. **Customer:** (Optional) Can review or cancel the order using the link in the email.

### **Alternative Flows:**

1. **Insufficient Inventory:**
- **Triggered:** At step 2, when the system detects insufficient inventory for any item in the cart.
- **Action:**
    - The system prompts the customer to update the cart, highlighting the products with insufficient stock and their lacking quantities.
    - Customer updates cart or cancels order.
2. **Rush Order Processing:**
- **Triggered:** When the customer selects rush order delivery in step 8.
- **Action:**
    - **System:** Checks delivery address and product eligibility for rush order.
        - If not eligible, prompt customer to update delivery information or delivery method.
        - If eligible, request additional rush order information (delivery time, instructions).
	- **Customer:** Adjusts delivery method or purchased items (if necessary).
	- **System:** Recalculates delivery fees and updates invoice.
3. **Customer exits the order process at any step**
4. **Payment fails:**
    - System informs the customer and allows them to retry payment or exit the order process.
5. **Invalid Delivery Information:**
- **Triggered:** During any step where the customer enters or updates delivery information.
    - The system can identify invalid information based on pre-defined rules
- **Action:**
    - The system highlights the specific field(s) containing invalid information and provides an error message explaining the issue.
	- **Customer:** Corrects the invalid information and confirms delivery information again.
	- **System:**
	    - Validates the information again.
	    - If valid, continues with the normal flow from the point of interruption.
	    - If still invalid, repeats the process of highlighting errors and prompting for correction.

### **Postcondition:**

- **Successful order:**
    - Customer receives email confirmation and order is in "pending processing" state.
- **Cancelled order:**
    - Customer receives confirmation email and full refund is processed.
