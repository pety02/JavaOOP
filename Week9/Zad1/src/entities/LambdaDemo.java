package entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

class LambdaDemo
{
    public static void main(String[] args)
    {
        Predicate<SalesPerson> predicate1 = salePerson -> salePerson.getSalesCount() > 1200; // да се инициализира
        Predicate<SalesPerson> predicate2 = salePerson -> salePerson.getSalesCount() > 900; // да се инициализира
        Predicate<SalesPerson> predicate = salePerson -> predicate1.test(salePerson) || predicate2.test(salePerson); // да се инициализира
        Consumer<SalesPerson> consumer1 = salesPerson ->
            {
                salesPerson.setSalary(salesPerson.getSalary() * 1.05);
                System.out.println(salesPerson);
            }; // да се инициализира
        Consumer<SalesPerson> consumer2 = salePerson ->
        {
            if(predicate.test(salePerson)) {
                salePerson.setSalary(salePerson.getSalary() * 1.05);
            } else {
                salePerson.setSalary(salePerson.getSalary() * 0.98);
            }
            System.out.println(salePerson);
        };
        SalesPerson[] salesPersons =
                {
                        new SalesPerson("John Doe", 2000, 949),
                        new SalesPerson("Jane Doe", 3900, 1500),
                        // да се добавят още 10 обекти от тип Salesperson
                        // или да се инициализират с Random стойности
                };
        Comparator<SalesPerson> comparator = (o1, o2) -> (int)(o1.getSalary() - o2.getSalary());
        Comparator<SalesPerson> comparator1 = comparator.reversed(); // да се инициализира
        Comparator<SalesPerson> comparator2 = (o1, o2) -> {
            if (o1.getSalary() == o2.getSalary()) return (o1.getSalesCount() - o2.getSalesCount());
            else return comparator.compare(o1, o2);
        }; // да се инициализира

        List<SalesPerson> listOfSalespersons = new ArrayList<>();
        // обектите на salesPersons да се запишат в
        // listOfSalespersons
        for (SalesPerson salePerson: salesPersons)
        {
            listOfSalespersons.add(salePerson);
            applyBonus(salePerson, predicate1, consumer1);
            System.out.println(salePerson);
            salePerson.printNumSales(salePerson);

        }
        for (SalesPerson salePerson: salesPersons)
        {
            applyBonus(salePerson, predicate2, consumer2);
            System.out.println(salePerson);
        }
        sort(listOfSalespersons, comparator1);
        System.out.println(listOfSalespersons);
        sort(listOfSalespersons, comparator2);
        System.out.println(listOfSalespersons);

    }

    public static void applyBonus(SalesPerson salesperson,
                                  Predicate<SalesPerson>
                                          predicate,
                                  Consumer<SalesPerson> consumer)
    {
        // Напишете if команда, където използвайте predicate
        // за да определите дали да изпълните consumer
        // Изпълнете consumer, когато условието на if командата е изпълнено
        if(predicate.test(salesperson)) {
            consumer.accept(salesperson);
        }
    }

    public static void applyBonus(List<SalesPerson> salespersons,
                                  Predicate<SalesPerson>
                                          predicate,
                                  Consumer<SalesPerson> consumer)
    {
        // Напишете if команда, където използвайте predicate
        // за да определите дали да изпълните consumer
        // Изпълнете consumer, когато условието на if командата е изпълнено
        salespersons.forEach(s -> {
            if (predicate.test(s)) {
                consumer.accept(s);
            }
        });
    }
    public static void sort(List<SalesPerson> salespersons,
                            Comparator<SalesPerson>
                                    comparator)
    {
        // Сортирайте salespersons като използвате comparator
        salespersons.forEach((s1) -> salespersons.forEach((s2) -> comparator.compare(s1, s2)));
    }
    public static void group(List<SalesPerson> salespersons)
    {
        // Групирайте имената на salespersons по първата буква в
        // името изведете отделните групи на стандартен изход
        Comparator<SalesPerson> nameComparator = (s1, s2) -> (int)(s1.getName().charAt(0) - s2.getName().charAt(0));
        salespersons.forEach((s1) -> salespersons.forEach((s2) -> nameComparator.compare(s1, s2)));
    }
}