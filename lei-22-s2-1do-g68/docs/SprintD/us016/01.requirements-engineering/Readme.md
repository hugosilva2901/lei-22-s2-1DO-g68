# US 009 - To create a Task 

## 1. Requirements Engineering


### 1.1. User Story Description


As a client, I want to leave a message to the agent to schedule a visit to a property of my interest.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

> The client will be responsible to leave a message to inform the agent of the request to schedule a visit.
> The Request can be received through a phone call.



**From the client clarifications:**

> **Question:** What if the client wants to schedule a visit to more than one property?
>
> **Answer:** The client can schedule a visit to more than one property, but only if the visits do not conflict with one another.

> **Question:** What if the client wants to schedule a visit to a property that is already scheduled for a visit?
>
> **Answer:** The client can not schedule a visit to a property that is already scheduled for a visit.

> **Question:** What if the client wants to schedule a visit to a property that is already sold?
> 
> **Answer:** The client can not schedule a visit to a property that is already sold.

### 1.3. Acceptance Criteria


* **AC1:** It is necessary to provide a list of available properties that is organized.
* **AC2:** The name, email, phone and date, for the property tour must also be included in the message.
* **AC3:** Multiple visit requests from the same client are allowed, but only provided they do not conflict with one another.
* **AC4:** When the request is legitimate and recorded in the system, the client must get a success message.

### 1.4. Found out Dependencies


* The agent have to be logged in the system to register a new schedule visit.

### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* name
	* email	
    * phone
    * date
    * 

* Selected data:
    * Select date
    * Select property


**Output Data:**

* Display confirmation message

### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

#### Alternative One

![System Sequence Diagram - Alternative One](svg\us009-System-Sequence-Diagram-Alternative-One-System_Sequence_Diagram__SSD_.svg)

### 1.7 Other Relevant Remarks

* The visit request stays in a "not schedule" state in order to distinguish from schegule visits.