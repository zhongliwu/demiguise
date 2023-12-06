package edu.usc.demiguise;

import org.openjdk.jol.vm.VM;

public class Demiguise {

    public static void main(String[] args) {
        Integer[] array = new Integer[3];
        System.out.println(System.identityHashCode(array));

        Integer[] another_array = new Integer[2];
        System.out.print(System.identityHashCode(another_array));
    }
}
