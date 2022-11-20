# FIFA-World-Cup-Statistics

## An app to quickly lookup FIFA match statistics.

### Description
This is a small web-application I am developing using Spring Boot and Spring Batch. 
With the 2022 FIFA World Cup starting soon I am participating in a small betting pool with a group of friends. 
As a person who doesn't know anything about football my chances of winning are pretty limited. I figured the only way 
the predictions i make can make any sense is to base them on past results. The goal of this app is to help myself and all people 
who find themselves in a situation like mine to easily lookup past match statistics between two teams. 

### Workings
The application uses Spring Batch to ingest a CSV file containing information of all the FIFA matches that were played between
2010 and 2022. The data is read at startup and persisted to an in-memory database (H2). A React frontend serves the data to a user. 


### Finally
This is a personal project and a work in progress; I might add extra functionality to it later. It is mainly a way to solve a problem I have
(the lack of knowledge about footbal) and a way to train myself using Spring Framework and discover Spring Batch. Right now I'm not looking for contributers.  