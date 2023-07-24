package Streams.caseStudyPractice;


import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/*
Book application case study:
-----------------------------
Domain model:

enum Subject{
	JAVA, DOT_NET, ORACLE;
}

class Author {
	private String name;
	private String lastname;
	private String country;
}



class Book {

	private String title;
	private List<Author> authors;
	private int pages;
	private Subject subject;
	private int year;
	private String isbn;
}

Problems:
----------
1. Find books with more then 400 pages

2. Find all books that are java books and more then 400 pages

3. We need the top three longest books

4. We need from the fourth to the last longest books

5. We need to get all the publishing years

6. We need all the authors who have written a book

* */
enum Subject{
    JAVA, DOT_NET, ORACLE;
}
class Author {
    private String name;
    private String lastname;
    private String country;

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCountry() {
        return country;
    }

    public Author(String name, String lastname, String country) {
        this.name = name;
        this.lastname = lastname;
        this.country = country;
    }
}
class Book {

    private String title;
    private List<Author> authors;
    private int pages;
    private Subject subject;
    private int year;
    private String isbn;

    public Book(String title, List<Author> authors, int pages, Subject subject, int year, String isbn) {
        this.title = title;
        this.authors = authors;
        this.pages = pages;
        this.subject = subject;
        this.year = year;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
public class BookAuthorCaseStudy {

    public static void main(String[] args) {


        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Head First Java",
                                Arrays.asList(
                                        new Author("srikanth","d","india"),
                                        new Author("rajesh","t","USA")

                                ),600,Subject.JAVA,2009,"1st345bn"));
        listOfBooks.add(new Book("Advanced Java",
                Arrays.asList(
                        new Author("harikrishna","d","india"),
                        new Author("namkar","t","USA")

                ),350,Subject.JAVA,2019,"1st365bn"));
        listOfBooks.add(new Book("A-Z Java",
                Arrays.asList(
                        new Author("Peter Heins","Nokar","USA"),
                        new Author("Nav dijakova","Nerri","Germany")

                ),650,Subject.JAVA,2009,"1st345bn"));
        listOfBooks.add(new Book("DOT NET in onego",
                Arrays.asList(
                        new Author("ramakrishna","nvt","Australia"),
                        new Author("madan kumar","R.E.S","India")

                ),490,Subject.DOT_NET,2015,"1st3461j"));

        listOfBooks.add(new Book("DOT NET master",
                Arrays.asList(
                        new Author("Minjalkova","KT","USA"),
                        new Author("Rocky","R.S","France")

                ),990,Subject.DOT_NET,2017,"1st3468j"));

        listOfBooks.add(new Book("Great DOTNET",
                Arrays.asList(
                        new Author("Gertyu","JNY","norway"),
                        new Author("htryu chincr","bgh","Hongkong")

                ),790,Subject.DOT_NET,2011,"1st306j"));
        listOfBooks.add(new Book("ORACLE 11",
                Arrays.asList(
                        new Author("Najeem","m","India"),
                        new Author("natemar","t","USA"),
                        new Author("ertui","t","USA"),
                        new Author("jamerr","t","Australia")

                ),399,Subject.ORACLE,2020,"1st375bn"));

        listOfBooks.add(new Book("ORACLE Master",
                Arrays.asList(
                        new Author("ghetu","hnjy","Finland"),
                        new Author("Reth","jubir","Norway"),
                        new Author("etribg","jatm","India")


                ),600,Subject.ORACLE,2020,"1st375bn"));
        listOfBooks.add(new Book("Latest Oracle",
                Arrays.asList(
                        new Author("srikanth","d","india"),
                        new Author("ertuio","t","usa")

                ),600,Subject.ORACLE,2020,"1st375bn"));

        System.out.println("1. Find books with more than 400 pages");
        long no_of_books = listOfBooks.stream().filter(book -> book.getPages() > 400).count();
        System.out.println("Count of books "+ no_of_books);
        System.out.println("Book Names");
        System.out.println("===========");
        List<Book> listOfBooksGreaterThan400 = listOfBooks.stream().filter(book -> book.getPages()>  400).collect(Collectors.toList());
        listOfBooksGreaterThan400.forEach(book -> System.out.println(book.getTitle() +"Pages :"+book.getPages()));

        System.out.println("2.Print all the book than are greater than 400 pages and It is Java");
        System.out.println("===========");

        listOfBooks.stream()
                .filter( book -> book.getPages()>400 && book.getSubject().equals(Subject.JAVA))
                .forEach(book -> System.out.println(book.getTitle() + "Pages : "+book.getPages()));

        System.out.println("3. We need the top three longest books");
        listOfBooks.stream().sorted(Comparator.comparing(Book::getPages).reversed()).limit(3).forEach(i->System.out.println(i.getTitle() + "Pages: "+i.getPages()));

        System.out.println("4. We need the fourth to last");
        listOfBooks.stream().sorted(Comparator.comparing(Book::getPages).reversed()).skip(3).forEach(i->System.out.println(i.getTitle()));

        System.out.println("5.Need All the Publishing years");
        List<Integer> listOfPublishingYears = listOfBooks.stream().map(book->book.getYear()).distinct().collect(Collectors.toList());
        System.out.println("All publishing Years" + listOfPublishingYears);

        System.out.println("5.Need All authors");
         listOfBooks.stream().flatMap(book->book.getAuthors().stream()).forEach(author -> System.out.println(author.getName()));

         System.out.println("6. We need all the origin countries of the authors");

         listOfBooks.stream().flatMap(book -> book.getAuthors().stream()).map(author -> author.getCountry()).distinct().forEach(a-> System.out.println(a));

        System.out.println("7. We need latest Published Book");
       Optional<Book> latestBook = listOfBooks.stream().max(Comparator.comparing(Book::getYear));
        if(latestBook.isPresent())
            System.out.println(latestBook.get().getTitle() + " " + latestBook.get().getYear());

        System.out.println("8. We want to know if all the books are written by more than one author");
        /*
            anyMatch(Predicate) will match the condition for entire stream and return the boolean value
         */
        boolean result = listOfBooks.stream().allMatch(book->book.getAuthors().size()>1);
        System.out.println(result);
       List<Book>  result1 = listOfBooks.stream().filter(book->book.getAuthors().size()>1).collect(Collectors.toList());
       result1.forEach(book-> System.out.println(book.getTitle()));

        System.out.println("9.We want to know how many pages the longest book has.");
       //Book book  = listOfBooks.stream().max(Comparator.comparing(Book::getPages)).get();
        Optional<Integer> longestBook = listOfBooks.stream()
                .map(Book::getPages)
                .reduce(Integer::max);
        //System.out.println(count.isPresent()?count.get().getPages():0);
        System.out.println((longestBook.orElse(0)));
        System.out.println(" 10. We want the total number of pages published ");

        long numberOfPages = listOfBooks.stream().map(Book::getPages).reduce(0, Integer::sum);
        System.out.println("Total number of pages "+numberOfPages);

        System.out.println("11.We want the average number of pages of the books");
        int totalPages = listOfBooks.stream().map(Book::getPages).reduce(0, Integer::sum);
        Double average = (totalPages+0.0)/(listOfBooks.size()+0.0);
        System.out.println(average);

        Double avgPages = listOfBooks.stream()
                .collect(Collectors.averagingDouble(Book::getPages));
        System.out.println(avgPages);

        System.out.print("12.We want the book with the higher number of authors?");
        Optional<Book> lis = listOfBooks.stream().max(Comparator.comparing(books -> books.getAuthors().size()));
        Optional<Book> lisr = listOfBooks.stream().collect(Collectors.maxBy(Comparator.comparing(books->books.getAuthors().size())));
        System.out.println(lis.map(Book::getTitle).orElse(null));
        System.out.println(lis.map(Book::getTitle).orElse(null));

        System.out.println("13.We want a Map of book per year");
        Map<Integer,List<Book>> map = listOfBooks.stream().collect(Collectors.groupingBy(Book::getYear));
        map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,e-> new ArrayList<>(e.getValue())));

        Map<Integer, Map<Subject, List<Book>>> map1 = listOfBooks.stream()
                .collect(Collectors.groupingBy(Book::getYear,
                        Collectors.groupingBy(Book::getSubject)));
       System.out.println(map1);
//        listOfBooks.stream()
//                .collect(Collectors.groupingBy(Book::getYear),
//                        Collectors.groupingBy(Book::getSubject));

        System.out.println("14.We want books count per year");

       Map<Integer,Long> countofBooksPerYear= listOfBooks.stream().sorted(Comparator.comparing(Book::getYear)).collect(Collectors.groupingBy(Book::getYear,Collectors.counting()));
        countofBooksPerYear.forEach((k,v)-> System.out.println(k+" "+v));



    }
}
