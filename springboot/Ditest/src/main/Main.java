package main;

public class Main {
    public static void main(String[] args) {
        //has a 관계 Computer -> Mouse -> Button
        Button button = new Button(2);
        Mouse mouse = new Mouse(button);
//        mouse.setButton(button);
        Computer computer = new Computer();
        computer.setMouse(mouse);
        System.out.println(computer);
    }
}

class Button {
    private int b;
    Button(int b) {
        this.b = b;
    }
    Button() {

    }
    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Button with number{" +
                "b=" + b +
                '}';
    }
}

class Mouse {
    private Button button;
    Mouse(Button button) {}
    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "Mouse with {" +
                "button=" + button +
                '}';
    }
}

class Computer {
    private Mouse mouse;
    void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    Computer() {}

    @Override
    public String toString() {
        return "Computer with{" +
                "mouse=" + mouse +
                '}';
    }
}