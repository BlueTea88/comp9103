javac DoubleValuesFile.java
javac SearchValue.java
javac SortValues.java
javac DisplayValues.java

java DoubleValuesFile test.txt 123 abc 120. 02.012 8800 800
java SearchValue test.txt
abc
java SearchValue test.txt
123
java SearchValue test.txt
2
java SortValues test.txt true
java DisplayValues test.txt
java SortValues test.txt false
java DisplayValues test.txt
