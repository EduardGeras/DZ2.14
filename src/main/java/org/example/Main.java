package org.example;

import java.util.Arrays;

public class Main {
    private static final String[] otherList = new String[6];


    public static void main(String[] args) {
        StringList stringList = new StringListImpl();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        System.out.println( "1. " + Arrays.toString(stringList.toArray()));

        stringList.add(4, "e");
        System.out.println("2. " + Arrays.toString(stringList.toArray()));

        stringList.set(2, "P");
        System.out.println("3. " + Arrays.toString(stringList.toArray()));

        stringList.remove("P");
        System.out.println("3. " + Arrays.toString(stringList.toArray()));

        stringList.remove(1);
        System.out.println("4. " + Arrays.toString(stringList.toArray()));

        System.out.println("5. " + Arrays.toString(new boolean[]{stringList.contains("a")}));
        System.out.println("6. " + Arrays.toString(new boolean[]{stringList.contains("v")}));

        System.out.println("7. " + Arrays.toString(new int[]{stringList.indexOf("a")}));
        System.out.println("8. " + Arrays.toString(new int[]{stringList.indexOf("m")}));

        System.out.println("9. " + Arrays.toString(new int[]{stringList.lastIndexOf("b")}));
        System.out.println("10. " + Arrays.toString(new int[]{stringList.lastIndexOf("d")}));

        System.out.println("11. " + Arrays.toString(new String[]{stringList.get(1)}));
        
        System.out.println("12. " + Arrays.toString(new boolean[]{stringList.equals(otherList)}));

        System.out.println("13. " + Arrays.toString(new int[]{stringList.size()}));

        System.out.println("14. " + Arrays.toString(new boolean[]{stringList.isEmpty()}));

        stringList.clear();
        System.out.println("15. " + Arrays.toString(stringList.toArray()));

        stringList.toArray();
        System.out.println("16. " + Arrays.toString(stringList.toArray()));
    }

}