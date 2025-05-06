Laboratorium III - JPQL

Uwaga! Do wykonania zadan konieczne jest zaimplementowanie architektury warstwowej i testow z Laboratorium II !

Uzupelnij plik data.sql o dane niezbedne do realizacji nastepujacych zapytan:
1. Znajdz pacjentow po nazwisku
2. Znajdz wszystkie wizyty pacjenta po jego ID
3. znajdz pacjentow ktorzy mieli wiecej niz X wizyt (X jest parametrem wejsciowym)
4. Znajdz pacjentow po dodanym przez Ciebie polu - nie wyszukuj wprost po wartosci, uzyj zapytania typu wieksze/mniejsze/pozniej/wczesniej/zawiera, w zaleznosci od wybranego typu zmiennej.

Napisz testy do zapytan w nastepujacej formie:
1. do zapytania nr 1  - test DAO
2. do zapytania nr 2 - test serwisu
3. do zapytania nr 3 - test DAO
4. do zapytania nr 4 - test DAO

W PatientEntity, nad relacja do VisitEntity dodaj adnotacje

@Fetch(FetchMode.SELECT)

a fetchType zmien na EAGER
Uruchom test w ktorym pobierany jest Patient z wieloma wizytami. W logach zaobserwuj, jak wyglada pobieranie dodatkowych encji (ile i jakie sqle).
Nastepnie zmien adnotacje na

@Fetch(FetchMode.JOIN)

i powtorz test i obserwacje. Wnioski zapisz na dole tego pliku i skomituj.

Do wybranej encji dodaj wersjonowanie, oraz napisz test (w DAO) sprawdzajacy rownolegla modyfikacje (OptimisticLock)

WNIOSKI:
 Po uruchomieniu testu shouldFindPatientsWithMoreThanXVisits z adnotacją @Fetch(FetchMode.SELECT) można zaobserwować

Hibernate: select pe1_0.id,pe1_0.address_id,pe1_0.date_of_birth,pe1_0.email,pe1_0.first_name,pe1_0.is_insured,pe1_0.last_name,pe1_0.patient_number,pe1_0.telephone_number from patient pe1_0 where (select count(*) from visit v1_0 where pe1_0.id=v1_0.patient_id)>?
Hibernate: select ae1_0.id,ae1_0.address_line1,ae1_0.address_line2,ae1_0.city,d1_0.id,d1_0.doctor_number,d1_0.email,d1_0.first_name,d1_0.last_name,d1_0.specialization,d1_0.telephone_number,p1_0.id,p1_0.date_of_birth,p1_0.email,p1_0.first_name,p1_0.is_insured,p1_0.last_name,p1_0.patient_number,p1_0.telephone_number,ae1_0.postal_code from address ae1_0 left join doctor d1_0 on ae1_0.id=d1_0.address_id left join patient p1_0 on ae1_0.id=p1_0.address_id where ae1_0.id=?
Hibernate: select v1_0.patient_id,v1_0.id,v1_0.description,v1_0.doctor_id,v1_0.time from visit v1_0 where v1_0.patient_id=?


Natomiast z adnotacją @Fetch(FetchMode.JOIN)

Hibernate: select pe1_0.id,pe1_0.address_id,pe1_0.date_of_birth,pe1_0.email,pe1_0.first_name,pe1_0.is_insured,pe1_0.last_name,pe1_0.patient_number,pe1_0.telephone_number from patient pe1_0 where (select count(*) from visit v1_0 where pe1_0.id=v1_0.patient_id)>?
Hibernate: select ae1_0.id,ae1_0.address_line1,ae1_0.address_line2,ae1_0.city,
            d1_0.id,d1_0.doctor_number,d1_0.email,d1_0.first_name,d1_0.last_name,d1_0.specialization,d1_0.telephone_number,
            p1_0.id,p1_0.date_of_birth,p1_0.email,p1_0.first_name,p1_0.is_insured,p1_0.last_name,p1_0.patient_number,p1_0.telephone_number,
            v1_0.patient_id,v1_0.id,v1_0.description,v1_0.doctor_id,v1_0.time,ae1_0.postal_code from address ae1_0 left join doctor d1_0 on ae1_0.id=d1_0.address_id left join patient p1_0 on ae1_0.id=p1_0.address_id left join visit v1_0 on p1_0.id=v1_0.patient_id where ae1_0.id=?

Po zastosowaniu @Fetch(FetchMode.SELECT) hibernate generuje osobne query dla każdej wizyty (dodatkowy select).
@Fetch(FetchMode.Join) hibernate posługuje się join'em