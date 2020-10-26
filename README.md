# Java implementation of list, set and bidirectional map
Simple one dimensional and two dimensional data structures.

# How to build for Linux?
## Prerequisites
1. Download Java tarball:
    - [Java](https://www.java.com/en/download/manual.jsp "Java download page")
1. Install Java:
    - Change to the directory in which you want to install. Type:  
     `cd directory_path_name`  
      For example, to install the software in the /usr/java/ directory, Type:  
     `cd /usr/java/`  
    - Move the .tar.gz archive binary to the current directory.
    - Unpack the tarball and install Java by issuing the following command:  
     `tar zxvf jre-8u73-linux-i586.tar.gz`
    - The Java files are installed in a directory called jre1.8.0_73 in the current directory.  
      In this example, it is installed in the /usr/java/jre1.8.0_73 directory.
    - Delete the .tar.gz file if you want to save disk space.
## Compile & Run locally:
1. Change file permissions:
    - `chmod +x *.sh`
2. Compile:
    - `./clean.sh`
    - `./build.sh`
3. Run locally(e.g, Ubuntu):
    - `./run.sh`

# How to build for Windows?
## Prerequisites
1. Download Java executable:
    - [Java](https://www.java.com/en/download/manual.jsp "Java download page")
2. Install Mono:
    - Run the .exe
    - Open the Start Menu
    - Right-click on Computer and click Properties
    - Click Advanced system settings
    - Make sure you're on the Advanced tab
    - Click Environment Variables
    - Under System variables, scroll to find the `JAVA_HOME` variable
    - Click on Path and then click Edit
    - Add path to Java (e.g. `C:\"Program Files"\Java\jdk-13.0.2`) as variable value for `JAVA_HOME` variable
    - Click OK on all menus
## Compile & Run locally:
1. Change file permissions:
    - `cacls *.sh /g everyone:f`
2. Compile:
    - `sh clean.sh`
    - `sh build.sh`
3. Run locally:
    - `sh run.sh`

# Sample output
```
--------------------Static item store
[{Index 0: -128}, {Index 1: 127}, {Index 2: 1}, {Index 3: 8}]

[{Index 0: -32768}, {Index 1: 32767}, {Index 2: 2}, {Index 3: 16}]

[{Index 0: -2147483648}, {Index 1: 2147483647}, {Index 2: 4}, {Index 3: 32}]

[{Index 0: -9223372036854775808}, {Index 1: 9223372036854775807}, {Index 2: 8}, {Index 3: 64}]

[{Index 0: 1.4E-45}, {Index 1: 3.4028235E38}, {Index 2: 4}, {Index 3: 32}, {Index 4: -126}, {Index 5: 127}, {Index 6: -Infinity}, {Index 7: Infinity}, {Index 8: 1.17549435E-38}, {Index 9: NaN}]

[{Index 0: 4.9E-324}, {Index 1: 1.7976931348623157E308}, {Index 2: 8}, {Index 3: 64}, {Index 4: -1022}, {Index 5: 1023}, {Index 6: -Infinity}, {Index 7: Infinity}, {Index 8: 2.2250738585072014E-308}, {Index 9: NaN}]

[{Index 0: ?}, {Index 1: ?}, {Index 2: ?}, {Index 3: ￿}, {Index 4: ?}, {Index 5: ?}, {Index 6: ?}, {Index 7: }]

[{Index 0: false}, {Index 1: true}]

[{Index 0: Fellow}, {Index 1: Mellow}, {Index 2: Yellow}, {Index 3: Bellow}]

[{Index 0: Thread[Thread-0,5,main]}, {Index 1: java.lang.Error}, {Index 2: java.lang.Exception}, {Index 3: java.lang.SecurityManager@508dec2b}]

--------------------Static item store replace item
[{Index 0: null}, {Index 1: null}, {Index 2: null}, {Index 3: null}]
[{Index 0: 1}, {Index 1: 3}, {Index 2: 9}, {Index 3: 5}]
[{Index 0: 0}, {Index 1: 0}, {Index 2: 0}, {Index 3: 0}]
[{Index 0: 0}, {Index 1: 7}, {Index 2: 0}, {Index 3: 0}]
Item at index 3 = 0

--------------------Dynamic item store
[{Index 0: -128}, {Index 1: 127}, {Index 2: 1}, {Index 3: 8}]

[{Index 0: -32768}, {Index 1: 32767}, {Index 2: 2}, {Index 3: 16}]

[{Index 0: -2147483648}, {Index 1: 2147483647}, {Index 2: 4}, {Index 3: 32}]

[{Index 0: -9223372036854775808}, {Index 1: 9223372036854775807}, {Index 2: 8}, {Index 3: 64}]

[{Index 0: 1.4E-45}, {Index 1: 3.4028235E38}, {Index 2: 4}, {Index 3: 32}, {Index 4: -126}, {Index 5: 127}, {Index 6: -Infinity}, {Index 7: Infinity}, {Index 8: 1.17549435E-38}, {Index 9: NaN}]

[{Index 0: 4.9E-324}, {Index 1: 1.7976931348623157E308}, {Index 2: 8}, {Index 3: 64}, {Index 4: -1022}, {Index 5: 1023}, {Index 6: -Infinity}, {Index 7: Infinity}, {Index 8: 2.2250738585072014E-308}, {Index 9: NaN}]

[{Index 0: ?}, {Index 1: ?}, {Index 2: ?}, {Index 3: ￿}, {Index 4: ?}, {Index 5: ?}, {Index 6: ?}, {Index 7: }]

[{Index 0: false}, {Index 1: true}]

[{Index 0: Fellow}, {Index 1: Mellow}, {Index 2: Yellow}, {Index 3: Bellow}]

[{Index 0: Thread[Thread-1,5,main]}, {Index 1: java.lang.Error}, {Index 2: java.lang.Exception}, {Index 3: java.lang.SecurityManager@7486b455}]

--------------------Dynamic sorted item store
[{Index 0: 533}, {Index 1: 1292}, {Index 2: 1538}, {Index 3: 1756}]

[{Index 0: Bellow}, {Index 1: Fellow}, {Index 2: Mellow}, {Index 3: Yellow}]

--------------------Dynamic item store replace item
[{Index 0: 1}, {Index 1: 3}, {Index 2: 9}, {Index 3: 5}]

[{Index 0: 1}, {Index 1: 3}, {Index 2: 7}, {Index 3: 5}]

--------------------Dynamic item store insert item
[{Index 0: 1}, {Index 1: 3}, {Index 2: 9}, {Index 3: 5}]

[{Index 0: 1}, {Index 1: 3}, {Index 2: 7}, {Index 3: 9}, {Index 4: 5}]

[{Index 0: 8}, {Index 1: 1}, {Index 2: 3}, {Index 3: 7}, {Index 4: 9}, {Index 5: 5}]

[{Index 0: 8}, {Index 1: 1}, {Index 2: 3}, {Index 3: 7}, {Index 4: 9}, {Index 5: 5}, {Index 6: 4}]

Index of 9 = 4
Item at index 3 = 7

--------------------Dynamic unique item store
[{Index 0: 1}, {Index 1: 2}, {Index 2: 3}]

[{Index 0: a}, {Index 1: b}, {Index 2: c}]

--------------------Dynamic key value store
Index 0: Key -> Yukon, Value -> 8
Index 1: Key -> Bicker, Value -> 9
Index 2: Key -> Shulz, Value -> 7
Index 3: Key -> Jems, Value -> 3

Index 0: Key -> 1, Value -> [{Index 0: null}, {Index 1: null}, {Index 2: null}, {Index 3: null}]

Index 1: Key -> 2, Value -> []

Index 2: Key -> 3, Value -> []


--------------------Dynamic sorted key value store
Index 0: Key -> 3, Value -> Jems
Index 1: Key -> 7, Value -> Shulz
Index 2: Key -> 17, Value -> Shulz
Index 3: Key -> 88, Value -> Yukon
Index 4: Key -> 832, Value -> Blitzer

7 -> Shulz
Blitzer <- 832

Index 0: Key -> Bicker, Value -> 9
Index 1: Key -> Jems, Value -> 3
Index 2: Key -> Shulz, Value -> 7
Index 3: Key -> Yukon, Value -> 8

Yukon -> 8
3 <- Jems
```
