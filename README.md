This is a coding challenge

The idea of the exercice falls on correcting modeling the domin of an Army and Army battles.

Many patters were implemented and decisions were taken in order to comply to this.  Below are said decision:

1. Armys are all the same with the exception of how are they build. For this resons a Builder patter was implemented to encapsule the logic of creation.
2. Different Armies dont have any inheret beheiviour nor state different from one another. This is the reason why there is no Army superclass and civilization implementations.
3. On the other side of point 2. Unis do have different beheiviour from one another. This is why they have different implementations
4. To favour composision over inheretance, Unit is an interface and not an abstract class. There is an argument to be made about how the train() function could be implemented in the super class Unit and now have to be implemented again for each implementation of it. This argument is very valid. Some languages like Swift offer methods to have default implementation for methods in interfaces, however for the simplicity of this excercise and the reader, I chose not to use those.
5. The transformable interface is different from the Unit one because Knights do not transform into anything. This means that they would have a no-op implementation if this were down in Unit, and an error or exception would be risin. To handdle this at compile time this is handle in the type. So Units that implement Transformable are indeed, transformable and thus have access to said methods.
6. Battlefields and battleresults are classes to handle the logic of fighting and to better have separations of concerns.
7. The excersice states: "**Cada ejército posee un historial de todas las batallas en las que participó**" however it does not mention what kind of information it is stored in each battle. My personal take of this is to include, winning army, losing army and their respective strenghs.
8. Another good argument can be said about using a state patter for the transformation of Units into different one. This argument is again, very valid.
9. Even though there is no necesity for tests, stated by the excercise. Some of them were coded for my own ease of mind of testing that everything was functioning properly. My personal take would have been to use TDD all the way through but it felt against the excercise.











