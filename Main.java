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
        staticByteStore.setItem(new Item((byte)Byte.MIN_VALUE));
        staticByteStore.setItem(new Item((byte)Byte.MAX_VALUE));
        staticByteStore.setItem(new Item((byte)Byte.BYTES));
        staticByteStore.setItem(new Item((byte)Byte.SIZE));
        System.out.print(staticByteStore);
        System.out.print("\n");

        StaticItemStore<?> staticShortStore = new StaticItemStore<Short>(4);
        staticShortStore.setItem(new Item((short)Short.MIN_VALUE));
        staticShortStore.setItem(new Item((short)Short.MAX_VALUE));
        staticShortStore.setItem(new Item((short)Short.BYTES));
        staticShortStore.setItem(new Item((short)Short.SIZE));
        System.out.print(staticShortStore);
        System.out.print("\n");

        StaticItemStore<?> staticIntegerStore = new StaticItemStore<Integer>(4);
        staticIntegerStore.setItem(new Item((int)Integer.MIN_VALUE));
        staticIntegerStore.setItem(new Item((int)Integer.MAX_VALUE));
        staticIntegerStore.setItem(new Item((int)Integer.BYTES));
        staticIntegerStore.setItem(new Item((int)Integer.SIZE));
        System.out.print(staticIntegerStore);
        System.out.print("\n");

        StaticItemStore<?> staticLongStore = new StaticItemStore<Long>(4);
        staticLongStore.setItem(new Item((long)Long.MIN_VALUE));
        staticLongStore.setItem(new Item((long)Long.MAX_VALUE));
        staticLongStore.setItem(new Item((long)Long.BYTES));
        staticLongStore.setItem(new Item((long)Long.SIZE));
        System.out.print(staticLongStore);
        System.out.print("\n");

        StaticItemStore<?> staticFloatStore = new StaticItemStore<Float>(10);
        staticFloatStore.setItem(new Item((float)Float.MIN_VALUE));
        staticFloatStore.setItem(new Item((float)Float.MAX_VALUE));
        staticFloatStore.setItem(new Item((float)Float.BYTES));
        staticFloatStore.setItem(new Item((float)Float.SIZE));
        staticFloatStore.setItem(new Item((float)Float.MIN_EXPONENT));
        staticFloatStore.setItem(new Item((float)Float.MAX_EXPONENT));
        staticFloatStore.setItem(new Item((float)Float.NEGATIVE_INFINITY));
        staticFloatStore.setItem(new Item((float)Float.POSITIVE_INFINITY));
        staticFloatStore.setItem(new Item((float)Float.MIN_NORMAL));
        staticFloatStore.setItem(new Item((float)Float.NaN));
        System.out.print(staticFloatStore);
        System.out.print("\n");

        StaticItemStore<?> staticDoubleStore = new StaticItemStore<Double>(10);
        staticDoubleStore.setItem(new Item((double)Double.MIN_VALUE));
        staticDoubleStore.setItem(new Item((double)Double.MAX_VALUE));
        staticDoubleStore.setItem(new Item((double)Double.BYTES));
        staticDoubleStore.setItem(new Item((double)Double.SIZE));
        staticDoubleStore.setItem(new Item((double)Double.MIN_EXPONENT));
        staticDoubleStore.setItem(new Item((double)Double.MAX_EXPONENT));
        staticDoubleStore.setItem(new Item((double)Double.NEGATIVE_INFINITY));
        staticDoubleStore.setItem(new Item((double)Double.POSITIVE_INFINITY));
        staticDoubleStore.setItem(new Item((double)Double.MIN_NORMAL));
        staticDoubleStore.setItem(new Item((double)Double.NaN));
        System.out.print(staticDoubleStore);
        System.out.print("\n");

        StaticItemStore<?> staticCharacterStore = new StaticItemStore<Character>(8);
        staticCharacterStore.setItem(new Item((char)Character.MAX_HIGH_SURROGATE));
        staticCharacterStore.setItem(new Item((char)Character.MAX_LOW_SURROGATE));
        staticCharacterStore.setItem(new Item((char)Character.MAX_SURROGATE));
        staticCharacterStore.setItem(new Item((char)Character.MAX_VALUE));
        staticCharacterStore.setItem(new Item((char)Character.MIN_HIGH_SURROGATE));
        staticCharacterStore.setItem(new Item((char)Character.MIN_LOW_SURROGATE));
        staticCharacterStore.setItem(new Item((char)Character.MIN_SURROGATE));
        staticCharacterStore.setItem(new Item((char)Character.MIN_VALUE));
        System.out.print(staticCharacterStore);
        System.out.print("\n");

        StaticItemStore<?> staticBooleanStore = new StaticItemStore<Boolean>(2);
        staticBooleanStore.setItem(new Item((boolean)false));
        staticBooleanStore.setItem(new Item((boolean)true));
        System.out.print(staticBooleanStore);
        System.out.print("\n");

        StaticItemStore<?> staticStringStore = new StaticItemStore<String>(4);
        staticStringStore.setItem(new Item((String)"Fellow"));
        staticStringStore.setItem(new Item((String)"Mellow"));
        staticStringStore.setItem(new Item((String)"Yellow"));
        staticStringStore.setItem(new Item((String)"Bellow"));
        System.out.print(staticStringStore);
        System.out.print("\n");

        StaticItemStore<?> staticObjectStore = new StaticItemStore<Object>(4);
        staticObjectStore.setItem(new Item(new Thread()));
        staticObjectStore.setItem(new Item(new Error()));
        staticObjectStore.setItem(new Item(new Exception()));
        staticObjectStore.setItem(new Item(new SecurityManager()));
        System.out.print(staticObjectStore);
        System.out.print("\n");

        System.out.println("--------------------Dynamic item store");

        //AbstractItemStore<?> dynamicItemStore = new DynamicItemStore<int>(); //cannot find symbol
        //DynamicItemStore<?> dynamicItemStore = new DynamicItemStore<int>(); //unexpected type
        
        DynamicItemStore<?> dynamicByteStore = new DynamicItemStore<Byte>();
        dynamicByteStore.setItem(new Item((byte)Byte.MIN_VALUE));
        dynamicByteStore.setItem(new Item((byte)Byte.MAX_VALUE));
        dynamicByteStore.setItem(new Item((byte)Byte.BYTES));
        dynamicByteStore.setItem(new Item((byte)Byte.SIZE));
        System.out.print(dynamicByteStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicShortStore = new DynamicItemStore<Short>();
        dynamicShortStore.setItem(new Item((short)Short.MIN_VALUE));
        dynamicShortStore.setItem(new Item((short)Short.MAX_VALUE));
        dynamicShortStore.setItem(new Item((short)Short.BYTES));
        dynamicShortStore.setItem(new Item((short)Short.SIZE));
        System.out.print(dynamicShortStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicIntegerStore = new DynamicItemStore<Integer>();
        dynamicIntegerStore.setItem(new Item((int)Integer.MIN_VALUE));
        dynamicIntegerStore.setItem(new Item((int)Integer.MAX_VALUE));
        dynamicIntegerStore.setItem(new Item((int)Integer.BYTES));
        dynamicIntegerStore.setItem(new Item((int)Integer.SIZE));
        System.out.print(dynamicIntegerStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicLongStore = new DynamicItemStore<Long>();
        dynamicLongStore.setItem(new Item((long)Long.MIN_VALUE));
        dynamicLongStore.setItem(new Item((long)Long.MAX_VALUE));
        dynamicLongStore.setItem(new Item((long)Long.BYTES));
        dynamicLongStore.setItem(new Item((long)Long.SIZE));
        System.out.print(dynamicLongStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicFloatStore = new DynamicItemStore<Float>();
        dynamicFloatStore.setItem(new Item((float)Float.MIN_VALUE));
        dynamicFloatStore.setItem(new Item((float)Float.MAX_VALUE));
        dynamicFloatStore.setItem(new Item((float)Float.BYTES));
        dynamicFloatStore.setItem(new Item((float)Float.SIZE));
        dynamicFloatStore.setItem(new Item((float)Float.MIN_EXPONENT));
        dynamicFloatStore.setItem(new Item((float)Float.MAX_EXPONENT));
        dynamicFloatStore.setItem(new Item((float)Float.NEGATIVE_INFINITY));
        dynamicFloatStore.setItem(new Item((float)Float.POSITIVE_INFINITY));
        dynamicFloatStore.setItem(new Item((float)Float.MIN_NORMAL));
        dynamicFloatStore.setItem(new Item((float)Float.NaN));
        System.out.print(dynamicFloatStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicDoubleStore = new DynamicItemStore<Double>();
        dynamicDoubleStore.setItem(new Item((double)Double.MIN_VALUE));
        dynamicDoubleStore.setItem(new Item((double)Double.MAX_VALUE));
        dynamicDoubleStore.setItem(new Item((double)Double.BYTES));
        dynamicDoubleStore.setItem(new Item((double)Double.SIZE));
        dynamicDoubleStore.setItem(new Item((double)Double.MIN_EXPONENT));
        dynamicDoubleStore.setItem(new Item((double)Double.MAX_EXPONENT));
        dynamicDoubleStore.setItem(new Item((double)Double.NEGATIVE_INFINITY));
        dynamicDoubleStore.setItem(new Item((double)Double.POSITIVE_INFINITY));
        dynamicDoubleStore.setItem(new Item((double)Double.MIN_NORMAL));
        dynamicDoubleStore.setItem(new Item((double)Double.NaN));
        System.out.print(dynamicDoubleStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicCharacterStore = new DynamicItemStore<Character>();
        dynamicCharacterStore.setItem(new Item((char)Character.MAX_HIGH_SURROGATE));
        dynamicCharacterStore.setItem(new Item((char)Character.MAX_LOW_SURROGATE));
        dynamicCharacterStore.setItem(new Item((char)Character.MAX_SURROGATE));
        dynamicCharacterStore.setItem(new Item((char)Character.MAX_VALUE));
        dynamicCharacterStore.setItem(new Item((char)Character.MIN_HIGH_SURROGATE));
        dynamicCharacterStore.setItem(new Item((char)Character.MIN_LOW_SURROGATE));
        dynamicCharacterStore.setItem(new Item((char)Character.MIN_SURROGATE));
        dynamicCharacterStore.setItem(new Item((char)Character.MIN_VALUE));
        System.out.print(dynamicCharacterStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicBooleanStore = new DynamicItemStore<Boolean>();
        dynamicBooleanStore.setItem(new Item((boolean)false));
        dynamicBooleanStore.setItem(new Item((boolean)true));
        System.out.print(dynamicBooleanStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicStringStore = new DynamicItemStore<String>();
        dynamicStringStore.setItem(new Item((String)"Fellow"));
        dynamicStringStore.setItem(new Item((String)"Mellow"));
        dynamicStringStore.setItem(new Item((String)"Yellow"));
        dynamicStringStore.setItem(new Item((String)"Bellow"));
        System.out.print(dynamicStringStore);
        System.out.print("\n");

        DynamicItemStore<?> dynamicObjectStore = new DynamicItemStore<Object>();
        dynamicObjectStore.setItem(new Item(new Thread()));
        dynamicObjectStore.setItem(new Item(new Error()));
        dynamicObjectStore.setItem(new Item(new Exception()));
        dynamicObjectStore.setItem(new Item(new SecurityManager()));
        System.out.print(dynamicObjectStore);
        System.out.print("\n");

        System.out.println("--------------------Dynamic sorted item store");

        DynamicItemStore<?> dynamicSortedIntegerStore = new DynamicItemStore<Integer>();
        for (int i = 0; i < 7; i++) {
            dynamicSortedIntegerStore.setItem(new Item((int)random.nextInt(10000)));
        }
        dynamicSortedIntegerStore.sort(false);
        System.out.print(dynamicSortedIntegerStore);
        System.out.print("\n");

        System.out.println("--------------------Dynamic key value store");
    
        //DynamicKeyValueStore<?,?> dynamicKeyValueStore = new DynamicKeyValueStore<byte,int>(); //unexpected type
        //DynamicKeyValueStore<?,?> dynamicKeyValueStore = new DynamicKeyValueStore<String,int>(); //unexpected type
        //DynamicKeyValueStore<?,?> dynamicKeyValueStore = new DynamicKeyValueStore<String,Object>(); //Legal
        DynamicKeyValueStore<?,?> dynamicKeyValueStore = new DynamicKeyValueStore<String,Integer>();
        dynamicKeyValueStore.set(new Item((String)"Yukon"), new Item((int)8));
        dynamicKeyValueStore.set(new Item((String)"Bicker"), new Item((int)9));
        dynamicKeyValueStore.set(new Item((String)"Shulz"), new Item((int)7));
        dynamicKeyValueStore.set(new Item((String)"Jems"), new Item((int)3));
        System.out.print(dynamicKeyValueStore);
        System.out.print("\n");
    }
}
