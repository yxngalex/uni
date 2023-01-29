using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadatak1
{
    internal class Knjiga
    {
        public string Naziv { get; set; }
        public string Autor { get; set; }
        public double Cena { get; set; }
        public string Slika { get; set; }
        public string Kategorija { get; set; }

        public Knjiga()
        {

        }

        public Knjiga(string naziv, string autor, double cena, string slika, string kategorija)
        {
            this.Naziv = naziv;
            this.Autor = autor;
            this.Cena = cena;
            this.Slika = slika;
            this.Kategorija = kategorija;
        }

        public override string ToString()
        {
            return Naziv + " " + Autor + " " + Cena + " " + Slika + " " + Kategorija;
        }
    }
}
