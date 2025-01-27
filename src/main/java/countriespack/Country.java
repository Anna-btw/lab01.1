package countriespack;

public class Country {
    String nameCountry;
    int areaCountry;
    int populationCountry;
    String nameCapital;
    Integer areaCapital;    //используем Integer для возможности null
    int populationDensity;

    // Конструктор класса, принимающий значения всех атрибутов
    public Country(String nameCountry, int areaCountry, int populationCountry, String nameCapital, Integer areaCapital) {
        this.nameCountry = nameCountry;
        this.areaCountry = areaCountry;
        this.populationCountry = populationCountry;
        this.nameCapital = nameCapital;
        this.areaCapital = areaCapital;

    // В конструкторе класса проверяем перед делением, что areaCountry != 0
        if (areaCountry != 0) {
            this.populationDensity = populationCountry / areaCountry;
        } else {
            this.populationDensity = 0;
            System.out.println("Площадь страны не может быть нулевой. Плотность населения установлена = 0");
        }
    }

    // Конструктор для городов-государств
    public Country(String nameCountry, int areaCountry, int populationCountry) {
        this.nameCountry = nameCountry;
        this.areaCountry = areaCountry;
        this.populationCountry = populationCountry;
        this.nameCapital = null;
        this.areaCapital = null;
        // вычисляем плотность населения чрз тернарный оператор
        // (тут_условие) ? тут_выражение_ктр_выполняется_при_условии_true : тут_выражение_ктр_выполняется_при_условии_false
        this.populationDensity = (areaCountry != 0) ? populationCountry / areaCountry : 0;
    }

    //get-методы, возвращающие значения атрибутов класса
    public String getNameCountry() {
        return nameCountry;
    }

    public int getAreaCountry() {
        return areaCountry;
    }

    public int getPopulationCountry() {
        return populationCountry;
    }

    public String getNameCapital() {
        return nameCapital;
    }

    public Integer getAreaCapital() {
        return areaCapital;
    }

    public int getPopulationDensity() {
        return populationDensity;
    }

    //set-методы, устанавливающие значения атрибутов, в т.ч.: площадь и население >0, название !null
    public void setNameCountry(String nameCountry) {
        if (nameCountry != null && !nameCountry.isEmpty()) {
            this.nameCountry = nameCountry;
        } else {
            throw new IllegalArgumentException("Ошибка. Название не должно быть пустой ссылкой");
        }
    }

    public void setAreaCountry(int areaCountry) {
        if (areaCountry > 0){
            this.areaCountry = areaCountry;
    } else {
            throw new IllegalArgumentException("Ошибка. Площадь должна быть >0");
        }
    }

    public void setPopulationCountry(int populationCountry) {
        if (populationCountry > 0){
            this.populationCountry = populationCountry;
        } else {
            throw new IllegalArgumentException("Ошибка. Население должно быть >0");
        }
    }

    public void setNameCapital(String nameCapital) {
        this.nameCapital = nameCapital;
    }

    public void setAreaCapital(Integer areaCapital) {
        this.areaCapital = areaCapital;
    }

    //метод, задающий данные о столице
    public void setCapitalData(String nameCapital, Integer areaCapital) {
        this.nameCapital = nameCapital;
        this.areaCapital = areaCapital;
    }

    //метод, сбрасывающий данные о столице;
    public void resetCapitalData() {
        this.nameCapital = null;
        this.areaCapital = null;
    }

    public void print() {
        System.out.print("Страна: " + nameCountry);
        System.out.print(", площадь страны: " + areaCountry + " кв.км.");
        System.out.print(", население: " + populationCountry + " чел.");
        if (nameCapital != null) {
            System.out.print(", столица: " + nameCapital);
            if (areaCapital != null) {
                System.out.print(", площадь столицы: " + areaCapital + " кв.км.");
            }
        } else {
            System.out.print("");
        }
        System.out.println(", плотность населения страны: " + populationDensity + " чел./кв.км.");
    }

    public static void printAll(Country[] countries) {
        for (Country country : countries) {
            country.print(); // Вызываем метод print для каждого объекта Country
        }
    }
}




