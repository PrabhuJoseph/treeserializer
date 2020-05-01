# treeserializer

This project Serializes & Deserializes Tree using Kryo Serializer.

# Steps to Execute:

HW12663:treeserailizer pjoseph$ mvn clean install -DksipTests

HW12663:treeserailizer pjoseph$ mvn exec:java -Dexec.mainClass="com.treeserialize.TreeSerializer"

Array is Serialized using: kryo
Tree Before Serialize:
1	2	3	4	5	-1	-1	-1	-1	-1	-1	
Tree After Deserialize:
1	2	3	4	5	-1	-1	-1	-1	-1	-1	
