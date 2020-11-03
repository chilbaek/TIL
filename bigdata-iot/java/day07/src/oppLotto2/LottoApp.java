package oppLotto2;
 
import java.util.*;
 
public class LottoApp {
 
    public static void main(String[] args) {
        
        Lotto lotto = new Lotto();
        
        lotto.setAnswer(lotto.makeRandomnumber());
//        int[] testcase = {1,2,3,4,5,6};
//        lotto.setAnswer(testcase);
        
        Scanner sc = new Scanner(System.in);
        
        int[] playerNum = new int [6];
        
        for (int number = 0; number < lotto.player[0].length; number++) {
            System.out.printf("%d ��° ���ڸ� �Է��ϼ���.\n",number+1);
            playerNum[number] = sc.nextInt();
        }
        
        sc.close();
        
        lotto.player[0] = playerNum;
        lotto.winningCheck(lotto.player[0]);
        
        for (int person = 1; person < 100; person++) {
            lotto.player[person] = lotto.makeRandomnumber();
        }
        
        lotto.setWinner();
        
        lotto.moneyCal();
        
        for (int person = 0; person < 100; person++) {
            if (lotto.playerWinInfo[person] >= 1) {
                System.out.printf("%d��° ����ڴ�  %d�� ��÷�Ǽ̽��ϴ�. ��÷���� %d�� �Դϴ�.\n" ,person+1 ,lotto.playerWinInfo[person], lotto.winnerPrice[lotto.playerWinInfo[person]]);
            }
        }
    }
 
}
 
