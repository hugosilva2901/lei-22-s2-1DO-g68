# US 006 - To create a Task 

## 1. Requirements Engineering


### 1.1. User Story Description


As a system administrator, I want to register a new employee.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**
The company's systems administrator will be responsible for registering all employees
(specifying the name, descriptions, tax number,address, email address, phone number and the role of the employee) and branches of the network
(specifying the designation, location) as well as preparing the system in order to facilitate the insertion of advertisements and facilitate the use of applications by employees.

**From the client clarifications:**

> **Question:** Which is the unit of measurement used to estimate duration?
>  
> **Answer:** Duration is estimated in days.


> **Question:** Monetary data is expressed in any particular currency?
>  
> **Answer:** Monetary data (e.g. estimated cost of a task) is indicated in POTs (virtual currency internal to the platform).


### 1.3. Acceptance Criteria

* **AC1:** All required fields must be filled in.
* **AC2:** If the store already has a Store Manager, the only role that can be assigned to a new employee is "ROLE_REAL_ESTATE_AGENT".
* **AC3:** When creating a task with an already existing reference, the system must reject such operation and the user must have the change to modify the typed reference.
* **AC4:** The personal Information must correspond.

### 1.4. Found out Dependencies


* There is a dependency to "US003 Create a task category" since at least a task category must exist to classify the task being created.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
    * name
    * descriptions
    * tax number
    * address
    * email address
    * phone number
    * password
	
* Selected data:
	* Role of the employee
    * Branch of the network


**Output Data:**
+
* List of existing employees
* List of existing branches
* List of existing roles
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

#### Alternative One

![Sequence Diagram- Alternative One](puml/us003-Sequence-diagram-alternative-one.puml)


### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.