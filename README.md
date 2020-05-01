# Treeserializer

This project Serializes & Deserializes Tree using Kryo Serializer.

# Steps to Execute:

     git clone git@github.com:PrabhuJoseph/treeserializer.git

     mvn clean install -DksipTests

     mvn exec:java -Dexec.mainClass="com.treeserialize.TreeSerializer"
     
# Sample Input:

                 1
            2        3
        4     5   -1   -1
     -1 -1  -1 -1

# Sample Output:

    Array is Serialized using: kryo
    Tree Before Serialize:
    1	2	3	4	5	-1	-1	-1	-1	-1	-1	
    Tree After Deserialize:
    1	2	3	4	5	-1	-1	-1	-1	-1	-1

	
