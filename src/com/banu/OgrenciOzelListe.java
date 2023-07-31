package com.banu;

public class OgrenciOzelListe {

	String[] sinifOgrenciler;
	int boyut = 0;

	public void add(String ad) {

		String[] tmp;
		if (sinifOgrenciler == null) {
			sinifOgrenciler = new String[1];
			sinifOgrenciler[0] = ad;
		} else {
			tmp = new String[boyut + 1];
			for (int i = 0; i < boyut; i++) {
				tmp[i] = sinifOgrenciler[i];
			}
			tmp[boyut] = ad;

			sinifOgrenciler = tmp;
		}
		boyut++;

	}

	public void list() {

		for (int i = 0; i < boyut; i++) {
			if (i == boyut - 1)
				System.out.print(sinifOgrenciler[i]);
			else
				System.out.print(sinifOgrenciler[i] + ", ");
		}
		System.out.print("]");
	}

}
