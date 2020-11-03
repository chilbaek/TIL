package oppLotto3;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	static int RANGE = 10;
	static int USERNUM = 50;
	
	int[][] players = new int[USERNUM][6];
	int[] winNum = new int[6];
	int[] playerWin = new int[USERNUM];
	int[] winHistory = new int[4];
	
	
	public int[] makeNumber() {
		Random r = new Random(); 
        for (int i = 0; i < this.winNum.length; i++) {
            this.winNum[i] = r.nextInt(RANGE) + 1;
            for (int j = 0; j < i; j++) {
                if (this.winNum[i] == this.winNum[j]) {
                    i--;
                    break;
                }
            }
        }
		return this.winNum;
	}
	
	public int[][] setPlayers() {
		Random r = new Random();
        for (int i = 1 ; i<this.players.length; i++) {
        	for (int j=0 ; j<this.players[i].length ; j++) {
        		this.players[i][j] = r.nextInt(RANGE) + 1;
        		for (int k=0 ; k<j ; k++) {
        			if(this.players[i][k] == this.players[i][j]) {
        				j--;
        				break;
        			}
        		}
        	}
        }
        return this.players;
	}
	
	public int winningCheck(int n) {
		int count=0;
		for(int i=0 ; i<this.players[n].length ; i++) {
			for(int j=0 ; j<this.winNum.length ; j++) {
				if(this.winNum[j] == this.players[n][i])
					//[i][j] �ƴϰ� [n][i]���� �ٽ� üũ�غ���
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
	
	
	public void winInfo() {
		for (int i=0 ; i<this.playerWin.length ; i++) {
			if(this.playerWin[i] != 0) {
				this.winHistory[playerWin[i]-1]++;
			}
		}
	}
	
	public void moneyCal(int[] playerWin, int[] winHistory) {
        long totalPrize = 5000000000L; // �� ���
        int fourthPrize = 5000; // 4�� ���
        int thirdPrize = 50000; // 3�� ���
        
        // 2���� = (�ѻ�� - (4����*4�� ��÷�� �� ) - (3����*3�� ��÷�� ��))�� 25%
        // 1���� = (�ѻ�� - (4����*4�� ��÷�� �� ) - (3����*3�� ��÷�� ��))�� 75%
        System.out.println(Arrays.toString(winHistory));
        
        long secondPrize = (long) 0.25*(totalPrize - (fourthPrize*winHistory[3]) - (thirdPrize*winHistory[2]));
        //int prize34 = fourthPrize*winHistory[3] + thirdPrize*winHistory[2];
        //long secondPrize = (long) 0.25*(totalPrize-prize34);
        
        long firstPrize = (long) (totalPrize - secondPrize);
        
        System.out.println(fourthPrize * winHistory[3]);
        System.out.println(thirdPrize * winHistory[2]);
        System.out.println((fourthPrize * winHistory[3]) + (thirdPrize * winHistory[2]));
        System.out.println((long) totalPrize - (fourthPrize * winHistory[3]) + (thirdPrize * winHistory[2]));
        System.out.println(secondPrize);
        
        System.out.println("�̹�ȸ�� �� ����� " + totalPrize + "�� �Դϴ�.");
 
        for (int i = 0; i < playerWin.length; i++) {
            if (playerWin[i] == 4)
                System.out.println((i+1)+"��° ���� : 4��. ��÷�ݾ� " + fourthPrize);
 
            else if (playerWin[i] == 3)
                System.out.println((i+1)+"��° ���� : 3��. ��÷�ݾ� " + thirdPrize);
 
            else if (playerWin[i] == 2)
                System.out.println((i+1)+"��° ���� : 2��. ��÷�ݾ� " + (long) secondPrize / this.winHistory[1]);
 
            else if (playerWin[i] == 1)
                System.out.println((i+1)+"��° ���� : 1��. ��÷�ݾ�" + (long) firstPrize / this.winHistory[0]);
        }
 
    }

	@Override
	public String toString() {
		return "Lotto [players=" + Arrays.toString(players) + ", winNum=" + Arrays.toString(winNum) + ", playerWin="
				+ Arrays.toString(playerWin) + ", winHistory=" + Arrays.toString(winHistory) + "]";
	}


}
