package com.bootcamp.functional.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamplesApplication.class, args);

//        System.out.println("IMPERATIVA");
//        imperativa();
////
//        System.out.println("FUNCIONAL");
//        funcional();

        funcionalObjetos();

    }

    public static void imperativa() {
        List<Integer> listaEnteros = List.of(0, 1, 2, 3, 5, 8, 13, 21, 34);
        System.out.println("listaEnteros = " + listaEnteros);

        List<Integer> listaPares = new ArrayList<>();
        for (Integer element : listaEnteros) {
            if (element % 2 == 0) {
                listaPares.add(element);
            }
        }
        System.out.println("listaPares = " + listaPares);

        List<Integer> cuadrados = new ArrayList<>();
        for (Integer element : listaPares) {
            cuadrados.add((int) Math.pow(element, 2));
        }
        System.out.println("cuadrados = " + cuadrados);

        Integer sumaCuadrados = 0;
        for (Integer element : cuadrados) {
            sumaCuadrados += element;
        }
        System.out.println("sumaCuadrados = " + sumaCuadrados);

        boolean existeCeros = false;
        for (Integer element : listaEnteros) {
            existeCeros = element == 0;
            break;
        }
        System.out.println("existeCeros = " + existeCeros);

        Integer primerCuadrado = listaEnteros.get(0);
        System.out.println("primerCuadrado = " + primerCuadrado);

        Integer ultimoCuadrado = cuadrados.get(cuadrados.size() - 1);
        System.out.println("ultimoCuadrado = " + ultimoCuadrado);

    }

    public static void funcional() {
        List<Integer> listaEnteros = List.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 1, 2, 3);
        System.out.println("listaEnteros = " + listaEnteros);

        List<Integer> listaSinDuplicados = listaEnteros.stream().distinct()
                .collect(Collectors.toList());
        System.out.println("listaSinDuplicados = " + listaSinDuplicados);

        List<Integer> listaPares = listaEnteros
                .stream().filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("listaPares = " + listaPares);

        List<Integer> cuadrados = listaPares.stream()
                .map(y -> (int) Math.pow(y, 2))
                .collect(Collectors.toList());
        System.out.println("cuadrados = " + cuadrados);

        // Obtener cubos de los elementos de la lista emteros que son menores a 1000.
        List<Integer> cubos = listaPares.stream()
                .filter(p -> p > 0)
                .map(x -> (int) Math.pow(x, 3))
                .filter(x -> x < 1000)
                .collect(Collectors.toList());
        System.out.println("cubos = " + cubos);

        Integer sumaCuadrados = cuadrados.stream()
                .reduce((suma, element) -> suma + element)
                .get();
        System.out.println("sumaCuadrados = " + sumaCuadrados);

//        boolean existeCeros = listaEnteros.stream()
//                .anyMatch(x ->  x == 0);
//
//        boolean existeCeros = listaEnteros
//                .stream()
//                .anyMatch(x -> {
//                    return x == 0;
//                });

        boolean existeCeros = listaEnteros.stream()
                .anyMatch(x -> esCero(x));
        System.out.println("existeCeros = " + existeCeros);

        Integer primerCuadrado = cuadrados.stream().findFirst().get();
        System.out.println("primerCuadrado = " + primerCuadrado);

        Integer ultimoCuadrado = cuadrados.stream()
                .sorted(Comparator.reverseOrder())
                .findFirst().get();
        System.out.println("ultimoCuadrado = " + ultimoCuadrado);

        List<Integer> cuadradosOrdenDesc = cuadrados.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("cuadradosOrdenDesc = " + cuadradosOrdenDesc);
        
        Integer maximoCuadrado= cuadrados.stream().max(Comparator.naturalOrder()).get();
        System.out.println("maximoCuadrado = " + maximoCuadrado);

        Integer minimoCuadrado= cuadrados.stream().min(Comparator.naturalOrder()).get();
        System.out.println("minimoCuadrado = " + minimoCuadrado);


    }

    private static boolean esCero(Integer x) {
        if (x == 0) {
            return true;
        }
        return false;
    }

    public static void funcionalObjetos() {

        List<Author> authors = new ArrayList<>();

        Author author1 = new Author(1, "Shakespeare", 1700);
        author1.addBook(1, "Romeo y Julieta", 2019);
        author1.addBook(2, "Hamlet", 2020);

        Author author2 = new Author(2, "Mario Vargas llosa", 1960);
        author2.addBook(3, "La ciudad y los perros", 2018);
        author2.addBook(4, "Lituma en los andes", 2017);

        Author author3 = new Author(3, "Ciro Alegria", 1910);
        author3.addBook(5, "Los perros hambrientos", 2020);
        author3.addBook(6, "El mundo es ancho y ajeno", 2020);

        Author author4 = new Author(4, "Jane Austen", 1800);
        author4.addBook(7, "Sentido y Sensibilidad", 2019);

        authors = List.of(author1, author2, author3, author4);

        authors.stream().forEach(x -> System.out.println(x));

        List<String> authorsName = authors.stream()
                .map(x -> x.getName()).collect(Collectors.toList());
        System.out.println("authorsName = " + authorsName);

//        List<String> authorsName = new ArrayList<>();
//        authors.stream().forEach(x -> authorsName.add(x.getName()));
//        System.out.println("authorsName = " + authorsName);

        List<Author> authoresCon1libro = authors.stream()
                .filter(x -> x.getBooks().size() == 1)
                .collect(Collectors.toList());
        System.out.println("authoresCon1libro = " + authoresCon1libro);


        List<String> authores2020 = authors.stream()
                .filter(x ->
                        x.getBooks().stream()
                                .anyMatch(y -> y.getPublishYear() == 2020))
                .map(x -> x.getName())
                .collect(Collectors.toList());
        System.out.println("authores2020 = " + authores2020);

        List<String> authores2020_doslibros = authors.stream()
                .filter(x ->
                        x.getBooks().stream()
                                .filter(y -> y.getPublishYear() == 2020).count() == 2)
                .map(x -> x.getName())
                .collect(Collectors.toList());
        System.out.println("authores2020_doslibros = " + authores2020_doslibros);

        List<String> authoresNameSorted = authors.stream()
                .map(a -> a.getName())
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println("authoresNameSorted = " + authoresNameSorted);

//        SELECT Name FROM Author ORDER BY Name ASC

        List<String> authoresNameSortedByYear = authors.stream()
                .sorted(Comparator.comparing(Author::getBirthYear))
                .map(a -> a.getName())
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("authoresNameSortedByYear = " + authoresNameSortedByYear);

//        SELECT TOP 2 Name FROM Author ORDER BY birthYear ASC

        List<String> authoresNameSortedByYearReverse = authors.stream()
                .sorted(Comparator.comparing(Author::getBirthYear).reversed())
                .map(a -> a.getName())
                .collect(Collectors.toList());
        System.out.println("authoresNameSortedByYearReverse = " + authoresNameSortedByYearReverse);

//        SELECT Name FROM Author ORDER BY birthYear DESC

        List<String> books = authors.stream()
                .map(a-> a.getBooks())
                .flatMap(b-> b.stream())
                .map(n->n.getTitle())
                .collect(Collectors.toList());
        System.out.println("books = " + books);

//  SELECT b.title FROM Author a INNER JOIN Book b ON a.AuthorId=b.AuthorId

    }

}
