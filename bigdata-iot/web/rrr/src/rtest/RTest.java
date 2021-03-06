package rtest;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest {

	public static void main(String[] args) throws REXPMismatchException {
		RConnection rconn = null;
		try {
			rconn = new RConnection("127.0.0.1",6311);
			rconn.setStringEncoding("utf8");
			rconn.eval("source('/Users/jh/OneDrive - inu.ac.kr/study/Rproj/Rstudy/R/f1.R', encoding='UTF-8')");
			REXP rexp = rconn.eval("func1("+args+")");
			int result [] = rexp.asIntegers();
			
			for(int i : result) {
				System.out.println(i);
			}
		} catch (RserveException e) {
			e.printStackTrace();
		}
		System.out.println("Complete!");
	}

}
