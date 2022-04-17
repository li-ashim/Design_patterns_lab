package TeaCoffeeMenu;

public interface IDrinkBuilder {
    /*Сбросить все доп. компоненты до напитка по умолчанию*/
    void reset();
    /*Создание напитка для дальнейшей модификации */
    void initialize(Drink d);
    /*Получить собранный напиток для добавления в заказ*/
    Drink getResult();
}
