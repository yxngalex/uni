using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadatak1
{
    internal class Narudzbina
    {
        public ArrayList ListaKnjiga { get; set; }
        public DateTime DatumNarudzbine { get; set; }
        public double UkupnaCena { get; set; }

        public Narudzbina() { }

        public Narudzbina(ArrayList listaKnjiga, DateTime datumNarudzbine, double ukupnaCena)
        {
            ListaKnjiga = listaKnjiga;
            this.DatumNarudzbine = datumNarudzbine;
            UkupnaCena = ukupnaCena;
        }

        public override string ToString()
        {
            String s = "";
            foreach (Knjiga k in ListaKnjiga)
            {
                s += k.ToString() + "\n";
            }
            return "Narudzbina:\n" + s + DatumNarudzbine + " " + UkupnaCena;
        }

        public void izracunajUkupnaCenu()
        {
            double cena = 0;
            foreach(Knjiga k in ListaKnjiga)
            {
                cena += k.Cena;
            }
            UkupnaCena = cena;
        }
    }
}
