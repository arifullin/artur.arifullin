package Comparator;

import java.util.Comparator;

public class StudentHelper {
    public void buble(Student[] x1,Comparator compar){
        for (int i = 0; i < x1.length ;i++){
            for (int j = 0; j < x1.length - 1 - j; j++) {
                if (compar.compare(x1[j],x1[j+1]) > 0){
                    Student temp = new Student(0,0);
                    temp = x1[j];
                    x1[j] = x1[j+1];
            } else if ((!(x1 instanceof Student)) && (x2 instanceof Student)){
                x1[j+1] = temp;
            }
        }
    }
}
private class Grade implements Comparator {
    public int compare(Object x1, Object x2) {
        if ((x1 instanceof Student) && (x2 instanceof Student)) {
            Student temp1 = (Student) x1;
            Student temp2 = (Student) x2;
            if (temp1.grade == temp2.grade) {
                return 0;
            } else if (temp1.grade > temp2.grade) {
                return 1;
            } else {
                return -1;
            }
            } else if ((x1 instanceof Student) && !(x2 instanceof Student)){
                return 1;
            }
            return 0;
        }
    }

    public Comparator byGrade() {

        return new Grade();
    }

}

