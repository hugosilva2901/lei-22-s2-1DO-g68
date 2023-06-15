# US 009 - To create a Task

## 3. Design - User Story Realization

### 3.1. Rationale

**SSD - Alternative 1 is adopted.**

| Interaction ID | Question: Which class is responsible for...    | Answer                        | Justification (with patterns)                                                                                 |
|:---------------|:-----------------------------------------------|:------------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		     | 	... interacting with the actor?               | MessageVisitRequestUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		        | 	... coordinating the US?                      | MessageVisitRequestController | Controller                                                                                                    |
| Step 2  		     | 	...knowing the ListOfVisitingRequest to show? | VisitRequestRepository        | IE: knows all its VisitRequest                                                                                |
| Step 3  		     | 	... saving the selected VisitRequest ?        | MessageVisit                  | IE: object created in step 1                                                                                  |
| 			  		        | 	Returning the VisitRequest in a DTO ?         | Mapper                        | Class created with that objective and know all it methods of creation                                         |
| Step 4  		     | 	...knowing the Agent login?                   | AnnouncementRepository        | IE: knows all the credentials and who is login in the moment                                                  |
| Step 5  		     | 	... saving the Agent client?                  | MessageVisit                  | IE: object created in step 1 is classified in one or more roles.                                              |
| Step 6  		     | 							                                        |                               |                                                                                                               |              
| Step 7  		     | 	... validating all data (local validation)?   | MessageVisit                  | IE: owns its data.                                                                                            | 
| 			  		        | 	... validating all data (global validation)?  | MessagesOfClientRepository    | IE: knows all its orders.                                                                                     | 
| 			  		        | 	... saving the created message?               | MessagesOfClientRepository    | IE: owns all its orders.                                                                                      | 
| Step 9  		     | 	... informing operation success?              | MessageVisitRequestUI         | IE: is responsible for user interactions.                                                                     |
| Step 10  		    | 	... informing operation success?              | MessageVisitRequestUI         | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are:

* MessagesOfClientRepository
* MessageVisit
* VisitRequestRepository
* VisitRequest

Other software classes (i.e. Pure Fabrication) identified:

* CreateVisitRequestUI
* CreateVisitRequestController

## 3.2. Sequence Diagram (SD)

### Alternative 1 - Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us016-sequence-diagram-full.svg)

### Alternative 2 - Split Diagram

This diagram shows the same sequence of interactions between the classes involved in the realization of this user story,
but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses interaction ocurrence.

![Sequence Diagram - split](svg/us016-sequence-diagram-split.svg)

**Get Announcement List**

![Sequence Diagram - Partial - Get Clients List](svg/us016-sequence-diagram-partial-get-Employee.svg)

**Create Visit Request**

![Sequence Diagram - Partial - Create Announcement](svg/us016-sequence-diagram-partial-get-Boking-Request-list.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us016-class-diagram.svg)