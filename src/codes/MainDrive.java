package codes;

import java.util.Scanner;

//깃허브에는20210710_LottoJAVA로 저장되어있음

public class MainDrive {
	
	public static void main(String[] args) {		

		int[] winLottoNumbers = new int[6];
		
		for(int i = 0; i < winLottoNumbers.length; i++) {
			
			while(true) {
				
				boolean isDupOk = true;
				
				int randomNum = (int)(Math.random()*45+1);
				
				for(int num : winLottoNumbers) {
					if(num == randomNum) {
						isDupOk = false;
						break;
					}
				}
				
				if(isDupOk) {
					winLottoNumbers[i] = randomNum;
					break;
				}			
			}
		}		

		for(int i = 0; i < winLottoNumbers.length; i++) {
			
			for(int j = 0; j < winLottoNumbers.length-1 ; j++) {
		
				if(winLottoNumbers[j] == winLottoNumbers[j+1]) {
					
					int backUp = winLottoNumbers[j+1];
					winLottoNumbers[j+1] = winLottoNumbers[j];
					winLottoNumbers[j] = backUp;					
				}				
			}			
		}		

		for(int num : winLottoNumbers) {
			System.out.println(num);
		}
		
		int bonusNum = 0;
		
		while(true) {
			
			int randomBonusNum = (int)(Math.random()*45+1);
			
			boolean isDuplOk = true;
			
			for(int winNum : winLottoNumbers) {
				if(winNum == randomBonusNum) {
					isDuplOk = false;
					break;
				}
			}
			
			if(isDuplOk) {
				bonusNum = randomBonusNum;
				break;
			}
		}
	
		System.out.println("보너스번호 : " + bonusNum);
				
		int[] myLottoNumbers = new int[6];
		
		Scanner myScan = new Scanner(System.in);
		
		for(int i = 0 ; i < myLottoNumbers.length; i++) {
			
			while(true) {	

				System.out.print((i+1)+"번째 숫자를 입력하세요. : ");
				
				int inputNum = myScan.nextInt();
				
				boolean isRangeOk = (1 <= inputNum) && (inputNum <= 45);

				boolean isDuplicateOk = true;

				for(int num : myLottoNumbers) {
					if(num == inputNum) {
						isDuplicateOk = false;
						break;
					}
				}
				
				if(isRangeOk && isDuplicateOk) {
					myLottoNumbers[i] = inputNum;
					break;
				}
				else if(!isRangeOk) {
					System.out.println("1부터 45까지의 숫자를 입력하세요.");
				}
				else {
					System.out.println("이미 입력한 숫자입니다.");
				}
			}
		}
		
		int correctNumCount = 0;
		

		for(int lottoNum : myLottoNumbers) {

			for(int winNum : winLottoNumbers) {
				
				if(lottoNum == winNum) {
					correctNumCount++;
				}
			}
		}
		
		if(correctNumCount == 6) {
			System.out.println("1등입니다.");
		}
		else if(correctNumCount == 5) {
			
			boolean isBonusCorrect = false;
			
			for(int num : myLottoNumbers) {
				if(num == bonusNum) {
					isBonusCorrect = true;					
				}				
			}
			
			if(isBonusCorrect) {
				System.out.println("2등입니다.");
			}
			else {
				System.out.println("3등 입니다.");
			}		
		}
		else if(correctNumCount == 4) {
			System.out.println("4등 입니다.");
		}
		else if(correctNumCount == 3) {
			System.out.println("5등 입니다.");
		}
		else {
			System.out.println("낙첨입니다.");
		}
	}

}
