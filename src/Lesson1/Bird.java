package Lesson1;

class Bird implements FlyBirds {

    public Bird(String name) {
        this.name = name;
    }

    String name;
    boolean isFly = false;
    private String voice = "Я пташка!";

    protected void voice() {
        System.out.println(voice);
    }

    public void isCanFly(boolean isCanFly) {
        this.isFly = isCanFly;
    }

    @Override
    public void wingSize() {

    }

    @Override
    public void flySpeed() {

    }
}



