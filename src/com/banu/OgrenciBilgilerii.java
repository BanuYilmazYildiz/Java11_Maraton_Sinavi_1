package com.banu;

import java.util.Scanner;

public class OgrenciBilgilerii {

	static OgrenciOzelListe ogrenciOzelListe = new OgrenciOzelListe();
	static int sinif_mevcudu;
	static String[] sinifArkadaslari;
	static MaasOzelListe maasOzelListe = new MaasOzelListe();
	static String[][] hobiDizisi;
	static String[][] hobilerDizisi;
	static String[] hobilerArray;

	public static void ogrenciBilgileri() {

		boolean control = true;
		while (control) {
			menu();
			switch (islemSec()) {
			case 1:
				sinifArkadasiTanimla();
				break;
			case 2:
				hobileriniGir();
				break;
			case 3:
				maasBeklentisiniGir();
				break;
			case 4:
				sinifListesi();
				break;

			case 0: {
				System.err.println("Çıkış Yapıldı");
				control = false;
			}
				break;
			default:
				System.err.println("1-4 arasında bir seçim yapınız.");
			}

		}
	}

	public static void menu() {
		System.out.println("****************************");
		System.out.println("** ÖĞRENCİ BİLGİ SİSTEMİ ***");
		System.out.println("****************************");
		System.out.println();
		System.out.println("1- Sınıf arkadaşı tanımla");
		System.out.println("2- Hobilerini gir");
		System.out.println("3- Maaş beklentilerini gir");
		System.out.println("4- Sınıf Listesi");
		System.out.println("0- Ç I K I Ş");
		System.out.println();
	}

	public static int islemSec() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.print("Seçiniz....: ");
		int secim = sc.nextInt();
		sc.nextLine();
		return secim;
	}

	public static void sinifArkadasiTanimla() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Kaç öğrenci tanımlayacaksınız....: ");
		sinif_mevcudu = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < sinif_mevcudu; i++) {
			System.out.print((i + 1) + ". Öğrencinin adı.....: ");
			String ad = sc.nextLine();
			ogrenciOzelListe.add(ad);
		}
	}

	public static void hobileriniGir() {
		String strHobi = "";
		boolean[][] hobiler = new boolean[sinif_mevcudu][4];

		Scanner sc = new Scanner(System.in);
		System.out.print("Öğrenci Seçiniz....: ");
		String isim = sc.nextLine();
		int total_hobi = 0;
		for (int i = 0; i < sinif_mevcudu; i++) {

			if (ogrenciOzelListe.sinifOgrenciler[i].equals(isim)) {
				System.out.print("Yürümekten hoşlanır mısın[E/H]? ");
				String secim1 = sc.nextLine();
				System.out.print("Kitap Okumaktan hoşlanır mısın[E/H]? ");
				String secim2 = sc.nextLine();
				System.out.print("Spor rutinlerin var mı[E/H]? ");
				String secim3 = sc.nextLine();
				System.out.print("Kod yazmaktan hoşlanır mısın[E/H]? ");
				String secim4 = sc.nextLine();
				if (secim1.equalsIgnoreCase("E")) {
					hobiler[i][0] = true;
					strHobi = "Yürümek,";
					total_hobi++;
				} else {
					hobiler[i][0] = false;
				}
				if (secim2.equalsIgnoreCase("E")) {
					hobiler[i][1] = true;
					strHobi = "Kitap Okuma";
					total_hobi++;
				} else {
					hobiler[i][1] = false;
				}
				if (secim3.equalsIgnoreCase("E")) {
					hobiler[i][2] = true;
					strHobi = "Spor";
					total_hobi++;
				} else {
					hobiler[i][2] = false;
				}
				if (secim4.equalsIgnoreCase("E")) {
					hobiler[i][3] = true;
					strHobi = "Kod Yazma";
					total_hobi++;

				} else {
					hobiler[i][3] = false;
				}

			}
		}
		hobiDizisi = new String[sinif_mevcudu][total_hobi];
		int hobiIndex = 0;

		for (int i = 0; i < sinif_mevcudu; i++) {
			for (int j = 0; j < 4; j++) {
				if (hobiler[i][j]) {
					if (j == 0) {
						hobiDizisi[i][hobiIndex] = "Yürümek";
					} else if (j == 1) {
						hobiDizisi[i][hobiIndex] = "Kitap Okuma";
					} else if (j == 2) {
						hobiDizisi[i][hobiIndex] = "Spor";
					} else if (j == 3) {
						hobiDizisi[i][hobiIndex] = "Kod Yazma";
					}
					hobiIndex++;
				}
			}

		}

	}

	public static void maasBeklentisiniGir() {
		for (int i = 0; i < sinif_mevcudu; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.print((i + 1) + ". Öğrenci " + ogrenciOzelListe.sinifOgrenciler[i] + " in beklentisi...: ");
			double maasBeklentisi = sc.nextDouble();
			sc.nextLine();
			maasOzelListe.add(maasBeklentisi);

		}

	}

	public static void sinifListesi() {
		System.out.println("No    |Ad          | Hobiler                | Maaş Beklentisi");
		for (int i = 0; i < sinif_mevcudu; i++) {
			System.out.printf("%-6s %-13s ", (i + 1), ogrenciOzelListe.sinifOgrenciler[i]);
			for (int j = 0; j < hobiDizisi[i].length; j++) {
				System.out.printf(hobiDizisi[i][j] + ", ");
			}
			System.out.printf("%-7s\n", maasOzelListe.maasOzelListe[i]);
		}
	}
}