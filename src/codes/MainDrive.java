package codes;

import java.util.Scanner;

//깃허브에는20210710_LottoJAVA로 저장되어있음

public class MainDrive {
	
	public static void main(String[] args) {
		
//		컴퓨터가 6개의 랜덤 숫자를 뽑아서 이번주 당첨번호를 추첨하자
		int[] winLottoNumbers = new int[6];
		
//		6개의 숫자를 넣기 위한 for문
		for(int i = 0; i < winLottoNumbers.length; i++) {
			
//			중복검사를 통과하는 숫자를 뽑을 때까지 무한반복해야함
			while(true) {
				
//				앞의 로또번호 입력과 비슷함
//				1. 사용자가 숫자 입력 -> 컴퓨터가 랜덤으로 입력
//				2. 범위 검사 -> 여기서는 필요없음. 컴퓨터가 랜덤으로 번호를 뽑을 때 범위를 1~45로 하면 됨
//				3. 중복 검사
//				4. 통과하면 대입
				
				boolean isDupOk = true;
				
//				int randomNum = (int)(Math.random()*46-1);
				int randomNum = (int)(Math.random()*45+1);
				
//				범위는 이미 충족이니까 중복검사만 해보자
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
		
//		당첨번호를 작은숫자에서 큰 숫자 순서대로 정리해서 출력해보자
		
//		정리(정렬) 코드
//		숫자 2개씩 비교해서 자리 바꾸기를 반복 => 작은 반복 (분침)
//		6번 반복 => 큰 반복 (시침)
		for(int i = 0; i < winLottoNumbers.length; i++) {
			
			for(int j = 0; j < winLottoNumbers.length-1 ; j++) {
		
				if(winLottoNumbers[j] == winLottoNumbers[j+1]) {
					
					int backUp = winLottoNumbers[j+1];
					winLottoNumbers[j+1] = winLottoNumbers[j];
					winLottoNumbers[j] = backUp;
					
				}
				
			}
			
		}
		
		
		
		
//		출력은 OK
		for(int num : winLottoNumbers) {
			System.out.println(num);
		}
		
//		보너스번호도 뽑아보자 => 1~45 당첨번호와 겹치면 안됨
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
		
//		숫자 6개를 입력받기 위한 for문
		for(int i = 0 ; i < myLottoNumbers.length; i++) {
			
//			숫자를 입력받아서 조건 검사를 모두 통과하면 집어넣자
//			집어넣었다 : 다음 숫자 입력받으러 이동 (for문 다음바퀴로 이동)
//			통과못했다 : 다시 입력받자 검사 통과할때까지 계속 입력받자
			
			while(true) {
				
//				숫자 입력 : Scanner 필요 => 여기서 만들면 계속 스캐너를 새로 장만하는 형태
//				for문 보다도 앞에 Scanner를 만들어두고, 여기서는 활용만 하자
				
//				안내문구를 띄울껀데
//				"?번째 숫자를 입력하세요."
//				i번째 숫자라고 입력하면, 0부터 5까지 나오니까 i+1
				System.out.print((i+1)+"번째 숫자를 입력하세요. : ");
				
//				일단 입력받은 숫자를 변수에 담아두고, 
//				변수가 검사를 통과하면 배열에 넣을거야
				int inputNum = myScan.nextInt();
				
//				검사 1 : 숫자 범위 검사 - 1~45 사이인가요?
//				-> 검사 결과는 통과/탈락으로 나뉘니까 boolean변수로 결과를 저장하자
//				boolean isRangeOk = true;가 아님!!! 여기서 바로 조건을 적어주자
				boolean isRangeOk = (1 <= inputNum) && (inputNum <= 45);
				
//				검사 2 : 중복 여부 검사 - 이미 뽑힌 숫자인가요?
//				일단 써도 된다고 해둔 다음에 내 로또번호들을 확인하다가,
//				같은 걸 발견하는 순간 중복이니까 쓰면 안되로 값을 변경하자
				boolean isDuplicateOk = true;
				
//				중복검사 : 내 로또번호 목록에서 하나씩 꺼내서 비교해보자
				for(int num : myLottoNumbers) {
					if(num == inputNum) {
						isDuplicateOk = false;
						break;
					}
				}
				
//				검사 1,2 두개 모두 통과했다면 값에 넣어주고, 다음 숫자를 구하러 가자
				if(isRangeOk && isDuplicateOk) {
					myLottoNumbers[i] = inputNum;
					break;
				}
//				else if(!=(isRangeOk && isDuplicateOk)) {  --> !=는 같지 않다! 아니다는 !
				else if(!isRangeOk) {
					System.out.println("1부터 45까지의 숫자를 입력하세요.");
				}
//				else if(!isDuplicateOk) {  --> 둘다 true / 범위만 false / 중복만 false / 범위,둘다 false
//				                           --> 둘다 true / 범위만 false, 이면 나머지 하나의 경우수는 중복도 false인 경우
				else {
					System.out.println("이미 입력한 숫자입니다.");
				}
			}
		}
		
		

			

//		등수 판단해보자 
//		내 번호와 당첨번호를 비교 -> 같은 숫자가 몇개 있는지 구해서!!
//		숫자 야구 게임과 비교를 해보면, 
//		숫자야구게임은 위치도 판단 요소였다. 로또는 위치는 상관없음!!

//		몇개의 숫자를 맞췄는지 기록할 변수
		int correctNumCount = 0;
		
//		내 번호를 하나씩 꺼내보자
		for(int lottoNum : myLottoNumbers) {
//			당첨번호도 하나씩 꺼내서 내 번호와 같은지 계속 비교하자
			for(int winNum : winLottoNumbers) {
				
				if(lottoNum == winNum) {
					correctNumCount++;
				}
			}
		}
		
//		최종 결과에는 맞춘 개수가 저장되었고, 그 갯수가 몇개냐에 따라 등수를 정하기
		if(correctNumCount == 6) {
			System.out.println("1등입니다.");
		}
		else if(correctNumCount == 5) {
		
//			내 입력값과 보너스 번호가 같은게 있따면 보너스 번호를 맞췄으니 2등!
//			없다면 3등!
			
//			보너스번호를 들고, 내 로또번호를 둘러보자
			
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
