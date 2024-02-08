
# Projekt iz MITTPP

Projektni zadatak bio je koristeći koncepte i tehnike kreirati okvir (framework) za automatsko testiranje odabrane programske podrške i alata. Testirala sam funkcionalnosti web stranice "https://demoqa.com" koristeći Selenium i programski jezik Java.

Napisano je šest testova:
1. vidljivost i nevidljivost elementa
2. upisivanje u textBox i submitanje
3. pretraživanje postojećega i nepostojećega
4. testiranje prijave s valid i invalid podacima, testiranje odjave 
5. provjera funkcionalnosti drag-drop
6. popunjavanje forme

# Korištene tehnologije
2.1 IntelliJ IDEA  
IntelliJ IDEA predstavlja integrirano razvojno okruženje (IDE) koje je posebno dizajnirano za podršku razvoju softvera. Ovo moćno IDE, iako ne vezano uz Visual Studio 2022, omogućuje učinkovito programiranje u različitim programskim jezicima, uključujući Java, Kotlin, Scala, i druge.
U ovom projektu korišten je programski jezik Java.

2.2 Selenium  
Selenium, alat otvorenog koda za automatizaciju web preglednika, koristi se u kombinaciji s IntelliJ IDEA kako bi se olakšalo automatsko testiranje web aplikacija. Razvijen za podršku programerima i testerima, Selenium omogućava pisanje testova koji automatski provjeravaju funkcionalnosti web stranica na različitim preglednicima poput Chrome-a, Firefox-a, Edge-a, i drugih.
U ovom projektu testirala sam u dva browsera Chrome i Firefox.

2.3 Git  
Git je distribuirani sustav za kontrolu verzija koji se koristi za praćenje promjena u izvorima koda tijekom razvoja softvera. Integriran je u IntelliJ IDEA kako bi omogućio učinkovito upravljanje kodom i praćenje povijesti promjena. Git podržava grananje, spajanje, praćenje promjena, i druge funkcionalnosti koje pomažu održavanju integriteta koda i suradnji u razvojnom procesu.
Git u ovom projektu je korišten za grananje i lakšu organizaciju.Kroz .gitignore file onemogućeno je generiranje nepotrebnih dokumenata te se tako izbjegava mogućnost pushanja zastarjelih verzija.

Ova kombinacija IntelliJ IDEA, Gita i Selenium-a pruža stabilno okruženje za razvoj i automatizaciju testova.

# Korišteni alati

Selenium WebDriver: otvoreni alat za automatizaciju web aplikacija koji omogućuje testiranje različitih funkcionalnosti

JUnit: okvir za testiranje koji podržava automatsko izvođenje testova i prikazivanje rezultata

WebDriverManager: alat za automatsko upravljanje WebDriver verzijama, što olakšava konfiguraciju

Wait naredba u Selenium WebDriveru: upotrebljava se za precizno upravljanje vremenom čekanja kako bi se izbjegli problemi s asinkronim elementima

