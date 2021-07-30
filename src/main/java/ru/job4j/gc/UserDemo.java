package ru.job4j.gc;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

public class UserDemo {
    //    private static final long KB = 1000;
//    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();
    private User user1 = null;

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d bytes%n", freeMemory);
        System.out.printf("Total: %d bytes%n", totalMemory);
        System.out.printf("Max: %d bytes%n", maxMemory);
        final long usedMem = totalMemory - freeMemory;
        System.out.println("Занятая память: " + usedMem);
    }

    public static void main(String[] args) {
        info();
        User user0 = new User();
        //User user1 = new User(15, "user1");
//        for (int i = 0; i < 10000; i++) {
//            new User(i, "N" + i);
//        }
        System.gc();
        info();

        // информацию о нашей текущей виртуальной машине
        //System.out.println(VM.current().details());
        /*
        # WARNING: Unable to attach Serviceability Agent. sun.jvm.hotspot.memory
        .Universe.getNarrowOopBase()
        # Running 64-bit HotSpot VM.
        # Using compressed oop with 3-bit shift.
        # Using compressed klass with 3-bit shift.
        # WARNING | Compressed references base/shifts are guessed by the experiment!
        # WARNING | Therefore, computed addresses are just guesses, and ARE NOT RELIABLE.
        # WARNING | Make sure to attach Serviceability Agent to get the reliable addresses.
        # Objects are 8 bytes aligned.
        # Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
        # Array element sizes: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]

        Версия JVM – HotSpot 64 битная.
        Объекты выравниваются по 8 байт.
        Указаны размеры типов в JVM. Ссылка занимает 4 байта.
         */

        // Размер объекта user1
        //System.out.println(ClassLayout.parseClass(User.class).toPrintable(user1));

        //класс GraphLayout:
        //System.out.println(GraphLayout.parseInstance(user1).toFootprint());

        //Пустой объект без полей
        System.out.println(ClassLayout.parseClass(User.class).toPrintable(user0));
    }
}
