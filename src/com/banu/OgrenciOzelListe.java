package com.banu;

public class OgrenciOzelListe {

	String[] sinifArkadaslari;
	int boyut = 0;

	public void add(String ad) {

		String[] tmp;
		if (sinifArkadaslari == null) {
			sinifArkadaslari = new String[1];
			sinifArkadaslari[0] = ad;
		} else {
			tmp = new String[boyut + 1];
			for (int i = 0; i < boyut; i++) {
				tmp[i] = sinifArkadaslari[i];
			}
			tmp[boyut] = ad;

			sinifArkadaslari = tmp;
		}
		boyut++;

	}

	public void list() {
		System.out.print("[");
		for (int i = 0; i < boyut; i++) {
			if (i == boyut - 1)
				System.out.print(sinifArkadaslari[i]);
			else
				System.out.print(sinifArkadaslari[i] + ", ");
		}
		System.out.print("]");
	}

}
