package FileWriteExam;

import java.io.*;

public class SchoolDataMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SchoolDataExam2 sd = new SchoolDataExam2();
		try {
			sd.readingData("src/FileWriteExam/sung_data.txt");
			sd.writingData("src/FileWriteExam/sung_write.txt");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
