package hw10;

import java.util.Arrays;

import java.util.Scanner;

public class hw10App1 {

	static void menu() {

		System.out.println("Натисніть 1, щоб перевірити, чи є введене слово паліндромом, складеним з 5 букв");
		System.out.println("Натисніть 2, щоб замінити всі голосні букви в строці на тире");
		System.out.println("Натисніть 3, щоб порахувати кількість слів у реченні");
		System.out.println("Натисніть 4, щоб знайти слово, яке найчастіше зустрічається в реченні");

	}

	public static void main(String[] args) throws IncorrectInputExeption {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			menu();
			switch (scanner.next()) {

			// перевірити, чи є введене слово паліндромом, складеним з 5 букв
			case "1": {
				System.out.println("Введіть слово-паліндром, що складається з 5 букв");
				Scanner scanner1 = new Scanner(System.in);
				String sb1 = scanner1.nextLine();

				if (sb1.length() == 5) {
					if (sb1.charAt(0) == sb1.charAt(4) && sb1.charAt(1) == sb1.charAt(3)) {
						System.out.println("Cлово-паліндром <<" + sb1 + ">> складається з 5 букв");
					} else {
						System.out.println("Введене слово <<" + sb1 + ">> не паліндром");
					}
				} else {
					System.out.println("Введене слово <<" + sb1 + ">> містить кількість букв, відмінну від 5");
					throw new IncorrectInputExeption();
				}
				break;
			}

			// замінити всі голосні букви в строці на тире (строка довільна)
			case "2": {
				System.out.println("Введіть будь-яке речення aнглійською)");
				Scanner scanner2 = new Scanner(System.in);
				String s2 = scanner2.nextLine();
				char[] Array1 = s2.toCharArray();
				// System.out.println(Arrays.toString(Array1));

				for (int i = 0; i < Array1.length; i++) {
					if (s2.charAt(i) == 'a' | s2.charAt(i) == 'e' | s2.charAt(i) == 'o' | s2.charAt(i) == 'i'
							| s2.charAt(i) == 'u' | s2.charAt(i) == 'y' | s2.charAt(i) == 'A' | s2.charAt(i) == 'E'
							| s2.charAt(i) == 'O' | s2.charAt(i) == 'I' | s2.charAt(i) == 'U' | s2.charAt(i) == 'Y') {

						Array1[i] = '-';
					}
				}
				System.out.println(String.copyValueOf(Array1));
				break;
			}

			// порахувати кількість слів у реченні (речення довільне)
			case "3": {
				System.out.println("Введіть будь-яке речення");
				Scanner scanner3 = new Scanner(System.in);
				String s3 = scanner3.nextLine().toUpperCase();

				int a;
				int count = 0;

				char[] Array2 = s3.toCharArray();

				// прибираємо імовірні символи "-" та розділові знаки в кінці речення
				for (int i = 0; i < Array2.length; i++) {
					if (s3.charAt(i) == '-' | s3.charAt(i) == '.' | s3.charAt(i) == '!' | s3.charAt(i) == '?') {
						Array2[i] = ' ';
					}
				}

				// отримуємо "чистий" масив
				String s31 = new String(String.copyValueOf(Array2));
				s31 = s31.trim();
				System.out.println(s31);
				char[] Array3 = s31.toCharArray();

				for (int i = 0; i < Array3.length; i++) {

					// відслідковуємо пробіли, оскільки набір символів до пробілу приймаємо, як
					// слово
					if (s31.indexOf(" ") > 0) {
						a = s31.indexOf(" ");
						count = count + 1;

						// прибираємо ймовірні розділові знаки, які, як правило, пишуться після слова
						// без пробілу
						if (s31.substring(0, a).contains(",") | s31.substring(0, a).contains(";")
								| s31.substring(0, a).contains(":")) {
							System.out.println(count + " слово: " + s31.substring(0, a - 1));
						} else {
							System.out.println(count + " слово: " + s31.substring(0, a));
						}

						// попередня заміна в масиві "-" на пробіл залишає 3 пробіли поспіль, що слід
						// враховувати при "усіченні" масиву
						if (s31.charAt(s31.indexOf(" ")) == s31.charAt(s31.indexOf(" ") + 1)
								&& s31.charAt(s31.indexOf(" ")) == s31.charAt(s31.indexOf(" ") + 2)) {
							count = count;
							s31 = s31.substring(s31.indexOf(" ") + 3);
						} else {
							s31 = s31.substring(a + 1);
						}
					}
				}

				if (s31.indexOf(" ") < 0) {
					System.out.println("Останнє/єдине cлово: " + s31.substring(0, s31.length()));
					// }
					count = count + 1;
					System.out.println("Речення складається з " + count + " слiв/слова");
				}

				break;
			}

			// знайти слово, яке найчастіше зустрічається в реченні 
			//ми їдемо, їдемо, їдемо в далекі краї, далекі краї - дуже, дуже далекі краї (зовсім не працює на такому реченні!!!)
			case "4": {
				System.out.println("Введіть будь-яке речення");
				Scanner scanner3 = new Scanner(System.in);
				String s3 = scanner3.nextLine().toUpperCase();

				int a;
				int count1 = 0;
				int count2 = 1;

				char[] Array2 = s3.toCharArray();

				// прибираємо імовірні символи тире "-" та розділові знаки в кінці речення
				for (int i = 0; i < Array2.length; i++) {
					if (s3.charAt(i) == '-' | s3.charAt(i) == '.' | s3.charAt(i) == '!' | s3.charAt(i) == '?') {
						Array2[i] = ' ';
					}
				}

				// отримуємо "чистий" масив
				String s31 = new String(String.copyValueOf(Array2));
				s31 = s31.trim();
				System.out.println(s31);
				char[] Array3 = s31.toCharArray();
				String s31Word = new String();

				for (int i = 0; i < Array2.length; i++) {

					if (s31.indexOf(" ") > 0) {// якщо так, то шукаємо індекс неспівпадіння пробілу
						a = s31.indexOf(" ");
						count1 = count1 + 1;

						if (s31.substring(0, a).contains(",") | s31.substring(0, a).contains(";")
								| s31.substring(0, a).contains(":")) {
							s31Word = s31.substring(0, a - 1);
						} else {
							s31Word = s31.substring(0, a);
						}

						// попередня заміна в масиві тире "-" на пробіл " " залишає 3 пробіли поспіль,
						// що слід враховувати при "усіченні" масиву
						if (s31.charAt(s31.indexOf(" ")) == s31.charAt(s31.indexOf(" ") + 1)
								&& s31.charAt(s31.indexOf(" ")) == s31.charAt(s31.indexOf(" ") + 2)) {
							count1 = count1;
							s31 = s31.substring(s31.indexOf(" ") + 3);
						} else {
							s31 = s31.substring(a + 1);
						}

						if (s31.contains(s31Word) == true) {
							count2 = count2 + 1;
							System.out.println("Знайдено " + count2 + "  слова(ів) " + s31Word);
						} else {
							count2 = 1;
						}

					}

				}
				if (s31.indexOf(" ") < 0) {

					s31Word = s31.substring(0, s31.length());

					if (s31.contains(s31Word) == true) {
						count2 = count2 +1 ;
					} else {
						count2 = 1;
					}
					count1 = count1 + 1;

				}

			}

			}

		}
	}
}
