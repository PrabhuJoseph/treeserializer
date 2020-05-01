# treeserializer

This project Serializes & Deserializes Tree using Kryo Serializer.

# Steps to Execute:

HW12663:treeserailizer pjoseph$ mvn clean install -DksipTests

HW12663:treeserailizer pjoseph$ mvn exec:java -Dexec.mainClass="com.treeserialize.TreeSerializer"
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building com.treeserailizer 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ com.treeserailizer ---
Array is Serialized using: kryo
Tree Before Serialize:
1	2	3	4	5	-1	-1	-1	-1	-1	-1	
Tree After Deserialize:
1	2	3	4	5	-1	-1	-1	-1	-1	-1	
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 0.765 s
[INFO] Finished at: 2020-05-01T18:43:54+05:30
[INFO] Final Memory: 11M/309M
[INFO] ------------------------------------------------------------------------
