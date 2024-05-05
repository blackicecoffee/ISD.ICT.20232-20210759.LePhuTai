# Interface: IPayment

### **Name:** IPayment.
### **Description:**
This interface is used to illustrate the relation between AIMS software and Interbank and provide methods for communication between them.

### **Operation definition:**
- payOrder():
    - Is used to send request from client to subsystem.
    - Arguments: invoice: Invoice / amount: double, orderInfo: String, client: Client.
    - Return value: none.
    - Return type: void.

### **Documentation:**

# Boundary: VNPayDisplay

### **Name:** VNPayDisplay.
### **Description:**
This boundary is used to show GUI while transaction process is happening.

### **Operation definition:**
- disPlayURL():
    - Show the URL
    - Arguments: none.
    - Return value: none.
    - Return type: void.
- checkURLChange():
    - Check if the URL is changed.
    - Arguments: none.
    - Return value: none.
    - Return type: void.
    - Sub-operation: **close():** close the UI when finished.
### **Documentation:**

# Controller: PayOrderManager

## Detail in **Pay Order specification**.
### **Name:** PayOrderManager.
### **Description:**
This controller is used to manage the flow of transaction.

### **Operation definition:**
- payOrder():
    - Is used to send request from client to subsystem.
    - Arguments: invoice: Invoice / amount: double, orderInfo: String, client: Client.
    - Return value: none.
    - Return type: void.
- processResponse():
    - process the response come from VNPayDisplay.
    - Arguments: queryString: String.
    - Return value: none.
    - Return type: void.
- updateTransactionOnSuccess():
    - update the transaction info if the transaction is successed.
    - Arguments: trans: Transaction.
    - Return value: none.
    - Return type: void.
- updateTransactionOnSuccess():
    - update the transaction info if the transaction is failed.
    - Arguments: exception.
    - Return value: none.
    - Return type: void.
### **Documentation:**
