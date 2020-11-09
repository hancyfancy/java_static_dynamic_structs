/*
BSD 3-Clause License

Copyright (c) 2020, hancyfancy
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
   contributors may be used to endorse or promote products derived from
   this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

import corestructs.*;
import java.io.File;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("--------------------Static item store");
    
        //ItemStore<?> StaticStore = new StaticStore<int>(4); //cannot find symbol
        //StaticStore<?> StaticStore = new StaticStore<int>(4); //unexpected type
        
        //StaticStore<Byte> staticInvalidShortStore = new StaticStore<Byte>(-1);
        StaticStore<?> staticByteStore = new StaticStore<Byte>(4);
        staticByteStore.add(Byte.MIN_VALUE);
        staticByteStore.add(Byte.MAX_VALUE);
        staticByteStore.add(Byte.BYTES);
        staticByteStore.add(Byte.SIZE);
        //staticByteStore.add(5);
        System.out.print(staticByteStore);
        System.out.print("\n");

        StaticStore<?> staticShortStore = new StaticStore<Short>(4);
        staticShortStore.add(Short.MIN_VALUE);
        staticShortStore.add(Short.MAX_VALUE);
        staticShortStore.add(Short.BYTES);
        staticShortStore.add(Short.SIZE);
        System.out.print(staticShortStore);
        System.out.print("\n");

        StaticStore<?> staticIntegerStore = new StaticStore<Integer>(4);
        staticIntegerStore.add(Integer.MIN_VALUE);
        staticIntegerStore.add(Integer.MAX_VALUE);
        staticIntegerStore.add(Integer.BYTES);
        staticIntegerStore.add(Integer.SIZE);
        System.out.print(staticIntegerStore);
        System.out.print("\n");

        StaticStore<?> staticLongStore = new StaticStore<Long>(4);
        staticLongStore.add(Long.MIN_VALUE);
        staticLongStore.add(Long.MAX_VALUE);
        staticLongStore.add(Long.BYTES);
        staticLongStore.add(Long.SIZE);
        System.out.print(staticLongStore);
        System.out.print("\n");

        StaticStore<?> staticFloatStore = new StaticStore<Float>(10);
        staticFloatStore.add(Float.MIN_VALUE);
        staticFloatStore.add(Float.MAX_VALUE);
        staticFloatStore.add(Float.BYTES);
        staticFloatStore.add(Float.SIZE);
        staticFloatStore.add(Float.MIN_EXPONENT);
        staticFloatStore.add(Float.MAX_EXPONENT);
        staticFloatStore.add(Float.NEGATIVE_INFINITY);
        staticFloatStore.add(Float.POSITIVE_INFINITY);
        staticFloatStore.add(Float.MIN_NORMAL);
        staticFloatStore.add(Float.NaN);
        System.out.print(staticFloatStore);
        System.out.print("\n");

        StaticStore<?> staticDoubleStore = new StaticStore<Double>(10);
        staticDoubleStore.add(Double.MIN_VALUE);
        staticDoubleStore.add(Double.MAX_VALUE);
        staticDoubleStore.add(Double.BYTES);
        staticDoubleStore.add(Double.SIZE);
        staticDoubleStore.add(Double.MIN_EXPONENT);
        staticDoubleStore.add(Double.MAX_EXPONENT);
        staticDoubleStore.add(Double.NEGATIVE_INFINITY);
        staticDoubleStore.add(Double.POSITIVE_INFINITY);
        staticDoubleStore.add(Double.MIN_NORMAL);
        staticDoubleStore.add(Double.NaN);
        System.out.print(staticDoubleStore);
        System.out.print("\n");

        StaticStore<?> staticCharacterStore = new StaticStore<Character>(8);
        staticCharacterStore.add(Character.MAX_HIGH_SURROGATE);
        staticCharacterStore.add(Character.MAX_LOW_SURROGATE);
        staticCharacterStore.add(Character.MAX_SURROGATE);
        staticCharacterStore.add(Character.MAX_VALUE);
        staticCharacterStore.add(Character.MIN_HIGH_SURROGATE);
        staticCharacterStore.add(Character.MIN_LOW_SURROGATE);
        staticCharacterStore.add(Character.MIN_SURROGATE);
        staticCharacterStore.add(Character.MIN_VALUE);
        System.out.print(staticCharacterStore);
        System.out.print("\n");

        StaticStore<?> staticBooleanStore = new StaticStore<Boolean>(2);
        staticBooleanStore.add(false);
        staticBooleanStore.add(true);
        System.out.print(staticBooleanStore);
        System.out.print("\n");

        StaticStore<?> staticStringStore = new StaticStore<String>(4);
        staticStringStore.add("Fellow");
        staticStringStore.add("Mellow");
        staticStringStore.add("Yellow");
        staticStringStore.add("Bellow");
        System.out.print(staticStringStore);
        System.out.print("\n");

        //StaticStore<?> staticComparableStore = new StaticStore<ANY_OBJECT_THAT_IMPLEMENTS_COMPARABLE_INTERFACE>(n);
        StaticStore<?> staticComparableStore = new StaticStore<File>(2);
        staticComparableStore.add(new File("./testfileOne.txt"));
        staticComparableStore.add(new File("./testfileTwo.txt"));
        System.out.print(staticComparableStore);
        System.out.print("\n");

        System.out.println("--------------------Static item store replace item");

        StaticStore<?> staticReplacedIntegerStore = new StaticStore<Integer>(4);
        System.out.print(staticReplacedIntegerStore);
        //staticReplacedIntegerStore.replaceAll(0);
        //System.out.print(staticReplacedIntegerStore);
        staticReplacedIntegerStore.add(1);
        //staticReplacedIntegerStore.replace(1, 7);
        staticReplacedIntegerStore.add(3);
        staticReplacedIntegerStore.add(9);
        staticReplacedIntegerStore.add(5);
        System.out.print(staticReplacedIntegerStore);
        staticReplacedIntegerStore.replaceAll(0);
        System.out.print(staticReplacedIntegerStore);
        staticReplacedIntegerStore.replace(1, 7);
        System.out.print(staticReplacedIntegerStore);
        //System.out.println("Index of 9 = ".concat(String.valueOf(staticReplacedIntegerStore.getIndex(9))));
        System.out.println("Item at index 3 = ".concat(String.valueOf(staticReplacedIntegerStore.get(3))));
        System.out.print("\n");

        System.out.println("--------------------Dynamic item store");

        //ItemStore<?> DynamicStore = new DynamicStore<int>(); //cannot find symbol
        //DynamicStore<?> DynamicStore = new DynamicStore<int>(); //unexpected type
        
        DynamicStore<?> dynamicByteStore = new DynamicStore<Byte>();
        dynamicByteStore.add(Byte.MIN_VALUE);
        dynamicByteStore.add(Byte.MAX_VALUE);
        dynamicByteStore.add(Byte.BYTES);
        dynamicByteStore.add(Byte.SIZE);
        System.out.print(dynamicByteStore);
        System.out.print("\n");

        DynamicStore<?> dynamicShortStore = new DynamicStore<Short>();
        dynamicShortStore.add(Short.MIN_VALUE);
        dynamicShortStore.add(Short.MAX_VALUE);
        dynamicShortStore.add(Short.BYTES);
        dynamicShortStore.add(Short.SIZE);
        System.out.print(dynamicShortStore);
        System.out.print("\n");

        DynamicStore<?> dynamicIntegerStore = new DynamicStore<Integer>();
        dynamicIntegerStore.add(Integer.MIN_VALUE);
        dynamicIntegerStore.add(Integer.MAX_VALUE);
        dynamicIntegerStore.add(Integer.BYTES);
        dynamicIntegerStore.add(Integer.SIZE);
        System.out.print(dynamicIntegerStore);
        System.out.print("\n");

        DynamicStore<?> dynamicLongStore = new DynamicStore<Long>();
        dynamicLongStore.add(Long.MIN_VALUE);
        dynamicLongStore.add(Long.MAX_VALUE);
        dynamicLongStore.add(Long.BYTES);
        dynamicLongStore.add(Long.SIZE);
        System.out.print(dynamicLongStore);
        System.out.print("\n");

        DynamicStore<?> dynamicFloatStore = new DynamicStore<Float>();
        dynamicFloatStore.add(Float.MIN_VALUE);
        dynamicFloatStore.add(Float.MAX_VALUE);
        dynamicFloatStore.add(Float.BYTES);
        dynamicFloatStore.add(Float.SIZE);
        dynamicFloatStore.add(Float.MIN_EXPONENT);
        dynamicFloatStore.add(Float.MAX_EXPONENT);
        dynamicFloatStore.add(Float.NEGATIVE_INFINITY);
        dynamicFloatStore.add(Float.POSITIVE_INFINITY);
        dynamicFloatStore.add(Float.MIN_NORMAL);
        dynamicFloatStore.add(Float.NaN);
        System.out.print(dynamicFloatStore);
        System.out.print("\n");

        DynamicStore<?> dynamicDoubleStore = new DynamicStore<Double>();
        dynamicDoubleStore.add(Double.MIN_VALUE);
        dynamicDoubleStore.add(Double.MAX_VALUE);
        dynamicDoubleStore.add(Double.BYTES);
        dynamicDoubleStore.add(Double.SIZE);
        dynamicDoubleStore.add(Double.MIN_EXPONENT);
        dynamicDoubleStore.add(Double.MAX_EXPONENT);
        dynamicDoubleStore.add(Double.NEGATIVE_INFINITY);
        dynamicDoubleStore.add(Double.POSITIVE_INFINITY);
        dynamicDoubleStore.add(Double.MIN_NORMAL);
        dynamicDoubleStore.add(Double.NaN);
        System.out.print(dynamicDoubleStore);
        System.out.print("\n");

        DynamicStore<?> dynamicCharacterStore = new DynamicStore<Character>();
        dynamicCharacterStore.add(Character.MAX_HIGH_SURROGATE);
        dynamicCharacterStore.add(Character.MAX_LOW_SURROGATE);
        dynamicCharacterStore.add(Character.MAX_SURROGATE);
        dynamicCharacterStore.add(Character.MAX_VALUE);
        dynamicCharacterStore.add(Character.MIN_HIGH_SURROGATE);
        dynamicCharacterStore.add(Character.MIN_LOW_SURROGATE);
        dynamicCharacterStore.add(Character.MIN_SURROGATE);
        dynamicCharacterStore.add(Character.MIN_VALUE);
        System.out.print(dynamicCharacterStore);
        System.out.print("\n");

        DynamicStore<?> dynamicBooleanStore = new DynamicStore<Boolean>();
        dynamicBooleanStore.add(false);
        dynamicBooleanStore.add(true);
        System.out.print(dynamicBooleanStore);
        System.out.print("\n");

        DynamicStore<?> dynamicStringStore = new DynamicStore<String>();
        dynamicStringStore.add("Fellow");
        dynamicStringStore.add("Mellow");
        dynamicStringStore.add("Yellow");
        dynamicStringStore.add("Bellow");
        System.out.print(dynamicStringStore);
        System.out.print("\n");

        //DynamicStore<?> dynamicComparableStore = new DynamicStore<ANY_OBJECT_THAT_IMPLEMENTS_COMPARABLE_INTERFACE>();
        DynamicStore<?> dynamicComparableStore = new DynamicStore<File>();
        dynamicComparableStore.add(new File("./testfileOne.txt"));
        dynamicComparableStore.add(new File("./testfileTwo.txt"));
        System.out.print(dynamicComparableStore);
        System.out.print("\n");

        System.out.println("--------------------Dynamic sorted item store");

        DynamicStore<?> dynamicSortedIntegerStore = new DynamicStore<Integer>();
        for (int i = 0; i < 4; i++) {
            dynamicSortedIntegerStore.add(random.nextInt(2000));
        }
        dynamicSortedIntegerStore.sort();
        System.out.print(dynamicSortedIntegerStore);
        System.out.print("\n");

        DynamicStore<?> dynamicSortedStringStore = new DynamicStore<String>();
        dynamicSortedStringStore.add("Fellow");
        dynamicSortedStringStore.add("Mellow");
        dynamicSortedStringStore.add("Yellow");
        dynamicSortedStringStore.add("Bellow");
        dynamicSortedStringStore.sort();
        System.out.print(dynamicSortedStringStore);
        System.out.print("\n");

        System.out.println("--------------------Dynamic item store replace item");
        
        DynamicStore<?> dynamicReplacedIntegerStore = new DynamicStore<Integer>();
        dynamicReplacedIntegerStore.add(1);
        dynamicReplacedIntegerStore.add(3);
        //dynamicReplacedIntegerStore.replace(2, 7);
        dynamicReplacedIntegerStore.add(9);
        dynamicReplacedIntegerStore.add(5);
        System.out.print(dynamicReplacedIntegerStore);
        System.out.print("\n");
        dynamicReplacedIntegerStore.replace(2, 7);
        System.out.print(dynamicReplacedIntegerStore);
        System.out.print("\n");

        System.out.println("--------------------Dynamic item store insert item");
        DynamicStore<?> dynamicInsertedIntegerStore = new DynamicStore<Integer>();
        dynamicInsertedIntegerStore.add(1);
        dynamicInsertedIntegerStore.add(3);
        dynamicInsertedIntegerStore.add(9);
        dynamicInsertedIntegerStore.add(5);
        System.out.print(dynamicInsertedIntegerStore);
        System.out.print("\n");
        dynamicInsertedIntegerStore.insert(2, 7);
        System.out.print(dynamicInsertedIntegerStore);
        System.out.print("\n");
        dynamicInsertedIntegerStore.insert(0, 8);
        System.out.print(dynamicInsertedIntegerStore);
        System.out.print("\n");
        dynamicInsertedIntegerStore.insert(6, 4);
        System.out.print(dynamicInsertedIntegerStore);
        //dynamicInsertedIntegerStore.insert(9, 0);
        //System.out.print(dynamicInsertedIntegerStore);
        //dynamicInsertedIntegerStore.insert(-1, 6);
        //System.out.print(dynamicInsertedIntegerStore);
        System.out.print("\n");
        System.out.println("Index of 9 = ".concat(String.valueOf(dynamicInsertedIntegerStore.getIndex(9))));
        System.out.println("Item at index 3 = ".concat(String.valueOf(dynamicInsertedIntegerStore.get(3))));
        System.out.print("\n");

        System.out.println("--------------------Dynamic unique item store");
        
        DynamicUniqueStore<?> dynamicUniqueIntegerStore = new DynamicUniqueStore<Integer>();
        dynamicUniqueIntegerStore.add(1);
        dynamicUniqueIntegerStore.add(2);
        dynamicUniqueIntegerStore.add(1);
        dynamicUniqueIntegerStore.add(3);
        System.out.print(dynamicUniqueIntegerStore);
        System.out.print("\n");

        DynamicUniqueStore<?> dynamicUniqueStringStore = new DynamicUniqueStore<String>();
        dynamicUniqueStringStore.add("a");
        dynamicUniqueStringStore.add("b");
        dynamicUniqueStringStore.add("a");
        dynamicUniqueStringStore.add("c");
        System.out.print(dynamicUniqueStringStore);
        System.out.print("\n");

        System.out.println("--------------------Dynamic key value store");
    
        //DynamicMap<?,?> dynamicMap = new DynamicMap<byte,int>(); //unexpected type
        //DynamicMap<?,?> dynamicMap = new DynamicMap<String,int>(); //unexpected type
        //DynamicMap<?,?> dynamicMap = new DynamicMap<String,Object>(); //Legal
        DynamicMap<?,?> dynamicMap = new DynamicMap<String,Integer>();
        dynamicMap.add("Yukon", 8);
        dynamicMap.add("Bicker", 9);
        dynamicMap.add("Shulz", 7);
        dynamicMap.add("Jems", 3);
        System.out.print(dynamicMap);
        System.out.print("\n");

        DynamicMap<?,?> dynamicMapWithFileValue = new DynamicMap<Integer,File>();
        dynamicMapWithFileValue.add(1, new File("./testfileOne.txt"));
        dynamicMapWithFileValue.add(2, new File("./testfileTwo.txt"));
        System.out.print(dynamicMapWithFileValue);
        System.out.print("\n");

        System.out.println("--------------------Dynamic sorted key value store");

        DynamicMap<?,?> dynamicSortedIntegerKeyValueStore = new DynamicMap<Integer,String>();
        dynamicSortedIntegerKeyValueStore.add(88, "Yukon");
        dynamicSortedIntegerKeyValueStore.add(832, "Bicker");
        dynamicSortedIntegerKeyValueStore.add(832, "Blitzer");
        dynamicSortedIntegerKeyValueStore.add(7, "Shulz");
        dynamicSortedIntegerKeyValueStore.add(17, "Shulz");
        dynamicSortedIntegerKeyValueStore.add(3, "Jems");
        dynamicSortedIntegerKeyValueStore.sort();
        System.out.println(dynamicSortedIntegerKeyValueStore);
        System.out.println("7 -> ".concat(String.valueOf(dynamicSortedIntegerKeyValueStore.getValue(7))));
        System.out.println("Blitzer <- ".concat(String.valueOf(dynamicSortedIntegerKeyValueStore.getKey("Blitzer"))));
        System.out.print("\n");

        DynamicMap<?,?> dynamicSortedStringKeyValueStore = new DynamicMap<String,Integer>();
        dynamicSortedStringKeyValueStore.add("Yukon", 8);
        dynamicSortedStringKeyValueStore.add("Bicker", 9);
        dynamicSortedStringKeyValueStore.add("Shulz", 7);
        dynamicSortedStringKeyValueStore.add("Jems", 3);
        dynamicSortedStringKeyValueStore.sort();
        System.out.println(dynamicSortedStringKeyValueStore);
        System.out.println("Yukon -> ".concat(String.valueOf(dynamicSortedStringKeyValueStore.getValue("Yukon"))));
        System.out.println("3 <- ".concat(String.valueOf(dynamicSortedStringKeyValueStore.getKey(3))));
        System.out.print("\n");
    }
}
