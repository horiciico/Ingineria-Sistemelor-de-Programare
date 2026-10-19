import java.util.*;

public class Student {
    private String nume;
    private String grupa;
    private List<Integer> note;

    public Student(String nume, String grupa) {
        this.nume = nume;
        this.grupa = grupa;
        note = new ArrayList(5);
    }

    public String getNume() {
        return this.nume;
    }

    public String getGrupa() {
        return this.grupa;
    }

    public void adaugaNote() {
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            this.note.add(rand.nextInt(7) + 4);
        }
    }

    public boolean esteIntegralist()
    {
        for(Integer i:this.note) if(i<5) return false;
        return true;
    }

    public  Integer medie() {
        int sum=0;
        int counter=0;
        for(int i=0; i<this.note.size(); i++)
        {
            int nota=note.get(i);
            sum+=nota;
            counter++;
        }
        return sum/counter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nume: ").append(this.nume).append("\n");
        sb.append("Formatie de studiu: ").append(this.grupa).append("\n");
        sb.append("Note: ");

        for (Integer i : this.note) {
            sb.append(i).append(" ");
        }
        sb.append("\n");

        return sb.toString();
    }

    public int numaraRestante()
    {
        int counter=0;
        for(int n:this.note)
            if(n<5) counter++;
        return counter;
    }




    public static void main(String[] args) {
        List<Student> studenti = new ArrayList();
        studenti.add(new Student("Popescu Marian", "225_3"));
        studenti.add(new Student("PopescuMaria", "225_3"));
        studenti.add(new Student("Popa Marian", "225_3"));
        studenti.add(new Student("Bica Irina", "225_3"));
        studenti.add(new Student("Badea Ion", "225_1"));
        studenti.add(new Student("Cacoveanu Andreea", "225_1"));
        studenti.add(new Student("Onofrei Mircea", "225_1"));

        for (Student i : studenti) i.adaugaNote();


        //b1)
        Collections.sort(studenti, Comparator
                .comparing(Student::getGrupa)
                .thenComparing(Student::getNume)
        );


        System.out.println("Studentii ordonati alfabetic dupa grupa si nume:");
        for (Student s : studenti) {
            System.out.println(s);
        }


        //b2)
        List<Student> Integralisti = new ArrayList<>();
        for(Student s: studenti)
            if(s.esteIntegralist())
                Integralisti.add(s);

        Collections.sort(Integralisti, Comparator
                .comparing(Student::medie).reversed());

        System.out.println("Studentii integralisti ordonati descrescator dupa medie:");
        for(Student s: Integralisti) System.out.println(s);


        //b3)
        List<Student> Restantieri= new ArrayList<>();
        Restantieri.addAll(studenti);
        Restantieri.removeAll(Integralisti);

        if(Restantieri.isEmpty()) System.out.println("Nu exista restantieri");
        else
        {

                Collections.sort(Restantieri, Comparator
                        .comparing(Student::numaraRestante));
            System.out.println("Studentii restantieri ordonati crescator dupa numarul restantelor:");
            for(Student s: Restantieri) System.out.println(s);

        }
    }
}