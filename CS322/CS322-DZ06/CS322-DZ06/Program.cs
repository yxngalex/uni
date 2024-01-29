using System;

namespace cs322_dz06
{
    internal class Program
    {
        public static void Main(string[] args)
        {

            Student s = new Student("Test", "Testic", "0204123459124", "4132");
            Student s2 = new Student("Petar", "Peric", "0120938192124", "3312");

            Console.WriteLine(s.showInfo());
            Console.WriteLine(s2.showInfo());
        }
    }

    interface Person
    {
        string showInfo();
    }

    abstract class AbstractPerson : Person
    {
        protected string FirstName;
        protected string LastName;
        protected string TaxCode;
        protected AbstractPerson(string firstName, string lastName, string taxCode)
        {
            FirstName = firstName;
            LastName = lastName;
            TaxCode = taxCode;
        }

        public abstract string showInfo();
    }

    class Student : AbstractPerson
    {
        private string Index;

        public Student(string firstName, string lastName, string taxCode, string index) : base(firstName, lastName, taxCode)
        {
            Index = index;
        }

        public override string showInfo()
        {
            return FirstName + " " + LastName + " " + TaxCode + " " + Index;
        }

    }
}