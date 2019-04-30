package com.party.plan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunApplication implements MakePurches {
	static List<Member> mamberList = new ArrayList();
	static List itemslist = new ArrayList();
	static int totalAmountReceived=0;
	static int totalDiscount = 0;

	public static void main(String[] args)

	{
		RunApplication ra = new RunApplication();

		int value;
		Scanner in = new Scanner(System.in);
		for (;;) {
			start();
			value = in.nextInt();
			switch (value) {
			case 1:
				createMember();
				break;
			case 2:
				ra.makePurchease();
				break;
			case 3:
				transactionSummary();
				break;
			case 4:
				exit();
				break;

			default:
				System.out.println("Enter another one");
			}
		}

	}

	public static void start() {
		System.out.println("::::::: Select Your Choice ::::::::");
		System.out.println("          1 : Create Member");
		System.out.println("          2 : Make Purchease");
		System.out.println("          3 : Transaction Summary");
		System.out.println("          4 : Exit");

	}

	public static void startCreateMember() {
		System.out.println("--->   Select Type Membership     ");
		System.out.println("          1 : MemberMember 		5% 		Discount");
		System.out.println("          2 : BranzeMember 		10% 	Discount");
		System.out.println("          3 : SilverMember 		15% 	Discount");
		System.out.println("          4 : GoldenMember 		20% 	Discount");
		System.out.println("          5 : PlatinumMember 	25% 	Discount");
	}

	public static void createMember() {
		System.out.println("(1)   Start>>>>>>>>>");
		System.out.println("-----Create Member-----");
		System.out.println("___________________________");
		startCreateMember();
		Scanner in = new Scanner(System.in);
		int value = in.nextInt();
		switch (value) {
		case 1:
			Scanner in1 = new Scanner(System.in);
			System.out.println("Enter Name :");
			MemberMember mm = new MemberMember(in1.nextLine(), 5);
			mamberList.add(mm);
			break;
		case 2:
			Scanner in2 = new Scanner(System.in);
			System.out.println("Enter Name :");
			BranzeMember bm = new BranzeMember(in2.nextLine(), 10);
			mamberList.add(bm);
			break;
		case 3:
			Scanner in3 = new Scanner(System.in);
			System.out.println("Enter Name :");
			SilverMember sm = new SilverMember(in3.nextLine(), 15);
			mamberList.add(sm);
			break;
		case 4:
			Scanner in4 = new Scanner(System.in);
			System.out.println("Enter Name :");
			GoldenMember gm = new GoldenMember(in4.nextLine(), 20);
			mamberList.add(gm);
			;
			break;
		case 5:
			Scanner in5 = new Scanner(System.in);
			System.out.println("Enter Name :");
			PlatinumMember pm = new PlatinumMember(in5.nextLine(), 25);
			mamberList.add(pm);
			;
			break;

		default:
			System.out.println("Enter another one");
		}

	}

	void makePurchease() {
		System.out.println("(2)   Start>>>>>>>>>");
		System.out.println("-----Make Purchease-----");
		System.out.println("___________________________");
		purches();
		System.out.println("---------------------------");

	}

	public static void transactionSummary() {
		System.out.println("(3)   Start>>>>>>>>>");
		System.out.println("-----Transaction Summary-----");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("===============================================");
		System.out.println("Total Amount Received : "+totalAmountReceived);
		System.out.println("Total Discount Given : "+totalDiscount);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("===============================================");
	}

	public static void exit() {
		System.out.println("********  Exit  ***********");
		System.exit(0);
	}

	public void purches() {
		// TODO Auto-generated method stub

		if (mamberList.size() > 0) {
			System.out.println("-------- Select Member and Purcheses items :::     ");
			System.out.println("====================================================");
			System.out.println("");
			System.out.println("Enter name of member:: ");
			Scanner in = new Scanner(System.in);
			for (int i = 0; i < mamberList.size(); i++) {
				// itemslist

				Member mem = mamberList.get(i);

				String name = mem.getName();
				int discount = mem.getDiscount();

				if (name.matches(in.nextLine())) {
					System.out.println("Name : " + name);
					System.out.println("Discount : " + discount + "%");
					System.out.println("Enter item value : ");
					Scanner inn = new Scanner(System.in);
					int cp = inn.nextInt();
					int afterDiscount = (int) (cp - (cp * 0.05));
					itemslist.add(afterDiscount);
					System.out.println("===============");
					System.out.println("Name: " + name + "  Discount: " + discount + "% Actual Price: " + cp
							+ " After Discount: " + afterDiscount);
					totalAmountReceived=totalAmountReceived+afterDiscount;
					totalDiscount = totalDiscount + (cp - afterDiscount);
					System.out.println("===============");
					break;
				} else {
					System.out.println("Name donot match please choose member again. ");
					continue;
				}

			}

		} else {
			System.out.println("Please Create Member........");
		}

	}

}
