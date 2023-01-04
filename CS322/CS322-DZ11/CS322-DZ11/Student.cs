using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS322_DZ11
{
    class Student : Person
    {
        public int Index { get; set; }

        public Student(string firstName, string lastName, int index, string taxCode, string sex)
        {
            this.FirstName = firstName;
            this.LastName = lastName;
            this.TaxCode = taxCode;
            this.Sex = sex;
            this.Index = index;
        }

        public override string gender()
        {
            return this.Sex;
        }

        public override string info()
        {
            return "Student: " + this.FirstName + " " + this.LastName + ", " + this.Index + ", " + this.TaxCode + ", " + this.Sex;
        }
    }
}
