
import java.util.ArrayList;
import java.util.Scanner;
//------------------------------------------------------------------------------

import java.util.ArrayList;

import java.util.Scanner;



class main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);



		int acNum = 1;

		double money;

		int acc = 0;

		int accType;

		String Cacc;

		String Cacc2;

		double numsDoub;

		int numsint;

		int withs;



		double higher = 10;



		double doll;

		double timeP;



		// --saving--

		double lowmoney;

		double intreovertime = 0;

		// ------



		// --checking--

		int wi = 0;

		// -----



		boolean q = false;



		ArrayList<BAccount> index = new ArrayList<BAccount>();

		index.add(new Checking(100, 2, 1, wi));// 0

		index.add(new Savings(10, 2, 0, higher, 7));// 1

		higher = index.get(1).getBal();



		System.out.println("Create New Account? (y) or (n): ");

		Cacc = s.nextLine();



		if (Cacc.equals("n")) {

			System.out.println("Please Press 'Enter' Once More");

			Cacc = s.nextLine();

			q = true;



		} else if (Cacc.equals("y")) {

			System.out.println("Checking or Savings? (c) or (s) ");

			Cacc2 = s.nextLine();



			if (Cacc2.equals("c")) { // CHECKING / 0

				System.out.println("Enter Money in Account: ");

				numsDoub = s.nextDouble();

				doll = numsDoub;



				System.out.println("Enter Time Open: ");

				numsDoub = s.nextDouble();

				timeP = numsDoub;



				System.out.println("Enter Amount of Withdrawls: ");

				numsint = s.nextInt();

				wi = numsint;



				acNum++;

				System.out.println("Your Account Number is: " + acNum++);



				index.add(new Checking(doll, timeP, 1, wi));

				System.out.println(" ");

				q = true;



			} else if (Cacc2.equals("s")) { // SAVING / 1

				System.out.println("Enter Money in Account: ");

				numsDoub = s.nextDouble();

				doll = numsDoub;



				System.out.println("Enter Time Open: ");

				numsDoub = s.nextDouble();

				timeP = numsDoub;



				System.out.println("Enter lowest Bal: ");

				numsint = s.nextInt();

				lowmoney = numsint;



				acNum++;

				System.out.println("Your Account Number is " + acNum++);



				index.add(new Savings(doll, timeP, 0, lowmoney, intreovertime));

				higher = lowmoney;

				System.out.println(" ");

				q = true;

			}

		}



		String input;

		System.out.println("Enter account number: ");

		acc = s.nextInt();



		if (index.size() < acc) {

			System.out.println("INVALID NUMBER, PLEASE RESTART");

			q = false;

		}



		while (q == true) { // ATM mode

			accType = index.get(acc).getAccType();



			System.out.println(

					"Enter (d) if you want to make a deposit, (w) for Withdrawal, (m) to reset the month or (q) to quit");

			input = s.next();



			if (input.equals("d")) { // DEPOSITE

				System.out.println("Enter The Money: ");

				money = s.nextInt();

				index.get(acc).setBal(index.get(acc).getBal() + money);

				System.out.println("Your New Balance Is: $" + index.get(acc).getBal());



			} else if (input.equals("w")) { // WITHDRAWL



				if (accType == 1) { // CHECKING

					System.out.println("Enter withdraw amount: ");

					money = s.nextInt();

					index.get(acc).setBal(index.get(acc).getBal() - money);



					((Checking) index.get(acc)).setWit(wi++);

					if (wi > 3) {

						index.get(acc).setBal(index.get(acc).getBal() - 1);

					}

					withs = 3 - wi;

					System.out.println("Your New Balance Is: $" + index.get(acc).getBal());

					System.out.println(withs + " Withdrawls Before A Fee");



				} else if (accType != 1) { // SAVINGS

					System.out.println("Enter withdraw amount: ");

					money = s.nextInt();

					index.get(acc).setBal(index.get(acc).getBal() - money);

					System.out.println("Your New Balance Is: $" + index.get(acc).getBal());

				}



			} else if (input.equals("m")) { // MONTH END

				System.out.println(accType);

				if (accType != 1) {

					if (higher > index.get(acc).getBal()) {

						higher = index.get(acc).getBal();

					}

					System.out.println("The Money Deposited In Your Account is: $" + higher * .5);

					index.get(acc).setBal(index.get(acc).getBal() + higher * .5);

					System.out.println("New Balance is: $" + index.get(acc).getBal());

				} else if (accType == 1) { // CHECKING

					wi = 0;

					System.out.println("Your Withdrawls Have Been Reset");

				}



			} else if (input.equals("q")) { // QUIT/END

				System.out.println("Thank You For Using This ATM");

				q = false;

			}



		}



	}

}