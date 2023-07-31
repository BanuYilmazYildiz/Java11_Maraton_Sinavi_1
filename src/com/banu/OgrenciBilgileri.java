package com.banu;

import java.util.Scanner;

public class OgrenciBilgileri {
	static OgrenciOzelListe sinifArkadaslari = new OgrenciOzelListe();
	static int sinif_mevcudu;
	static String[][] sinifListesi;

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
		sinifListesi = new String[sinif_mevcudu][4];
		for (int i = 0; i < sinif_mevcudu; i++) {
			System.out.print((i + 1) + ". Öğrencinin adı.....: ");
			String ad = sc.nextLine();
			sinifListesi[i][1] = ad;
			sinifArkadaslari.add(ad);
			sinifListesi[i][0] = String.valueOf(i + 1);

		}

	}

	public static void hobileriniGir() {
		String strHobi = "";
		boolean[][] hobiler = new boolean[sinif_mevcudu][4];
		Scanner sc = new Scanner(System.in);
		System.out.print("Öğrenci Seçiniz....: ");
		String isim = sc.nextLine();
		for (int i = 0; i < sinif_mevcudu; i++) {

			if (sinifListesi[i][1].equalsIgnoreCase(isim)) {
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
					strHobi += "Yürümek,";
				} else {
					hobiler[i][0] = false;
				}
				if (secim2.equalsIgnoreCase("E")) {
					hobiler[i][1] = true;
					strHobi += "Kitap Okuma,";
				} else {
					hobiler[i][1] = false;
				}
				if (secim3.equalsIgnoreCase("E")) {
					hobiler[i][2] = true;
					strHobi += "Spor,";
				} else {
					hobiler[i][2] = false;
				}
				if (secim4.equalsIgnoreCase("E")) {
					hobiler[i][3] = true;
					strHobi += "Kod Yazma,";
				} else {
					hobiler[i][3] = false;
				}
				if (strHobi.lastIndexOf(',') == strHobi.length() - 1) {
					strHobi = strHobi.substring(0, strHobi.lastIndexOf(','));
				}
				sinifListesi[i][2] = strHobi;

			}
		}

	}

	public static void maasBeklentisiniGir() {
		for (int i = 0; i < sinif_mevcudu; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.print((i + 1) + ". Öğrenci " + sinifListesi[i][1] + " in beklentisi...: ");
			int maasBeklentisi = sc.nextInt();
			sc.nextLine();
			sinifListesi[i][3] = String.valueOf(maasBeklentisi);

		}

	}

	public static void sinifListesi() {
		System.out.println("No    |Ad          |Hobileri  	    	     	       |Maaş Beklentisi");
		for (int i = 0; i < sinif_mevcudu; i++) {
			System.out.printf("%-6s %-12s %-35s %-7s\n", sinifListesi[i][0], sinifListesi[i][1], sinifListesi[i][2],
					sinifListesi[i][3]);

		}

	}

}
