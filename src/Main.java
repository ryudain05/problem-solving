import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Person {

    String name;
    int age;
    String sex;
    int order;

    public Person (String name, int age, String sex, int order) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.order = order;
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();



        for(int i=0; i<N; i++) {
            if(i >= 500) break;
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            String sex = st.nextToken();
            people.add(new Person(name, age, sex, i));
        }

        Collections.sort(people, Comparator.
                comparing((Person pe) -> pe.age, Comparator.reverseOrder())
                .thenComparing((Person pe) -> pe.sex)
                .thenComparing((Person pe) -> pe.order)
        );

        for(Person person: people) {
            System.out.println(person.name+" "+person.age+" "+person.sex);
        }

    }
}