package com.banu;

public class MaasOzelListe {

	int[] maasOzelListe;
	int boyut = 0;

	public void add(int maas) {
		int[] tmp;
		if (maasOzelListe == null) {
			maasOzelListe = new int[1];
			maasOzelListe[0] = maas;
		} else {
			tmp = new int[boyut + 1];
			for (int i = 0; i < boyut; i++) {
				tmp[i] = maasOzelListe[i];
			}
			tmp[boyut] = maas;

			maasOzelListe = tmp;
		}
		boyut++;

	}

	public void list() {
		System.out.print("[");
		for (int i = 0; i < boyut; i++) {
			if (i == boyut - 1)
				System.out.print(maasOzelListe[i]);
			else
				System.out.print(maasOzelListe[i] + ", ");
		}
		System.out.print("]");
	}
}
