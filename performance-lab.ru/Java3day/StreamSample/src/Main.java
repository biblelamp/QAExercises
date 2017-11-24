import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {
        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .filter(s -> {
                    //дожен вернуть boolean
                    System.out.println("Фильтр: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("Печать с использованием forEach: " + s));

        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .sorted((s1, s2) -> {
            System.out.printf("sort: %s; %s\n", s1, s2);
            return s1.compareTo(s2);
        })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });
        //Избегаем повторного использования одного стрима.
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("dd2", "aa2", "bb1", "bb3", "cc")
                        .filter(s -> s.startsWith("a"));
        streamSupplier.get().anyMatch(s -> true);
        streamSupplier.get().noneMatch(s -> true);

        //продвинутые операции
        List<Person> persons =
                Arrays.asList(
                        new Person("Andrew", 20),
                        new Person("Igor", 23),
                        new Person("Ira", 23),
                        new Person("Vitia", 12));
        //Фильтр
        List<Person> filtered = persons.stream()
                .filter(p -> p.name.startsWith("I"))
                .collect(Collectors.toList());
        System.out.println("\n==Фильтр\n" + filtered);

        //Группировка
        Map<Integer, List<Person>> personsByAge = persons.stream()
                .collect(Collectors.groupingBy(p -> p.age));
        System.out.println("\n==Группировка");
        personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

        //определим средний возраст
        Double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt(p -> p.age));
        System.out.println("\n==Cредний возраст\n" + averageAge);

        //еще пример коллектора
        IntSummaryStatistics ageSummary = persons.stream()
                .collect(Collectors.summarizingInt(p -> p.age));
        System.out.println("\n===\n" + ageSummary); // IntSummaryStatistics{count=4, sum=78, min=12, average=19.500000, max=23}
        String phrase = persons.stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining(", ", "Эти люди: ", " совершеннолетние."));
        System.out.println("\n==Больше 18\n" + phrase);

        //Преобразование одного потока в несколько
        // подготовительный этап
        List<Bar> bars = Arrays.asList(new Bar("Bar1"), new Bar("Bar2"), new Bar("Bar3"));
        List<Foo> foos = Arrays.asList(new Foo("Foo1"), new Foo("Foo2"), new Foo("Foo3"));
        foos.forEach(f -> {f.bars = bars;});

        System.out.println("\n==FlatMap");
        foos.stream()
                .flatMap(f -> f.bars.stream()) //получаем стрим для каждого bars
                .forEach(b -> System.out.println(b.name));
    }
}