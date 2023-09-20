package presenter;

import view.Console;

public class Presenter {
    Console console = new Console();
    public void start() {
        boolean continueLoop = true;
        int choice;
        while (continueLoop) {
            choice = console.start();
            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    continueLoop = false;
                    break;
            }
        }
    }
}
