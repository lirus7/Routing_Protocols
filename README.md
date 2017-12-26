# Routing_Protocols
Implementation of Routing Protocols i.e Link-State and Bellman-Ford algorithms

The input would be a network topology given in the form of edge values between nodes e.g. a network 
of three nodes with edge values of 1, 2, and 5 will be given as A C 1 A B 2 B C 5 which indicates that edge
between A & C is of value1 and so on.

The input will be in the form of a string with "spaces" to be used for parsing the string and the string will be ended by "#" i.e. A C 1# indicates a valid network of two nodes with edge of 1. 

The output shows each step of calculation i.e. nto just the final routing table.

After calculating the routing table, the algorithm stops but doesn't end; the implementation is ready to accept a change in edge value and calculates
the routing tables again.
