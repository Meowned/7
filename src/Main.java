public class Main {

    private static int TIME = 0;

    public static void main(String[] args) {

        Cat[] cat = new Cat[4];
        cat[0] = new Cat("Блевун", 150, 3);
        cat[1] = new Cat("Рыгач", 100, 4);
        cat[2] = new Cat("Демон", 30, 1);
        cat[3] = new Cat("Хлимяу", 40, 2);
        Plate plate = new Plate(700);
        System.out.println("Есть 4 пылесборника: " + cat[0].getName() + ", " + cat[1].getName() + " и " + cat[2].getName() + " и " + cat[3].getName() + ", которые жрут каждые " + cat[0].getSatietyTime() + ", " + cat[1].getSatietyTime() + ", " + cat[2].getSatietyTime() + ", " + cat[3].getSatietyTime() + " час(а) соответственно.");
        System.out.println("Сейчас в миске " + plate.getFood() + " грамм кошачьего корма. Начнутся голодные игры!\n");

        do {
            for (Cat i : cat) {

                if (i.getSatiety() == 0) {

                    //Кошачий бог автоматически подсыпает корма
                    if (!plate.checkFood(i.getAppetite())) {
                        plate.increaseFood();
                    }

                    i.eat(plate);
                    System.out.println(i.getName() + " сожрал в одну морду " + i.getAppetite() + " грамм корма и повторит это через " + (i.getSatiety()) + " часа(ов)");
                }

                i.setSatiety(i.getSatiety() - 1);
            }
            System.out.println("\nС последней кормёжки прошло " + TIME + " час(а). В миске осталось " + plate.getFood() + " грамм корма.\n");
            TIME++;

        } while (TIME <= 24);
    }
}

class Plate {

    private int food;

    int getFood() {
        return food;
    }

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int n) {
        food -= n;
    }

    void increaseFood() {
        this.food += 400;
        System.out.println("Кошачий бог досыпал 400 грам корма");
    }

    boolean checkFood(int n) {
        return (food - n) >= 0;
    }

}

class Cat {

    private String name;
    private int appetite;
    private int satietyTime;
    private int satiety;

    String getName() {
        return name;
    }

    int getAppetite() {
        return appetite;
    }

    int getSatietyTime() {
        return satietyTime;
    }

    int getSatiety() {
        return satiety;
    }

    void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    Cat(String name, int appetite, int satietyTime) {

        this.name = name;
        this.appetite = appetite;
        this.satietyTime = satietyTime;
        this.satiety = 0;
    }

    void eat(Plate p) {
        p.decreaseFood(appetite);
        satiety += satietyTime;
    }
}