using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadatak1
{
    internal class Klijent
    {
        public string KorisnickoIme { get; set; }
        public string Lozinka { get; set; }
        public string Ime { get; set; }
        public string Prezime { get; set; }
        public string Adresa { get; set; }
        public string Email { get; set; }
        public string MobilniTelefon { get; set; }

        public Klijent()
        {

        }

        public Klijent(string KorisnickoIme, string Lozinka, string Ime, string Prezime, string Adresa, string Email, string MobilniTelefon)
        {
            this.KorisnickoIme = KorisnickoIme;
            this.Lozinka = Lozinka;
            this.Ime = Ime;
            this.Prezime = Prezime;
            this.Adresa = Adresa;
            this.Email = Email;
            this.MobilniTelefon = MobilniTelefon;
        }

        public override string ToString()
        {
            return KorisnickoIme + " " + Ime + " " + Prezime + " " + Email;
        }
    }
}
