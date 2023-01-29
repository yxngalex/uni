using System.Collections;

namespace Zadatak1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Knjiga k1 = new Knjiga("Knjiga1", "Autor1", 123d, "Slika1", "Kategorija1");
            Knjiga k2 = new Knjiga("Knjiga2", "Autor2", 123d, "Slika2", "Kategorija2");
            Knjiga k3 = new Knjiga("Knjiga3", "Autor3", 123d, "Slika3", "Kategorija3");
            Knjiga k4 = new Knjiga("Knjiga4", "Autor4", 123d, "Slika4", "Kategorija4");
            Knjiga k5 = new Knjiga("Knjiga5", "Autor5", 123d, "Slika5", "Kategorija5");

            ArrayList kArr = new ArrayList();

            kArr.Add(k1);
            kArr.Add(k2);
            kArr.Add(k3);
            kArr.Add(k4);
            kArr.Add(k5);

            try
            {
                Klijent k = inputKlijent();
                DateTime date = DateTime.Now;

                ArrayList kToBuy = knjigeToBuy(kArr, k);

                Narudzbina nar = new Narudzbina();
                nar.ListaKnjiga = kToBuy;
                nar.izracunajUkupnaCenu();
                nar.DatumNarudzbine = date;
                Console.WriteLine(nar.ToString());
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                Console.WriteLine(e.StackTrace);
            }



        }

        static Klijent inputKlijent()
        {
            Klijent kl = new Klijent();

            Console.WriteLine("Unesite korisnicko ime: ");
            kl.KorisnickoIme = Console.ReadLine();
            Console.WriteLine("Unesite lozinku: ");
            kl.Lozinka = Console.ReadLine();
            Console.WriteLine("Unesite ime: ");
            kl.Ime = Console.ReadLine();
            Console.WriteLine("Unesite prezime: ");
            kl.Prezime = Console.ReadLine();
            Console.WriteLine("Unesite adresu: ");
            kl.Adresa = Console.ReadLine();
            Console.WriteLine("Unesite email: ");
            kl.Email = Console.ReadLine();
            Console.WriteLine("Unesite mobilni telefon: ");
            kl.MobilniTelefon = Console.ReadLine();
            if (kl.MobilniTelefon.Length != 10)
            {
                throw new Exception("Duzina telefona mora biti 10 karaktera");
            }

            return kl;
        }

        static ArrayList knjigeToBuy(ArrayList arr, Klijent k)
        {
            ArrayList kToBuy = new ArrayList();

            Console.WriteLine("Unesite koliko knjiga zelite da porucite:");
            int n = int.Parse(Console.ReadLine());


            for (int i = 0; i < n; i++)
            {
                Console.WriteLine("Izabrite redni broj knjiga za porucivanje: ");
                foreach (Knjiga kn in arr)
                {
                    Console.WriteLine(kn.ToString());
                }
                kToBuy.Add(arr[Convert.ToInt32(Console.ReadLine()) - 1]);
            }

            return kToBuy;
        }
    }
}