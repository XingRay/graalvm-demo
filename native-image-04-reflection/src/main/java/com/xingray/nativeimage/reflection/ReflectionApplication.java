package com.xingray.nativeimage.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class ReflectionApplication {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = random.nextInt(10) % 2 == 0 ? "com.xingray.nativeimage.reflection.Dog"
                    : "com.xingray.nativeimage.reflection.Cat";
            Animal animal = null;
            try {
                animal = (Animal) Class.forName(name).getDeclaredConstructor().newInstance();
            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException |
                     IllegalAccessException |
                     ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
            System.out.println(animal.hello());
        }
    }
}