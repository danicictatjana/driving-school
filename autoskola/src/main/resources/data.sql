INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

INSERT INTO auto_skola (id, naziv, godina_osnivanja, broj_vozila) VALUES (1, 'Aluno', 2000, 1);
INSERT INTO auto_skola (id, naziv, godina_osnivanja, broj_vozila) VALUES (2, 'Dunav', 1999, 2);
INSERT INTO auto_skola (id, naziv, godina_osnivanja, broj_vozila) VALUES (3, 'Formula', 2005, 3);

INSERT INTO polaznik (id, ime, prezime, godina_rodjenja, mesto, auto_skola_id, odslusao_teoriju, odradio_voznju, polozio, prijavljen) VALUES (1, 'Tanja', 'Danicic', 1995, 'Raska', 1, true, true, false, false);
INSERT INTO polaznik (id, ime, prezime, godina_rodjenja, mesto, auto_skola_id, odslusao_teoriju, odradio_voznju, polozio, prijavljen) VALUES (2, 'Zoran', 'Simic', 1998, 'Novi Sad', 2, true, true, true, true);
INSERT INTO polaznik (id, ime, prezime, godina_rodjenja, mesto, auto_skola_id, odslusao_teoriju, odradio_voznju, polozio, prijavljen) VALUES (3, 'Dusan', 'Ugy', 1987, 'Kladovo', 3, false, false, false, false);

INSERT INTO polaganje (id, broj_mesta, datum, auto_skola_id) VALUES (1, 10, '2000-03-20', 1);
INSERT INTO polaganje (id, broj_mesta, datum, auto_skola_id) VALUES (2, 20, '2003-03-20', 2);
INSERT INTO polaganje (id, broj_mesta, datum, auto_skola_id) VALUES (3, 30, '1987-03-20', 3);	