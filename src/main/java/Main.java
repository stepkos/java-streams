import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Initial list
        List<Circle> circles = new ArrayList<Circle>();

        // Initial values
        for (int i=0; i<30; i++) {
            circles.add(new Circle(Math.random()*10));
        }

        // a) figury o większym obwodzie niż polu
        System.out.println("\na) figury o większym obwodzie niż polu");
        circles.stream()
                .filter(c -> c.getCircuit() > c.getArea())
                .forEach(System.out::println);


        // b) rosnąco figury według pola
        System.out.println("\nb) rosnąco figury według pola");
        circles.stream()
                .sorted(Comparator.comparingDouble(Circle::getArea))
                .forEach(System.out::println);


        // c) malejąco według obwodu
        System.out.println("\nc) malejąco według obwodu");
        circles.stream()
                .sorted(Comparator.comparingDouble(Circle::getCircuit).reversed())
                .forEach(System.out::println);


        // d) średnią obwodów wszystkich figur
        System.out.println("\nd) średnią obwodów wszystkich figur");
        circles.stream()
                .mapToDouble(Circle::getCircuit)
                .average()
                .ifPresent(System.out::println);


        // e) sumę pól wszystkich figur
        System.out.println("\ne) sumę pól wszystkich figur");
        System.out.println(circles.stream()
                .mapToDouble(Circle::getArea)
                .sum());


        Map<Double, Circle> circlesMap = circles.stream()
                .collect(Collectors.toMap(
                        c -> c.getArea(),
                        c -> c
                ));

    }
}
