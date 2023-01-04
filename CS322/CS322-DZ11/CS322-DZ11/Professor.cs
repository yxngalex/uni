using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS322_DZ11
{
    class Professor : Person
    {
        private string Degree { get; set; }

        public Professor(string firstName, string lastName, string degree, string taxCode, string sex)
        {
            this.FirstName = firstName;
            this.LastName = lastName;
            this.TaxCode = taxCode;
            this.Sex = sex;
            this.Degree = degree;
        }
        public override string gender()
        {
            return this.Sex;
        }

        public override string info()
        {
            return "Professor: " + this.FirstName + " " + this.LastName + ", " + this.TaxCode + ", " + this.Degree + ", " + this.Sex;
        }
    }
}
