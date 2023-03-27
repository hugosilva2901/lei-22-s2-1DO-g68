# US 005 - To register a Store 

## 1. Requirements Engineering

### 1.1. User Story Description

As a system administrator, I want to register a store.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	Each store in the network has a store manager and the set of stores is managed by a store network
manager.

**From the client clarifications:**

> **Question:** Does a store designation have to be detailed?
>  
> **Answer:** The ID is an integer number. An example of the store location is: 71 ST. NICHOLAS DRIVE, NORTH POLE, FAIRBANKS NORTH STAR, AK, 99705. An example phone number is (907) 488-6419.


> **Question:** When a System Administrator (admin) makes a request to register a new employee or a new network branch (or any other alteration), does the System ask for the admin credentials (login, password)?
>  
> **Answer:** The System Administrator should be logged in the application.

> **Question:** To register an employee I need to allocate him with a branch. To register a branch I need an employee (to be local manger) but I can't create the employee because I have no branch and I can’t create the branch because I have no employee.
>
> **Answer:**  Thank you for identifying this issue. We already updated the project description. When a store is created in the system, the System Administrator should not set the Store Manager.
When registering a store, the System Administrator should introduce the following information: an ID, a designation/name, a location, a phone number and an e-mail address.



### 1.3. Acceptance Criteria


* **AC1:** All required fiels must be filled in.
* **AC2:** Id is an integer number.
* 
### 1.4. Found out Dependencies

* No Dependency Found

### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* an ID, 
	* a designation/name
	* a location
	* a phone number
	* an e-mail address

**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

![System Sequence Diagram](docs/sprintA/us005/01.requirements-engineering/svg/us005-SystemSequenceDiagram.svg)

### 1.7 Other Relevant Remarks

* The created Store can be assigned to a employee(Store manager).