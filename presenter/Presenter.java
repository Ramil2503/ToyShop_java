package presenter;

import view.Console;
import model.Service;

public class Presenter {
    Console console = new Console();
    Service service = new Service();
    
    public void start() {
        boolean continueLoop = true;
        int choice;
        while (continueLoop) {
            choice = console.start();
            switch (choice) {
                case 1:
                    console.printToys(service.allToys());
                    break;
                case 2:
                    service.createToy(console.createToy());
                    break;
                case 3:

                    break;
                case 4:
                    long winToyID = service.getRandomToyId();
                    service.decreaseToy(winToyID);
                    console.printToy(service.getToyById(winToyID));
                    break;
                case 5:
                    continueLoop = false;
                    break;
            }
        }
    }
}
