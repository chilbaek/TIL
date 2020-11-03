import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
 
public class Lotto {
    static int USERNUM = 10;
    static int RANGE = 15;
    static int PRICE = 500000000;
 
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        Scanner sc = new Scanner(System.in);
 
        /*
         * players: ����ڵ��� �Է°��� �����. 0���� ����� 1~99���� Ÿ ����� 
         * winNum: ��÷��ȣ 
         * playerWin: �ĺ���ȣ ��
         * winHistory: 1�� ��� 2�� ���
         */
        int[][] players = new int[USERNUM][6];
        int[] winNum = new int[6];
        int[] playerWin = new int[USERNUM];
        int[] winHistory = new int[4];
 
        /* ����� �Է� */
        System.out.println("Welcome to Lotto");
        System.out.println("Enter 6 Number(1~45): ");
        for (int i = 0; i < players[0].length; i++) {
            players[0][i] = sc.nextInt();
            
            //////
            for(int j=0 ; j<i ; j++) {
            	if(players[0][j] == players[0][i]) {
            		System.out.println("RETRY");
            		i--;
            		break;
            	}
            }
        }
        System.out.println("\nYour Number is" + Arrays.toString(players[0]));
        
 
        /* Ÿ����� ������ȣ ���� */
        System.out.println("Other player number generating....\n");
        for (int i = 1; i < players.length; i++) {
            players[i] = lotto.makeNumber();
        }
        System.out.println(Arrays.deepToString(players));
 
        /* ��÷��ȣ ���� */
        winNum = lotto.makeNumber();
        System.out.println("Winning number is " + Arrays.toString(winNum));
 
        /* �� ����� ��� ���� */
        for (int i = 0; i < playerWin.length; i++) {
            playerWin[i] = lotto.winningCheck(winNum, players[i]);
        }
        System.out.println(Arrays.toString(playerWin));
 
        /* ��� ������� */
        for (int i = 0; i < playerWin.length; i++) {
            if (playerWin[i] != 0)
                winHistory[playerWin[i] - 1]++;
        }
        System.out.println(Arrays.toString(winHistory));
        
        lotto.moneyCal(playerWin, winHistory);
    }
 
    
    
    
    
    
    /* 6�ڸ� ���� ���� ���� */
    public int[] makeNumber() {
        Random r = new Random();
        int[] answer = new int[6];
 
        for (int i = 0; i < answer.length; i++) {
            answer[i] = r.nextInt(RANGE) + 1;
            for (int j = 0; j < i; j++) {
                if (answer[i] == answer[j]) {
                    i--;
                    break;
                }
            }
        }
        return answer;
    }
 
    /*
     * ��÷��� ����
     int[] winNum: ��÷��ȣ int[] myNum: ����� ��ȣ    
     */
    public int winningCheck(int[] winNum, int[] myNum) {
        int count = 0;
 
        for (int i = 0; i < myNum.length; i++) {
            for (int j = 0; j < winNum.length; j++) {
                if (myNum[i] == winNum[j])
                    count++;
            }
        }
 
        if (count == 6)
            return 1;
        else if (count == 5)
            return 2;
        else if (count == 4)
            return 3;
        else if (count == 3)
            return 4;
        else
            return 0;
    }
 
    public void moneyCal(int[] playerWin, int[] winHistory) {
        long totalPrize = 5000000000L; // �� ���
        int fourthPrize = 5000; // 4�� ���
        int thirdPrize = 50000; // 3�� ���
 
        // 2���� = (�ѻ�� - (4����*4�� ��÷�� �� ) - (3����*3�� ��÷�� ��))�� 25%
        // 1���� = (�ѻ�� - (4����*4�� ��÷�� �� ) - (3����*3�� ��÷�� ��))�� 75%
        long secondPrize = (long) 0.25 * (totalPrize - (fourthPrize * winHistory[3]) - (thirdPrize * winHistory[2]));
        long firstPrize = (long) (totalPrize - secondPrize);
 
        System.out.println("�̹�ȸ�� �� ����� " + totalPrize + "�� �Դϴ�.");
 
        for (int i = 0; i < playerWin.length; i++) {
            if (playerWin[i] == 4)
                System.out.println((i+1)+"��° �����մϴ�. 4���Դϴ�. ��÷�ݾ��� " + fourthPrize);
 
            else if (playerWin[i] == 3)
                System.out.println((i+1)+"��° �����մϴ�. 3���Դϴ�. ��÷�ݾ��� " + thirdPrize);
 
            else if (playerWin[i] == 2)
                System.out.println((i+1)+"��° �����մϴ�. 2���Դϴ�. ��÷�ݾ��� " + (long) secondPrize / winHistory[1]);
 
            else if (playerWin[i] == 1)
                System.out.println((i+1)+"��° �����մϴ�. 1���Դϴ�. ��÷�ݾ��� " + (long) firstPrize / winHistory[0]);
        }
 
    }
}