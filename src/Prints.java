public class Prints {
    public static void printTitleScreen() {
        String title = "Valley of the Forsaken";
        String space = "|" + " ".repeat(title.length() + 2) + "|";

        System.out.println("-".repeat(title.length() + 4));
        System.out.println(space);
        System.out.println("|" + " " + title + " " + "|");
        System.out.println(space);
        System.out.println("-".repeat(title.length() + 4) + "\n\n");
    }
    public static String choice(String menuType) {
        String choices[];
        switch (menuType) {
            case "titleScreen" -> choices = new String[]{"new game", "continue", "quit"};
            case "overworld" -> choices = new String[]{"move", "info", "save and quit"};
            case "moveSelect" -> choices = new String[]{"up", "down"};
            case "displayType" -> choices = new String[]{"heroes", "items"};
            case "battleMenu" -> choices = new String[]{"attack", "item", "run"};
            default -> throw new IllegalStateException("Unexpected value: " + menuType);
        }
        for(String s : choices) {
            System.out.println("- " + Character.toUpperCase(s.charAt(0)) + s.substring(1));
        }
        boolean confirm = false;
        String choice;
        do {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                System.exit(1);
            }
            System.out.print("Your choice: ");
            choice = Keyboard.readString().trim().toLowerCase();
            for (String s : choices) {
                if (choice.equals(s)) {
                    confirm = true;
                    break;
                }
            }
            if (!confirm) {
                System.err.println("Invalid choice!");
            }
        }
        while (!confirm);
        return choice;
    }
}
