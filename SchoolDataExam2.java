package FileWriteExam;

import java.io.*;
import java.util.*;


public class SchoolDataExam2 {
	int length;
	int hakbun[] = new int[10];
	String name[] = new String[10];
	int kor[] = new int[10];
	int eng[] = new int[10];
	int math[] = new int[10];
	int sum[] = new int[10];
	int avg[] =new int[10];
	char hakjum[] = new char[10];
	int rank[] = new int[10];
	private char setHakjum(int avg) {
		char hakjum;
		switch(avg/10) {
		case 10 :
		case 9 :
			hakjum = 'A'; break;
		case 8 :
			hakjum = 'B';  break;
		case 7 :
			hakjum = 'C';  break;
		case 6 :
			hakjum = 'D';  break;
		default :
			hakjum = 'E';  break;
			
		}
		
		return hakjum;
	}
	
	public void writingData(String fname) throws IOException {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(new File(fname));
			bw = new BufferedWriter(fw);
			bw.write("학번	이름	국어	영어	수학	총점	평균	학점	등수");
			bw.newLine();
			bw.write("======================================================");
			bw.newLine();
			for(int i = 0; i<length; i++) {
				bw.write(hakbun[i]+"\t"+name[i]+"\t"+kor[i]+"\t"+eng[i]+"\t"+math[i]+"\t"+sum[i]+"\t"+avg[i]+"\t"+hakjum[i]+"\t"+rank[i]);
				bw.newLine();
			}
			
			bw.close();
			fw.close();
		} catch(FileNotFoundException e) {
			System.out.println("잘못된 파일 이름을 입력하셨습니다.");
		}
	}
	
	public void readingData(String fname) throws IOException {
		try {
			FileReader fr = new FileReader(new File(fname));
			BufferedReader br = new BufferedReader(fr);
			
			String tmpStr = "";
			String lStr = "";
			do {
				tmpStr = br.readLine();
				if(tmpStr!=null)
					lStr+= tmpStr+"\t";
			}while(tmpStr!=null);
			
			StringTokenizer st = new StringTokenizer(lStr, "\t");
			length = st.countTokens()/5;
			for(int i = 0; i<length; i++) {
				hakbun[i] = Integer.valueOf(st.nextToken()).intValue();
				name[i] = st.nextToken();
				kor[i] = Integer.valueOf(st.nextToken()).intValue();
				eng[i] = Integer.valueOf(st.nextToken()).intValue();
				math[i] = Integer.valueOf(st.nextToken()).intValue();
				sum[i] = kor[i]+eng[i]+math[i];
				avg[i] = sum[i]/3;
				hakjum[i] = setHakjum(avg[i]);
			}
			// 등수 구하기
			for(int i =0; i<length; i++) {
				int cnt = 1;
				for(int j = 0; j<length; j++) {
					if(avg[j]>avg[i]) cnt++;
				}
				rank[i] = cnt;
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("파일 이름이 잘못되었습니다.");
		}
	}
}
