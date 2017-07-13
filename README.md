# Lambda Expression (JDK8) Demo

In the DemoLambda class, Person class is defined and roster is built as a list of persons, and the main method will demostrate a series of actions toward roster thus some additional methods are needed. 

In essence, these additional methods are functional method. So when we refactor them into lambda expression they will then become more generic, meaningful and reusable. 

I follow the official manual of lambda expression from oracle and build this demo based on its provided [examples]($TUTORIALS_HOME/java/javaOO/lambdaexpressions.html). 

## Stages
According to the tutorial, I commit the code by stage shown below:

### Stage 0: Minimal Valid Product
In this stage, we use modest way to build the functionable DemoLambda class with structure:
```
DemoLambda
    + roster: List<Person>
    + main(String[]): void
        <calls> printPersonOlderThan 15
        <calls> printPersonOlderThan 18
        <calls> printPersonYoungerThan 15
        <calls> printPersonYoungerThan 18
        <calls> printPersonWithinAgeRange 15~18
        <calls> printPersonAdultMale
        <calls> printPersonFemale
        <calls> refreshAgeByServer(List<Person>, int): void 
        <calls> refreshAddressByServer(List<Person>, int): void

    + printPersonOlderThan(List<Person>, int): void
    + printPersonYoungerThan(List<Person>, int): void
    + printPersonWithinAgeRange(List<Person>, int, int): void
    + printPersonAdultMale(List<Person>): void
    + printPersonFemale(List<Person>): void
    + refreshAgeByServer(List<Person>, int): void //say datas stored on servers
    + refreshAddressByServer(List<Person>, int): void

    + Person
        + getters & setters
        + toString(): String
```

### Stage 1: Custom Mapper Interface
In this stage, we generic the printPerson methods with a checker/mapper/filter interface so that different functional knowledge can be encapsulated into separate class:
```
DemoLambda
    + roster: List<Person>
    + main(String[]): void
        <calls> printPerson x 7 times

    + printPerson(List<Person>, CheckPerson): void
    + refreshPersonAge(List<Person>, CheckPerson): void
    + refreshPersonAddress(List<Person>, CheckPerson): void

    + CheckPerson - interface
    + CheckPersonOlderThan15 - impl
    + CheckPersonOlderThan18 - impl
    + CheckPersonYoungerThan15 - impl
    + CheckPersonYoungerThan18 - impl
    + CheckPersonWithinRange15To18 - impl
    + CheckPersonAdultMale - impl
    + CheckPersonFemale - impl
    + CheckPersonServer - impl

    + Person
        + getters & setters
        + toString(): String
```

### Stage 2: Use anonymous class as checkers/mappers/filters
Though the printPerson method became reusable, there are too many impl of CheckPerson is needed in the future, so we can move all of them to anonymous class since it has only 1 method to override in the interface:
```
DemoLambda
    + roster: List<Person>
    + main(String[]): void
        <calls> printPerson x 7 times w/ anonymous class
        <calls> refreshPersonAge w/ anonymous class
        <calls> refreshPersonAddress w/ anonymous class

    + printPerson(List<Person>, CheckPerson): void
    + refreshPersonAge(List<Person>, CheckPerson): void
    + refreshPersonAddress(List<Person>, CheckPerson): void

    + CheckPerson - interface

    + Person
        + getters & setters
        + toString(): String
```

### Stage 3: Use lambdaexpressions replace anonymous class
Why? simplified the code and make the meaning of code more accurate.
```
DemoLambda
    + roster: List<Person>
    + main(String[]): void
        <calls> printPerson x 7 times w/ Lambda
        <calls> refreshPersonAge w/ Lambda
        <calls> refreshPersonAddress w/ Lambda

    + printPerson(List<Person>, CheckPerson): void
    + refreshPersonAge(List<Person>, CheckPerson): void
    + refreshPersonAddress(List<Person>, CheckPerson): void

    + CheckPerson - interface

    + Person
        + getters & setters
        + toString(): String
```

### Stage 4: Use Predicate<T> replace CheckPerson interface
Why? no new domain-dependent interface/ class is needed
```
DemoLambda
    + roster: List<Person>
    + main(String[]): void
        <calls> printPerson x 7 times w/ Lambda
        <calls> refreshPersonAge w/ Lambda
        <calls> refreshPersonAddress w/ Lambda

    + printPerson(List<Person>, Predicate<T>): void
    + refreshPersonAge(List<Person>, Predicate<T>): void
    + refreshPersonAddress(List<Person>, Predicate<T>): void

    + Person
        + getters & setters
        + toString(): String
```

### Stage 5: Use Consumer<T> to turns printPerson generic
Why? Decouple printPerson method from "print" to processPerson
```
DemoLambda
    + roster: List<Person>
    + main(String[]): void
        <calls> processPerson x 9 times w/ Lambda

    + processPerson(List<Person>, Predicate<T>, Consumer<T>): void

    + Person
        + getters & setters
        + toString(): String
```
