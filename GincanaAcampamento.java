import java.util.LinkedList;
import java.util.Scanner;

public class GincanaAcampamento {

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        int testCases;

        while ((testCases = scan.nextInt()) != 0) {
            var students = new LinkedList<Student>();

            for (var i = 0; i < testCases; i++) {
                students.add(new Student(scan.next(), scan.nextInt()));
            }

            var position = 0;
            var card = students.getFirst().getCard();

            while (students.size() > 1) {

                if (card % 2 != 0) {
                    position = (position + card) % students.size();
                } else {
                    position = (position - (card % students.size())) % students.size();

                    // if the position becomes negative, we must make it positive. So, we subtract from the list size.
                    if (position < 0)
                        position = students.size() + position;
                }

                card = students.get(position).getCard();
                students.remove(position);

                // if odd, move back one position to ensure that in the next iteration the correct position is pointed out.
                if (card % 2 != 0)
                    position--;
            }

            System.out.println("Vencedor(a): " + students.getFirst().getName());
        }
        
        scan.close();
    }

    public static class Student {
        private String name;
        private int card;

        public Student(String name, int card) {
            this.card = card;
            this.name = name;
        }

        public int getCard() {
            return card;
        }

        public String getName() {
            return name;
        }
    }
}