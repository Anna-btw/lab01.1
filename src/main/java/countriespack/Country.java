package countriespack;

public class Country {
    private String name; // private чтобы атрибутами класса можно оперировать только внутри класса
    private int area;
    private int population;
    private String capital;
    private Integer areaCapital;    //используем Integer для возможности null
    private int densityPopulation;

    // Конструктор класса, принимающий значения всех атрибутов, через this
    /*
    public Country(String name, int area, int population, String capital, Integer areaCapital) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.capital = capital;
        this.areaCapital = areaCapital;
     */
    // Конструктор класса, принимающий значения всех атрибутов, через setter
    public Country (String name, int area, int population, String capital, Integer areaCapital) {
        setName(name);
        setArea(area);
        setPopulation(population);
        setCapital(capital);
        setAreaCapital(areaCapital);
        // ф-ция вычисления, вынесли логику вычисления из конструктора
        calculateDensityPopulation(population,area);

    // В конструкторе класса проверяем перед делением, что areaCountry != 0

    }

    // Конструктор для городов-государств
    public Country(String name, int area, int population) {
        setName(name);
        setArea(area);
        setPopulation(population);
        capital = null; // можно не писать this. , так как в Конструктор не передаем capital и areaCapital
        areaCapital = null;
        calculateTernDensityPopulation(population, area);
    }

    //get-методы, возвращающие значения атрибутов класса
    public String getName() {
        return name;
    }

    public int getArea() {
        return area;
    }

    public int getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public Integer getAreaCapital() {
        return areaCapital;
    }

    public int getDensityPopulation() {
        return densityPopulation;
    }

    //в ф-ции высчитываем и устанавливаем densityPopulation
    private void calculateDensityPopulation(int population, int area) {
        if (area == 0) {
            this.densityPopulation = 0;
            System.out.println("Площадь страны не может быть нулевой. Плотность населения установлена = 0");
        }
        this.densityPopulation = population / area;
    }

    //в ф-ции чрз тернарный оператор высчитываем плотность населения
    private void calculateTernDensityPopulation(int population, int area) {
        // (тут_условие) ? тут_выражение_ктр_выполняется_при_условии_true : тут_выражение_ктр_выполняется_при_условии_false
        this.densityPopulation = (area != 0) ? population / area : 0;
    }

    //set-методы, устанавливающие значения атрибутов, в т.ч.: площадь и население >0, название !null
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ошибка. Название не должно быть пустой ссылкой");}
        this.name = name;
    }

    //1й ВАРИАНТ условия, через позитивную проверку
    /*
    public void setArea(int area) {
        if (area > 0){
            this.area = area;
    } else {
            throw new IllegalArgumentException("Ошибка. Площадь должна быть >0");
        }
    }
     */

    //2й ВАРИАНТ условия, через негативную проверку
    public void setArea(int area) {
        if (area <= 0)
            {throw new IllegalArgumentException("Ошибка. Площадь должна быть >0");}
        this.area = area;
    }

    public void setPopulation(int population) {
        if (population <= 0){
            throw new IllegalArgumentException("Ошибка. Население должно быть >0");
        }
        this.population = population;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setAreaCapital(Integer areaCapital) {
        this.areaCapital = areaCapital;
    }

    //метод, задающий данные о столице
    public void setCapitalData(String capital, Integer areaCapital) {
        this.capital = capital;
        this.areaCapital = areaCapital;
    }

    //метод, сбрасывающий данные о столице;
    public void resetCapitalData() {
        this.capital = null;
        this.areaCapital = null;
    }

    public void print() {
        System.out.print("Страна: " + name);
        System.out.print(", площадь страны: " + area + " кв.км.");
        System.out.print(", население: " + population + " чел.");
        if (capital != null) {
            System.out.print(", столица: " + capital);
            if (areaCapital != null) {
                System.out.print(", площадь столицы: " + areaCapital + " кв.км.");
            }
        } else {
            System.out.print("");
        }
        System.out.println(", плотность населения страны: " + densityPopulation + " чел./кв.км.");
    }

    public static void printAll(Country[] countries) {
        for (Country country : countries) {
            country.print(); // Вызываем метод print для каждого объекта Country
        }
    }
}




