import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("--------------------Items");

        Item<?> myByte = new Item((byte)10);
        System.out.println(myByte);
        Item<?> myShort = new Item((short)20);
        System.out.println(myShort);
        Item<?> myInteger = new Item((int)-1);
        System.out.println(myInteger);
        Item<?> myLong = new Item((long)1L);
        System.out.println(myLong);
        Item<?> myFloat = new Item((float)894.236f);
        System.out.println(myFloat);
        Item<?> myDouble = new Item((double)-7.5d);
        System.out.println(myDouble);
        Item<?> myChar = new Item((char)'c');
        System.out.println(myChar);
        Item<?> myBoolean = new Item((boolean)false);
        System.out.println(myBoolean);
        Item<?> myString = new Item((String)"Hello");
        System.out.println(myString);
        Item<?> myObject = new Item(new Object());
        System.out.println(myObject);
        System.out.print("\n");

        System.out.println("--------------------Static item store");
    
        //AbstractItemStore<?> staticItemStore = new StaticItemStore<int>(4); //cannot find symbol
        //StaticItemStore<?> staticItemStore = new StaticItemStore<int>(4); //unexpected type
        
        StaticItemStore<?> staticByteStore = new StaticItemStore<Byte>(4);
        staticByteStore.add(Byte.MIN_VALUE);
        staticByteStore.add(Byte.MAX_VALUE);
        staticByteStore.add(Byte.BYTES);
        staticByteStore.add(Byte.SIZE);
        System.out.print(staticByteStore);
        System.out.print("\n");

        StaticItemStore<?> staticShortStore = new StaticItemStore<Short>(4);
        staticShortStore.add(Short.MIN_VALUE);
        staticShortStore.add(Short.MAX_VALUE);
        staticShortStore.add(Short.BYTES);
        staticShortStore.add(Short.SIZE);
        System.out.print(staticShortStore);
        System.out.print("\n");

        StaticItemStore<?> staticIntegerStore = new StaticItemStore<Integer>(4);
        staticIntegerStore.add(Integer.MIN_VALUE);
        staticIntegerStore.add(Integer.MAX_VALUE);
        staticIntegerStore.add(Integer.BYTES);
        staticIntegerStore.add(Integer.SIZE);
        System.out.print(staticIntegerStore);
        System.out.print("\n");

        StaticItemStore<?> staticLongStore = new StaticItemStore<Long>(4);
        staticLongStore.add(Long.MIN_VALUE);
        staticLongStore.add(Long.MAX_VALUE);
        staticLongStore.add(Long.BYTES);
        staticLongStore.add(Long.SIZE);
        System.out.print(staticLongStore);
        System.out.print("\n");

        StaticItemStore<?> staticFloatStore = new StaticItemStore<Float>(10);
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

        StaticItemStore<?> staticDoubleStore = new StaticItemStore<Double>(10);
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

        StaticItemStore<?> staticCharacterStore = new StaticItemStore<Character>(8);
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

        StaticItemStore<?> staticBooleanStore = new StaticItemStore<Boolean>(2);
        staticBooleanStore.add(false);
        staticBooleanStore.add(true);
        System.out.print(staticBooleanStore);
        System.out.print("\n");

        StaticItemStore<?> staticStringStore = new StaticItemStore<String>(4);
        staticStringStore.add("Fellow");
        staticStringStore.add("Mellow");
        staticStringStore.add("Yellow");
        staticStringStore.add("Bellow");
        System.out.print(staticStringStore);
        System.out.print("\n");

        StaticItemStore<?> staticObjectStore = new StaticItemStore<Object>(4);
        staticObjectStore.add(new Thread());
        staticObjectStore.add(new Error());
        staticObjectStore.add(new Exception());
        staticObjectStore.add(new SecurityManager());
        System.out.print(staticObjectStore);
        System.out.print("\n");

        System.out.println("--------------------Dynamic item store");

        //AbstractItemStore<?> dynamicItemStore = new DynamicItemStore<int>(); //cannot find symbol
        //DynamicItemStore<?> dynamicItemStore = new DynamicItemStore<int>(); //unexpected type
        
        DynamicItemStore<?> dynamicByteStore = new DynamicItemStore<Byte>();
        dynamicByteStore.add(Byte.MIN_VALUE);
        dynamicByteStore.add(Byte.MAX_VALUE);
        dynamicByteStore.add(Byte.BYTES);
        dynamicByteStore.add(Byte.SIZE);
        System.out.print(dynamicByteStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicShortStore = new DynamicItemStore<Short>();
        dynamicShortStore.add(Short.MIN_VALUE);
        dynamicShortStore.add(Short.MAX_VALUE);
        dynamicShortStore.add(Short.BYTES);
        dynamicShortStore.add(Short.SIZE);
        System.out.print(dynamicShortStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicIntegerStore = new DynamicItemStore<Integer>();
        dynamicIntegerStore.add(Integer.MIN_VALUE);
        dynamicIntegerStore.add(Integer.MAX_VALUE);
        dynamicIntegerStore.add(Integer.BYTES);
        dynamicIntegerStore.add(Integer.SIZE);
        System.out.print(dynamicIntegerStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicLongStore = new DynamicItemStore<Long>();
        dynamicLongStore.add(Long.MIN_VALUE);
        dynamicLongStore.add(Long.MAX_VALUE);
        dynamicLongStore.add(Long.BYTES);
        dynamicLongStore.add(Long.SIZE);
        System.out.print(dynamicLongStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicFloatStore = new DynamicItemStore<Float>();
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

        DynamicItemStore<?> dynamicDoubleStore = new DynamicItemStore<Double>();
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

        DynamicItemStore<?> dynamicCharacterStore = new DynamicItemStore<Character>();
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

        DynamicItemStore<?> dynamicBooleanStore = new DynamicItemStore<Boolean>();
        dynamicBooleanStore.add(false);
        dynamicBooleanStore.add(true);
        System.out.print(dynamicBooleanStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicStringStore = new DynamicItemStore<String>();
        dynamicStringStore.add("Fellow");
        dynamicStringStore.add("Mellow");
        dynamicStringStore.add("Yellow");
        dynamicStringStore.add("Bellow");
        System.out.print(dynamicStringStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicObjectStore = new DynamicItemStore<Object>();
        dynamicObjectStore.add(new Thread());
        dynamicObjectStore.add(new Error());
        dynamicObjectStore.add(new Exception());
        dynamicObjectStore.add(new SecurityManager());
        System.out.print(dynamicObjectStore);
        System.out.print("\n");

        System.out.println("--------------------Dynamic sorted item store");

        DynamicItemStore<?> dynamicSortedIntegerStore = new DynamicItemStore<Integer>();
        for (int i = 0; i < 4; i++) {
            dynamicSortedIntegerStore.add(random.nextInt(10000));
        }
        dynamicSortedIntegerStore.sort();
        System.out.print(dynamicSortedIntegerStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicSortedStringStore = new DynamicItemStore<String>();
        dynamicSortedStringStore.add("Fellow");
        dynamicSortedStringStore.add("Mellow");
        dynamicSortedStringStore.add("Yellow");
        dynamicSortedStringStore.add("Bellow");
        dynamicSortedStringStore.sort();
        System.out.print(dynamicSortedStringStore);
        System.out.print("\n");

        System.out.println("--------------------Dynamic unique item store");
        
        DynamicUniqueItemStore<?> dynamicUniqueIntegerStore = new DynamicUniqueItemStore<Integer>();
        dynamicUniqueIntegerStore.add(1);
        dynamicUniqueIntegerStore.add(2);
        dynamicUniqueIntegerStore.add(1);
        dynamicUniqueIntegerStore.add(3);
        System.out.print(dynamicUniqueIntegerStore);
        System.out.print("\n");

        DynamicUniqueItemStore<?> dynamicUniqueStringStore = new DynamicUniqueItemStore<String>();
        dynamicUniqueStringStore.add("a");
        dynamicUniqueStringStore.add("b");
        dynamicUniqueStringStore.add("a");
        dynamicUniqueStringStore.add("c");
        System.out.print(dynamicUniqueStringStore);
        System.out.print("\n");

        System.out.println("--------------------Dynamic key value store");
    
        //DynamicKeyValueStore<?,?> dynamicKeyValueStore = new DynamicKeyValueStore<byte,int>(); //unexpected type
        //DynamicKeyValueStore<?,?> dynamicKeyValueStore = new DynamicKeyValueStore<String,int>(); //unexpected type
        //DynamicKeyValueStore<?,?> dynamicKeyValueStore = new DynamicKeyValueStore<String,Object>(); //Legal
        DynamicKeyValueStore<?,?> dynamicKeyValueStore = new DynamicKeyValueStore<String,Integer>();
        dynamicKeyValueStore.add("Yukon", 8);
        dynamicKeyValueStore.add("Bicker", 9);
        dynamicKeyValueStore.add("Shulz", 7);
        dynamicKeyValueStore.add("Jems", 3);
        System.out.print(dynamicKeyValueStore);
        System.out.print("\n");

        DynamicKeyValueStore<?,?> dynamicKeyValueStoreWithListValue = new DynamicKeyValueStore<Integer,AbstractItemStore>();
        dynamicKeyValueStoreWithListValue.add(1, new StaticItemStore<Integer>(4));
        dynamicKeyValueStoreWithListValue.add(2, new DynamicItemStore<Integer>());
        dynamicKeyValueStoreWithListValue.add(3, new DynamicUniqueItemStore<Integer>());
        System.out.print(dynamicKeyValueStoreWithListValue);
        System.out.print("\n");

        System.out.println("--------------------Dynamic sorted key value store");

        DynamicKeyValueStore<?,?> dynamicSortedIntegerKeyValueStore = new DynamicKeyValueStore<Integer,String>();
        dynamicSortedIntegerKeyValueStore.add(88, "Yukon");
        dynamicSortedIntegerKeyValueStore.add(832, "Bicker");
        dynamicSortedIntegerKeyValueStore.add(7, "Shulz");
        dynamicSortedIntegerKeyValueStore.add(3, "Jems");
        dynamicSortedIntegerKeyValueStore.sort();
        System.out.print(dynamicSortedIntegerKeyValueStore);
        System.out.println("7 -> ".concat(String.valueOf(dynamicSortedIntegerKeyValueStore.get(7))));
        System.out.print("\n");

        DynamicKeyValueStore<?,?> dynamicSortedStringKeyValueStore = new DynamicKeyValueStore<String,Integer>();
        dynamicSortedStringKeyValueStore.add("Yukon", 8);
        dynamicSortedStringKeyValueStore.add("Bicker", 9);
        dynamicSortedStringKeyValueStore.add("Shulz", 7);
        dynamicSortedStringKeyValueStore.add("Jems", 3);
        dynamicSortedStringKeyValueStore.sort();
        System.out.print(dynamicSortedStringKeyValueStore);
        System.out.println("Yukon -> ".concat(String.valueOf(dynamicSortedStringKeyValueStore.get("Yukon"))));
        System.out.print("\n");

        System.out.println("--------------------Static item store replace item");

        StaticItemStore<?> staticReplacedIntegerStore = new StaticItemStore<Integer>(4);
        staticReplacedIntegerStore.add(1);
        staticReplacedIntegerStore.add(3);
        staticReplacedIntegerStore.add(9);
        staticReplacedIntegerStore.add(5);
        System.out.print(staticReplacedIntegerStore);
        System.out.print("\n");
        staticReplacedIntegerStore.replace(1, 7);
        System.out.print(staticReplacedIntegerStore);
        System.out.print("\n");
        System.out.println("Index of 9 = ".concat(String.valueOf(staticReplacedIntegerStore.getIndex(9))));
        System.out.println("Item at index 3 = ".concat(String.valueOf(staticReplacedIntegerStore.get(3))));

        System.out.println("--------------------Dynamic item store replace item");
        
        DynamicItemStore<?> dynamicReplacedIntegerStore = new DynamicItemStore<Integer>();
        dynamicReplacedIntegerStore.add(1);
        dynamicReplacedIntegerStore.add(3);
        dynamicReplacedIntegerStore.add(9);
        dynamicReplacedIntegerStore.add(5);
        System.out.print(dynamicReplacedIntegerStore);
        System.out.print("\n");
        dynamicReplacedIntegerStore.replace(2, 7);
        System.out.print(dynamicReplacedIntegerStore);
        System.out.print("\n");

        System.out.println("--------------------Dynamic item store insert item");
        DynamicItemStore<?> dynamicInsertedIntegerStore = new DynamicItemStore<Integer>();
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
        System.out.print("\n");
        System.out.println("Index of 9 = ".concat(String.valueOf(dynamicInsertedIntegerStore.getIndex(9))));
        System.out.println("Item at index 3 = ".concat(String.valueOf(dynamicInsertedIntegerStore.get(3))));
    }
}
