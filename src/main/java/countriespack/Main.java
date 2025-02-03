package countriespack;

public class Main {
    public static void main(String[] args) {
        // Создание массива из стран без ограничения по кол-ву
        Country[] countries = {
            new Country("Russia", 17100000, 146700000, "Moscow", 12600000),
            new Country("Finland", 338000, 5500000, "Helsinki", 655000),
            new Country("France", 643800, 67800000, "Paris", 2100000),
            new Country("Andorra", 467, 85400, "Andorra la Vella", 22600),
            new Country("Singapore", 725, 5700000, null, null),
        };
        // Вывод информации о каждой стране
        for (Country countr : countries) {
            countr.print();
        }

        // Вызов статического метода для печати информации о всех странах
        Country.printAll(countries);

    }
}
