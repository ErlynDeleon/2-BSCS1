import java.util.*;
import java.io.*;

public class StudentDA{
    private List<Student> studentList;

    //set getter method
    public List<Student> getStudentList(){
        return studentList;
    }

    //set the constructor for the StudentDA 

    public StudentDA(String blockCode) throws FileNotFoundException{ 

        studentList = new ArrayList<>();
        Scanner blockFileSectionStudentFile = new Scanner(new FileReader("BlockSectionStudents.csv"));

        while(blockFileSectionStudentFile.hasNext()){

            String blockSectionRaw = blockFileSectionStudentFile.nextLine();
            String[] blockSectionArray = new String[2];

            blockSectionArray = blockSectionRaw.split(",");

            if(blockSectionArray[0].trim().equals(blockCode)){
                Scanner studentFile = new Scanner(new FileReader("StudentFile.csv"));

            while(studentFile.hasNext()){
                String studentRaw = studentFile.nextLine();
                String[] studentArray = new String[2];
                
                studentArray = studentRaw.split(", ");

                if(blockSectionArray[1].trim().equals(studentArray[0].trim())){
                    Student student = new Student();

                    student.setStudentNo(studentArray[0].trim());
                    student.setLastName(studentArray[1].trim());
                    student.setFirstName(studentArray[2].trim());

                    studentList.add(student);
                }
            }
            studentFile.close();
            }            
        }

        blockFileSectionStudentFile.close();
    }
}