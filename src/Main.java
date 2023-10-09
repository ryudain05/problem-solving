import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
    String name;
    int age;
    int order;

    public Person(String name, int age, int order) {
        this.name = name;
        this.age = age;
        this.order = order;
    }

    @Override
    public int compareTo(Person person) {
        int AgeCompare = Integer.compare(person.age, this.age);
        if(AgeCompare == 0){
            return Integer.compare(this.order, person.order);
        }
        return AgeCompare;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Person[] people = new Person[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            people[i] = new Person(name, age, i);
        }

        Arrays.sort(people);

        for (int i = 0; i < N; i++) {
            System.out.println(people[i].name);
        }
    }
}
