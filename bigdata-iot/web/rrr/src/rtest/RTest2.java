package rtest;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest2 {

	public static void main(String[] args) throws REXPMismatchException {
		RConnection rconn = null;
		int arg = 20;
		try {
			rconn = new RConnection("127.0.0.1",6311);
			rconn.setStringEncoding("utf8");
			rconn.eval("source('/Users/jh/OneDrive - inu.ac.kr/study/Rproj/Rstudy/R/f1.R', encoding='UTF-8')");
			REXP rexp = rconn.eval("func1("+arg+")");
			RList rlist = rexp.asList(); // 데이터 프레임 리턴위해 Rlist 사용  
			String s1 [] = rlist.at("x").asStrings();
			int i1 [] = rlist.at("y").asIntegers();
			for(int i=0; i<s1.length; i++) {
				System.out.println(s1[i] +" "+i1[i]);
			}
			
		} catch (RserveException e) {
			e.printStackTrace();
		}
		System.out.println("Complete!");
		rconn.close();
	}

}
