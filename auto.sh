javac -cp stdlib-package.jar:algs4-package.jar src/graph/Graph.java
cd src
java -cp .:../* graph/Graph ../data/tinyCG.txt
cd ..
