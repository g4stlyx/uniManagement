public class Main {
    public static void main(String args[]){

        Teacher t = new Teacher("ahmet","adres");
        System.out.println(t); // Teacher: ahmet(adres)

        t.addCourse("this is a course");
        t.addCourse("this is the second course");
        t.addCourse("this is a course"); //! the course you want to add is already exist!
        System.out.println(t.printCourses()); // [this is a course,this is the second course]
        t.removeCourse("this is a course"); // Courses after deletion: [this is the second course]
        t.removeCourse("there is no such a course"); //! the course you want to remove does not exist!
        System.out.println(t.printCourses()); // []
        

        new MainLoginFrame();
        
        // test students

    }
}