# Pokretanje testova 
![image](https://github.com/kispetra/MITTPP/assets/123375732/c4b1fa4c-2f7e-4cc0-973f-ec0898ad6dc1)

Na slici su prikazani svi testovi pokrenuti iz testng.xml datoteke.

Prilikom kreiranja projekta, odabrala sam Maven za upravljanje ovisnostima, omogućavajući jednostavno dodavanje biblioteka poput org.seleniumhq.selenium i org.testng. Maven automatski upravlja preuzimanjem potrebnih biblioteka i njihovim uključivanjem u projekt. 

# Testovi
1. FirstTest
![image](https://github.com/kispetra/MITTPP/assets/123375732/59c0c971-b45d-465b-be73-469c601d9500)

Prije početka testova, inicijalizira se WebDriver za Google Chrome i otvara početna stranica na https://demoqa.com/. Također, rukuje skočnim prozorom za prihvaćanje kolačića na stranici klikom na gumb X pomoću WebDriverWait.

Prvi test provjerava je li naslov trenutne stranice jednak očekivanom naslovu "DEMOQA". Koristi se WebDriverWait kako bi se sačekalo da se naslov pojavi, a zatim uspoređuje stvarni i očekivani naslov. U slučaju neusklađenosti, test završava neuspjehom s odgovarajućom porukom.

Drugi test čeka da se određeni element s klasom "card-body" pojavi na stranici i zatim provjerava je li vidljiv. Ako element nije vidljiv, test završava neuspjehom s odgovarajućom porukom.

Treći test provjerava vidljivost elementa s klasom "non-card-body", koji pretpostavljamo da ne postoji na stranici. Ako element nije pronađen (prazna lista), test prolazi. Ova provjera je korisna kada želimo osigurati da određeni element nije prisutan na stranici.

Nakon završetka testova, WebDriver se zatvara kako bi se osiguralo pravilno čišćenje resursa.

2. SecondTest
![image](https://github.com/kispetra/MITTPP/assets/123375732/dfd63f64-6c61-4dd4-8468-1f64584a50a2)

Prije početka testova kao i u FirstTest inicijalizira WebDriver.

Prvi test provjerava ispravnost unosa teksta u tekstualno polje (textbox). Nakon što se pronađe tekstualno polje, upisuje se tekst "Petra Kiš", a zatim se provjerava je li uneseni tekst jednak očekivanom. Ukoliko nema podudaranja, test završava neuspjehom s odgovarajućom porukom.

Drugi test fokusira se na funkcionalnost gumba za slanje podataka (submit button). Koristi se WebDriverWait kako bi se sačekalo da gumb postane klikabilan, a zatim se izvode akcije pomoću klase Actions za pomicanje do gumba i izvršavanje klika. Nakon toga, čeka se vidljivost određene poruke na stranici. Ako poruka postane vidljiva, test se smatra uspješnim; inače, završava se neuspjehom s odgovarajućom porukom.

Nakon završetka oba testa, WebDriver se zatvara kako bi se osiguralo pravilno čišćenje resursa.

3. ThirdTest
![image](https://github.com/kispetra/MITTPP/assets/123375732/eb8727c3-66e3-4102-a5b1-ff66bb5fc153)
![image](https://github.com/kispetra/MITTPP/assets/123375732/72418dac-c28a-4b49-bff8-78e319ba40fd)

Prije izvođenja testova, WebDriver se konfigurira za rad s preglednikom Firefox. Zatim se otvara web stranica (https://demoqa.com/books).

Prvi test (testSearchByNonExistingTitle) provjerava funkcionalnost pretraživanja knjiga po naslovu koji ne postoji. Implicitno čekanje postavlja se na 2 sekunde kako bi se pričekalo prije nego što se izvrši pretraživanje. Zatim se izvodi pretraživanje knjige s nepostojećim naslovom ("Git Pocket Guide22") i provjerava se nepostojanje rezultata pretrage. Nakon toga, čisti se polje za pretragu.

Drugi test (testSearchByTitle) ovisi o prethodnom testu i provjerava pretraživanje po stvarnom naslovu knjige ("Git Pocket Guide"). Nakon pretraživanja, provjerava se vidljivost knjige, čisti se polje za pretragu, te se izvršava klik na knjigu.

Nakon završetka oba testa, WebDriver se zatvara kako bi se osiguralo pravilno čišćenje resursa. Metode kao što su performSearch, isBookVisible, assertBookVisible, clearSearchBox i clickOnBook koriste se za pojednostavljenje koraka u testovima i poboljšanje čitljivosti koda i poštuju OOP načela.

4. ForthTest
![image](https://github.com/kispetra/MITTPP/assets/123375732/e663e6d0-6678-44f0-9cfd-6cbe2acfdbf9)

Prije izvođenja testova, WebDriver se konfigurira za rad s preglednikom Firefox. Zatim se otvara određena stranica (https://demoqa.com/login), a dijalog se rukuje klikom na gumb X pomoću WebDriverWait.

Prvi test (testLogin) provjerava funkcionalnost prijave korisnika. Unose se korisničko ime i lozinka, a zatim se klikne na gumb za prijavu. Kako bi se osiguralo da je gumb za prijavu vidljiv na ekranu, koristi se JavaScriptExecutor za pomicanje do gumba prije klika. Nakon prijave, provjerava se prikazivanje poruke o uspješnoj prijavi ("Login").

Drugi test (testLogout) ovisi o prvom testu i provjerava funkcionalnost odjave. Koristi se WebDriverWait za čekanje da se gumb za odjavu učini klikabilnim, a zatim se izvršava odjava.

Treći test (testLogin_wrongInputs) ovisi o drugom testu i provjerava kako se sustav nosi s krivim unosima za prijavu. Unose se pogrešno korisničko ime i ispravna lozinka, a zatim se provjerava da poruka o uspješnoj prijavi nije prikazana.

Nakon završetka sva tri testa, WebDriver se zatvara kako bi se osiguralo pravilno čišćenje resursa. Metode kao što su testLogin, testLogout i testLogin_wrongInputs koriste se za pojednostavljenje koraka u testovima i poboljšanje čitljivosti koda.

5. FifthTest
![image](https://github.com/kispetra/MITTPP/assets/123375732/487806e9-d10b-41c6-bc98-2a285909ee29)

Ovaj test, nazvan FifthTest, provjerava funkcionalnost povlačenja i ispuštanja (drag and drop) koristeći Selenium WebDriver za preglednik Firefox.

Prije izvođenja testova, WebDriver se postavlja za rad s preglednikom Firefox. Otvorena je stranica https://demoqa.com/droppable

Zatim slijedi sam test testDroppable. Lociranje elemenata za povlačenje (draggableElement) i ispuštanje (droppableElement) vrši se pomoću By i WebDriverWait kako bi se osiguralo da su oba elementa vidljiva prije nego što se nastavi s testom.

Korištenjem Actions klase iz Seleniuma, izvršava se drag and drop operacija. Metoda dragAndDrop uzima dva WebElementa, u ovom slučaju, draggableElement i droppableElement, te ih izvršava na trenutnom pregledniku.

Na kraju testa, WebDriver se zatvara u metodi closeBrowser kako bi se osiguralo pravilno čišćenje resursa.

6. SixthTest
![image](https://github.com/kispetra/MITTPP/assets/123375732/54fdb2c0-ac01-4eb1-b179-6e76a6d81996)

Ovaj test, nazvan SixthTest, provjerava ispunjavanje obrasca na stranici "https://demoqa.com/automation-practice-form" pomoću Selenium WebDrivera za preglednik Firefox. Evo pregleda koda:

Prije izvođenja testova, WebDriver se postavlja za rad s preglednikom Firefox. Otvorena je stranica "https://demoqa.com/automation-practice-form".

Zatim slijedi sam test testPracticeForm. Svaki unos forme (ime, prezime, e-pošta, spol, broj telefona, datum rođenja) vrši se pomoću različitih metoda i akcija.

Unos imena i prezimena: Lociranje elemenata za unos imena (firstNameInput) i prezimena (lastNameInput) pomoću By i WebDriverWait, a zatim slanje teksta.

Unos e-pošte: Lociranje elementa za unos e-pošte (emailInput) i slanje teksta.

Odabir spola: Lociranje radio gumba za ženski spol (genderRadio) i klikanje pomoću JavascriptExecutor.

Unos broja telefona: Lociranje elementa za unos broja telefona (mobileNumberInput) i slanje teksta.

Odabir datuma rođenja: Lociranje elementa za unos datuma rođenja (dateOfBirthInput) i klikanje. Zatim odabir mjeseca, godine i dana pomoću Select klase za padajuće izbornike i klikanje na određeni dan.

Pomicanje prema gumbu za slanje: Lociranje gumba za slanje (submitButton), stvaranje instance Actions klase, pomicanje prema gumbu pomoću moveToElement i izvođenje akcija pomoću perform.

Na kraju testa, WebDriver se zatvara u metodi closeBrowser kako bi se osiguralo pravilno čišćenje resursa.





