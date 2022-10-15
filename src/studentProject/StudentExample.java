package studentProject;

import java.util.Scanner;

public class StudentExample {

	public static int count = 0;
	public static final int MAX_COUNT = 20;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Student[] stArray = new Student[MAX_COUNT];
		boolean flag = false;
		while (!flag) {
			int num = 0;

			switch (displayMenu(num)) {
			case 1: // 입력
				studentInput(stArray);
				break;
			case 2: // 수정
				scoreChange(stArray);
				break;
			case 3: // 삭제
				studentDelete(stArray);
				break;
			case 4: // 검색
				studentSearch(stArray);
				break;
			case 5: // 출력
				studentOutput(stArray);
				break;
			case 6: // 정렬
				studentSorting(stArray);
				break;
			case 7: // 통계
				studentStats(stArray);
				break;
			case 8: // 종료
				System.out.println("종료합니다");
				flag = true;
				break;
			default:
				System.out.println("다시입력하세요");
				break;
				
			} 
		}
	}
	
	/** 학생 정보를 정렬하기 위해서 사용합니다. */
	public static void studentSorting(Student[] stArray) {
		if (count == 0) {
			System.out.println("입력 정보가 없습니다.");
			return;
		}
		// count = 입력횟수니까 0이면 정보가 없다는 뜻

		Student tmp = null;
		String no = null;

		System.out.println("1.오름차순 || 2.내림차순");
		no = sc.nextLine();

		if (no.equals("1")) {
			for (int i = 0; i < count; i++) {
				for (int j = i + 1; j < count; j++) {
					if (stArray[i].getTotal() < stArray[j].getTotal()) {
						tmp = stArray[i];
						stArray[i] = stArray[j];
						stArray[j] = tmp;
					}
				}
				stArray[i].setRank(i + 1);
			}
		} else if (no.equals("2")) {
			for (int i = 0; i < count; i++) {
				for (int j = i + 1; j < count; j++) {
					if (stArray[i].getTotal() > stArray[j].getTotal()) {
						tmp = stArray[i];
						stArray[i] = stArray[j];
						stArray[j] = tmp;
					}
				}
				stArray[i].setRank(count - i);
			}
		} else {
			System.out.println("잘못입력하였습니다. 다시 입력하세요");
			studentSorting(stArray);
			return;
		}

		System.out.println("정렬이 완료되었습니다.");
		return;
	}

	/** 학생 정보를 통계하기 위해서 사용합니다. ex) 최고,최저,평균점수 */
	public static void studentStats(Student[] stArray) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int total = 0;
		double avg = 0.0;
		int index = -1;
		int num = 0;

		if (count == 0) {
			System.out.println("입력 정보가 없습니다.");
			return;
		}

		try {
			System.out.println("1.최고점수 || 2.최저점수 || 3.평균점수");
			num = sc.nextInt();
		} catch (Exception e) {
			System.out.println("잘못된 값을 입력했습니다.");
			return;
		} finally {
			sc.nextLine();
		}

		if (num == 1) {
			for (int i = 0; i < count; i++) {
				if (stArray[i].getTotal() > max) {
					max = stArray[i].getTotal();
					index = i;
				}
			}
			System.out.println("최고점수 : ");
			System.out.println(stArray[index].toString());
		} else if (num == 2) {
			for (int i = 0; i < count; i++) {
				if (stArray[i].getTotal() < min) {
					min = stArray[i].getTotal();
					index = i;
				}
			}
			System.out.println("최저점수 : ");
			System.out.println(stArray[index].toString());
		} else if (num == 3) {
			for (int i = 0; i < count; i++) {
				total += stArray[i].getTotal();
			}
			avg = (double) total / (double) count;
			System.out.println("모든 학생의 총점 평균은 " + String.format("%.2f", avg));

		} else {
			System.out.println("잘못입력하였습니다. 다시입력하세요");
			studentStats(stArray);
		}

	}

	/** 학생 정보를 검색하기 위해서 사용합니다. */
	public static void studentSearch(Student[] stArray) {
		if (count == 0) {
			System.out.println("입력 정보가 없습니다.");
			return;
		}

		int index = -1;
		String no = null;
		int total = 0;
		double avg = 0.0;

		System.out.println("검색할 학생의 학번을 입력하세요");
		no = sc.nextLine();

		for (int i = 0; i < count; i++) {
			if (stArray[i].getNo().equals(no)) {
				index = i;
				System.out.println(stArray[i].toString());
				for (int j = 0; j < count; j++) {
					total += stArray[j].getTotal();
				}
				avg = (double) total / (double) count;
				System.out.print("모든 학생의 총점 평균은 " + String.format("%.2f", avg) + "점이며, ");
				if (stArray[i].getTotal() > avg) {
					System.out.println(stArray[i].getName() + "님의 점수는 평균보다 " + String.format("%.2f" , stArray[i].getTotal() - avg) + "점 높습니다.");
				} else if (stArray[i].getTotal() < avg) {
					System.out.println(stArray[i].getName() + "님의 점수는 평균보다 " + String.format("%.2f" , avg -stArray[i].getTotal()) + "점 낮습니다.");
				}
			}
		}

		if (index == -1) {
			System.out.println("해당 학번의 학생이 없습니다.");
			return;
		}

	}

	/** 학생 정보를 수정하기 위해서 사용합니다. */
	public static void scoreChange(Student[] stArray) {
		if (count == 0) {
			System.out.println("입력 정보가 없습니다.");
			return;
		}

		int index = -1;
		String num = null;

		System.out.println("수정할 학생의 학번을 입력하세요");
		num = sc.nextLine();

		for (int i = 0; i < count; i++) {
			if (stArray[i].getNo().equals(num)) {
				index = i;

				String name = stArray[i].getName();
				String no = stArray[i].getNo();
				boolean gender = stArray[i].isGender();
				int kor, eng, math;
				
				try {
					System.out.println("국어점수 입력 :");
					kor = sc.nextInt();
					if (kor <= 0 || kor > 100) {
						System.out.println("국어 점수를 잘못 입력하였습니다.");
						break;
					}
					System.out.println("영어점수 입력 :");
					eng = sc.nextInt();
					if (eng <= 0 || eng > 100) {
						System.out.println("영어 점수를 잘못 입력하였습니다.");
						break;
					}
					System.out.println("수학점수 입력 :");
					math = sc.nextInt();
					if (math <= 0 || math > 100) {
						System.out.println("수학 점수를 잘못 입력하였습니다.");
						break;
					}

				} catch (java.util.InputMismatchException e) {
					System.out.println("잘못된 값을 입력하였습니다.");
					break;
				} finally {
					sc.nextLine();
				}

				stArray[i] = new Student(name, no, gender, kor, eng, math);

				stArray[i].calTotal();
				stArray[i].calAvg();
				stArray[i].calGrade();

			}
		}

		if (index == -1) {
			System.out.println("해당 학번의 학생이 없습니다.");
			return;
		}

	}

	/** 학생 정보를 삭제하기 위해서 사용합니다. */
	public static void studentDelete(Student[] stArray) {
		if (count == 0) {
			System.out.println("입력 정보가 없습니다.");
			return;
		}

		int index = -1;
		String no = null;

		try {
			System.out.println("삭제할 학생의 학번을 입력하세요");
			no = sc.nextLine();
		} catch (Exception e) {
			System.out.println("잘못된 값을 입력하였습니다.");
			return;
		}

		for (int i = 0; i < count; i++) {
			if (stArray[i].getNo().equals(no)) {
				System.out.println(stArray[i].getName() + "의 정보를 삭제합니다.");
				index = i;
			}
		}

		if (index == -1) {
			System.out.println("해당 학번의 학생이 없습니다.");
			return;
		}

		for (int i = index; i < count - 1; i++) {
			if (i == count - 1) {
				stArray[i] = null;
			}
			stArray[i] = stArray[i + 1];
		}

		count--;
	}

	/** 학생 정보를 출력하기 위해서 사용합니다. */
	public static void studentOutput(Student[] stArray) {
		if (count == 0) {
			System.out.println("입력 정보가 없습니다.");
			return;
		}
		for (int i = 0; i < count; i++) {
			if (stArray[i] == null) {
				return;
			}
		}
		
		for (int i = 0; i < count; i++) {
			System.out.println(stArray[i].toString());
			System.out.println("-".repeat(80));
		}
		
		
	}

	/** 학생 정보를 입력하기 위해서 사용합니다. */
	public static void studentInput(Student[] stArray) {
		if (count == MAX_COUNT) {
			System.out.println("최대 입력수에 도달했습니다.");
			return;
		}


		String name = RandomValue.randomName2();

		String no = null;
		boolean flag = false;

		while (!flag) {
			int level = (int) (Math.random() * (3 - 1 + 1) + (1));
			int classNo = (int) (Math.random() * (9 - 1 + 1) + (1));
			int studentNo = (int) (Math.random() * (30 - 1 + 1) + (1));
			no = String.format("%02d%02d%02d", level, classNo, studentNo);

			flag = true;

			// 첫 입력시
			if (count == 0) {
				continue;
			}

			for (int i = 0; i < count; i++) {
				if (stArray[i].getNo().equals(no)) {
					flag = false;
					break;
				}
			}
		}

		boolean gender = (int) (Math.random() * (1 - 0 + 1) + (0)) == 1 ? true : false;
		int kor = (int) (Math.random() * (100 - 0 + 1) + (0));
		int eng = (int) (Math.random() * (100 - 0 + 1) + (0));
		int math = (int) (Math.random() * (100 - 0 + 1) + (0));

		stArray[count] = new Student(name, no, gender, kor, eng, math);

		
		stArray[count].calTotal();
		stArray[count].calAvg();
		stArray[count].calGrade();

		// 학생 선생님 정보를 입력(선생님 폰번호 , 이름 , 나이 , 전공)
		int phoneNo1 = (int) (Math.random() * (9999 - 0 + 1) + (0));
		int phoneNo2 = (int) (Math.random() * (9999 - 0 + 1) + (0));
		String phone = String.format("010-%04d-%04d", phoneNo1, phoneNo2);

		String teacherName = RandomValue.randomName2();

		int age = (int) (Math.random() * (80 - 20 + 1) + (20));

		String[] majorArray = new String[] { "국어전공", "수학전공", "영어전공", "진짜대단한컴퓨터전공" };
		String major = majorArray[(int) (Math.random() * (3 - 0 + 1) + (0))];

		stArray[count].setPhone(phone);
		stArray[count].setTeacherName(teacherName);
		stArray[count].setAge(age);
		stArray[count].setMajor(major);

		System.out.println(stArray[count].getName() + "님의 정보가 입력되었습니다.");
		count++;

	}

	/** 메뉴선택을 위해서 사용합니다. */
	public static int displayMenu(int num) {
		System.out.println("=".repeat(80));
		try {
			System.out.print("1.입력 || 2.수정 || 3.삭제 || 4.검색 || 5.출력 || 6.정렬 || 7.통계 || 8.종료 \n입력 >> ");
			num = sc.nextInt();
		} catch (java.util.InputMismatchException e) {
		}
		sc.nextLine();
		System.out.println("=".repeat(80));

		return num;
	}

}
