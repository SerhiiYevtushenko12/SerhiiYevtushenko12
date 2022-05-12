package Lesson1;

class Chicken extends Bird {

    public Chicken(String name) {
        super(name);
        super.isFly = this.isFly;
    }

    boolean isFly = true;

    public void isCanFly(boolean isFly) {
        if (isFly) {
            System.out.println("ууупс народжений");
        }
        this.isFly = isFly;
    }

    @Override
    protected void voice() {
        System.out.println("cant fly");
    }
}

