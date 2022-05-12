package Lesson1;

import Lesson1.Bird;
import Lesson1.Chicken;

public class Hello {

    public static void main(String[] args) {
        Bird bird = new Bird("барсик");
        Bird chicken = new Chicken("Мурзик");
        System.out.println(bird.name);
        System.out.println(chicken.name);
        chicken.voice();
        System.out.println(chicken.isFly);

        Bird murchik = new Bird("Мурчик");
        Bird barbos = new Chicken("Барбос");
        Bird cypa = new Chicken("Сура");

        Bird bliznec = murchik;
        Bird vtoroi = cypa;

        System.out.println("Я пташка на імя" + murchik.name + "чи я вмію літати?" + murchik.isFly);
        System.out.println("Я пташка на імя" + barbos.name + "чи я вмію літати?" + barbos.isFly);
        System.out.println("Я пташка на імя" + bliznec.name + "чи я вмію літати?" + bliznec.isFly);

        barbos.isCanFly(false);
        cypa.isCanFly(false);
        System.out.println("Я пташка на імя" + vtoroi.name + "чи я вмію літати?" + vtoroi.isFly);

        vtoroi.isCanFly(true);
        System.out.println("vtoroi.isCanFly " + vtoroi.isFly);

    }


}

