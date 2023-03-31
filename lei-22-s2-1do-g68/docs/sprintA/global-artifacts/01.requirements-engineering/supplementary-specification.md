# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._


- The application must allow buyers who visit its stores/agencies to access the
properties available for lease or sale;
- The application must allow employees to publishing rental and sale advertisements;
- The application must allow employees to registering a business;
- The application must allow employees to scheduling and registering visits to the property;
- The application must allow owner to provide property characteristics;
- The application must allow owner to provide property price;
- The application must allow owner to send the request with the characteristics to an agent;
- The application must allow agents to set comission and publish the offer after receving the request;
- The application must allow owners to provide different tipe of information depending on the type of the property;

## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

- The system's user UI must be simple to use for both clients and employees;
- The program should provide users with useful feedback after each move;
- The system must provide consumers with a fast viewing experience and be responsive;
- The registration must include thorough instructions on how to use the technology;



## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._


- The application should use object serialization to ensure data persistence between two runs of the
application;
- The system must be highly available, enabling users to utilize the program whenever they want;
- The program must resist failures and stop data loss;
- The system must be able to handle numerous concurrent users without experiencing speed decline;

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._


- The system must offer quick turnaround periods for property info retrieval and inquiry;
- The program needs to be able to manage lots of people and data;
- Reports must be produced by the system quickly and effectively;


## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 

- All the images/figures produced during the software development process should be recorded in SVG format
use Javadoc to generate useful documentation for Java code;
- The program needs to be simple to update and manage;
- Useful error notifications and records must be provided by the system for debugging reasons;
- The application must support the English language;
- The software research and design staff must follow best practices when determining requirements;
- All functions must be subjected to unit testing, with the exception of those that perform input/output tasks;
- Javadoc should be used by the program to create helpful instructions for Java code;




## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._


- The application must be developed in Java language using the IntelliJ IDE or NetBeans;


### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._


- The Java programming language must be used to create the application, and JavaFX 11 must be used to create the graphical user interface;
- To guarantee a high quality final result, the application must be created using the Agile approach with numerous revisions and continuous merging;
- Industry standard software development tools, such as Git for version control, Maven for project management, and Jenkins for continuous testing, must be used to create the application;



### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._


- A password with seven alphanumeric characters three uppercase letters and two digits must be used to identify users of the program;
- The application must have a user friendly interface that enables both clients and workers to navigate and use it with ease;
- The application must have a responsive design that adapts to various screen sizes and be usable on both PC and mobile platforms;
- When a user completes an action, such as sending a property ad or arranging a visit, the application must give them clear feedback;


### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

- To guarantee data availability and integrity in the case of a system breakdown or catastrophe, the application needs to be routinely backed up;

