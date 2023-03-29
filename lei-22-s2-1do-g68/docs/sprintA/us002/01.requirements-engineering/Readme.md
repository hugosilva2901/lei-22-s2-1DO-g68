# US 002 - To create a Task 

## 1. Requirements Engineering


### 1.1. User Story Description


As an agent, I can publish any sale announcement on the system, for example received through a phone call.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

> The RealState Agent will be responsible to publish the sale announcement on the system.
> The sale announcement can be received through a phone call.



**From the client clarifications:**

> **Question:** What is the range of the commission value? Is there a default limit, like a maximum of 50% in commission?
>
> **Answer:** I already answered this question.

> **Question:** Is it mandatory for the agent to input the commission value before publishing an announcement?
>
> **Answer:** Yes.

> **Question:** Is there any limit for the commission chosen by the agent? Are those limits defined by the Administrator?
>
> **Answer:** I already answered this question.

> **Question:** Are there only 2 types of commission or can the Administrator define more types of commission?
>
> **Answer:** For now we only have two types of commissions.

> **Question:** Are there any acceptance criteria for the agent to accept/reject an order for sale? When the agent asks to open a list of orders for sale (in the system) are these separated by some criteria, for example, the type of property, or all orders are together?
>
> **Answer:** In the beginning of Sprint C we will introduce new requirements that will clarify your questions.

> **Question:** Is it necessary to publish the owner atributes on the sale announcement?
>
> **Answer:** No.

> **Question:** About the agent comission. What is the value for the fixed amount comission? Is it the same for all agents?
>
> **Answer:** I already answered this question. The commission is for the agency and for that given property.

> **Question:** If the comission is percentage[/value] what is the value? Is it the same for all agents?
>
> **Answer:** There is no maximum and the minimum is 0. The commission is for the agency and for that given property.

> **Question:** If it's a property for lease is the comission value adjusted for the monthly value and contract duration? What is the value or method for calculating the comission?
>
> **Answer:** The commission is one value/percentage paid when the transaction is made.

> **Question:** Does the owner who contacts the company provide the information during the call or is it just for setting up a meeting, "scheduling"?
>
> **Answer:** The owner provides the information. Where did you saw that the goal is "setting up a meeting"?????

> **Question:** Is the commission applied by the agent defined by criteria that already exist in the company?
>
> **Answer:** I already answered this question.

> **Question:** Is the agent who publishes the ad solely responsible for selling the ad?
>
> **Answer:** This question doesn't make any sense.

> **Question:** Are requests for visits by customers exclusively attributed to the agent who published them?
>
> **Answer:** In Sprint C we will introduce new USs that will clarify this question.

> **Question:** Is each agent solely responsible for the advertisement it publishes?
>
> **Answer:** This question doesn't make any sense.

> **Question:** Are the properties registered in the system automatically published?
>
> **Answer:** In Sprint C we will introduce new USs that will clarify this question.

> **Question:** Can owners who sign up to register a property publish them or just register in the system and wait for the company's approval?
>
> **Answer:** In Sprint C we will introduce new USs that will clarify this question.

> **Question:** Trying to interpret both the US002 and what is listed in the request document I ran into a few question that I wanted to pose so I could better proceed with what is asked.
The document states "Owners go to one of the company's branches and meet with a real estate agent to sell or rent one or more properties, or they can use the company's application for the same purposes". Interpreting this paragraph I got the sense that the owner has two ways of putting his property up for sale or renting, either by just telling the agent all the pertinent info and letting him  handle inputting all the data into the system (going to a company branch), or  sending the data into the system himself by interacting with the application, which the agent then, after a confirmation phone call, publishes as a sale announcement.
So, my question is that, if this interpretation is correct, does the agent actually have two ways of publishing the sales announcement, one where he inputs everything directly with the owners assistance (owner goes to a company branch), and another where he just takes information already in the system, adds the commission data, and then publishes it as a sales announcement instead of a property listing.
>
> **Answer:** In US2 we get "As an agent, I can publish any sale announcement on the system, for example received through a phone call". This will be a feature/functionality of the system. The agent may receive the information by any means.

> **Question:** how exactly does the owner insert information into the application to reach the agent through a phone call?
>
> **Answer:** I do not understand your question. We have:
US2- As an agent, I can publish any sale announcement on the system, for example received through a phone call;
US4 - As an owner, I intend to submit a request for listing a property sale or rent, choosing the responsible agent.

> **Question:** The information about the property can be provided through an online request or a phone call, and in both cases, it comes from the property owner. The agent reviews advertisement requests, records the information in the system, and publishes the offer. However, if the request is made directly with the agent (through an agency) or by phone, shouldn't the owner be asked to provide information about themselves in order to identify the owner of the property being sold/rented.
>
> **Answer:** I already answered this question.

> **Question:** When a sale order arrives at the agent, what are the acceptance criteria that he (the agent) uses to accept or reject the order? Is there a possibility for an agent to refuse due to a lack of data on the property's characteristics of a property given by the owner? Or when the request arrives at the agent, are all the essential characteristics of the property in question already present?
>
> **Answer:** Yes.

> **Question:** What would be the attributes of the Owner and Agent? 
>
> **Answer:** The Owner attributes are: the name, the citizen's card number, the tax number, the address, the email address and the contact
telephone number. The Agent is an employee of the company.

> **Question:** The apartment and the land have some specific characteristics like the house? If so what are does characteristics?
>
> **Answer:** Please check the project description.

> **Question:** The act of publishing a sale announcement means that the agent is publishing a new property for sale in the system (receiving the information of the seller and publishing the new property for sale) or is it the buyer giving positive feedback to the agent with intent to buy the property(actually closing a sale, buying a property and de-listing said property)?
>
> **Answer:** In US1 we get "As an agent, I can publish any sale announcement on the system, for example received through a phone call". Additional information related with this question is also avaliable in the project description. Asking the customer something that is clear or has already been clarified is unprofessional.

> **Question:** Is the phone call the only way the agent can receive the sale announcement? Or he can receive them via e-mail/letter/etc
>
> **Answer:** For now this is the only way.
### 1.3. Acceptance Criteria


* **AC1:** The agent must input the necessary details of the sale announcement, such as the type of property, location, area in m2, requested price, and photographs, if available.
* **AC2:** The agent can access the system to publish a sale announcement.
* **AC3:** The agent can publish the sale announcement in the system, making it visible to all clients who visit the agency and use the application.


### 1.4. Found out Dependencies


* There is a dependency to "US003 Create a task category" since at least a task category must exist to classify the task being created.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* Owner's name, 
	* Property, 
	* cost
	* description
	
* Selected data:
	* Classifying task category 


**Output Data:**

* Display confirmation message

### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

#### Alternative One

![System Sequence Diagram - Alternative One](svg\us002-System-Sequence-Diagram-Alternative-One-System_Sequence_Diagram__SSD_.svg)

#### Alternative Two

![System Sequence Diagram - Alternative Two](svg\us002-System-Sequence-Diagram-Alternative-Two-System_Sequence_Diagram__SSD_.svg)

### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.