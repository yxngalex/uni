# SE211 - DZ02

## 1. Prikazati strukturni način programiranja.

```java
public boolean askForABook(String nameOfABook) {
        for (Book book: bookList) {
            if (book.getName().equals(nameOfABook)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
```

## 2. Opisati na koji način je moguće prepoznati strukturni način programiranja

Struktuirani način programiranja je prepoznatljiv po upotrebi kontrolnih strukura kao sto su `for`, `if`, `while`, `switch` itd. Kao i po jasnom nedostatku `goto` naredbe koja se smatra veoma štetnom za jasnoću i čitljivost koda.

## 3. Prikazati upotrebu return instrukcije u aplikaciji

```java
public Integer howManyBooksAreInALibrary() {
        return bookList.size();
    }
```

Ovde vraćam veličinu liste bookList, što se returna u metodi `howManyBooksAreInALibrary`.

## 4. Da li je moguće koristiti neku drugu instrukciju umesto return u aplikaciji?

Jedino kako je moguće je tako što se vrednost može staviti u promenljivoj i samim tim koristiti ponovo u toj funkciji ili kao alternativa odštampati (`console.logovati`) ta vrednost. Drugačije ne može zato što `return` instrukcija ima ulugu da vrati vrednost iz funkcije u kojoj se poziva.
