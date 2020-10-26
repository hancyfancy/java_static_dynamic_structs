#!/bin/sh

javac --source-path ./corestructs/ -d . ./corestructs/*.java
jar cf ./lib/corestructs.jar ./corestructs/*.class
find ./corestructs/ -type f -name '*.class' -delete
