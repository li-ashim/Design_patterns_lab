package TeaCoffeeMenu;

public interface IBuilder<T> {

    void reset();
    /*Создание базового продукта для дальнейшей модификации */
    void initialize(T d);
    /*Добавление в продукт компонентов */
    void addComponent();
    /*Получить собранный напиток для добавления в заказ*/
    T getResult();
}
