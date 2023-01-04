using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS322_DZ11
{
    abstract class Person : IPerson
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string TaxCode { get; set; }
        public string Sex { get; set; }

        public abstract string info();
        public abstract string gender();

    }
}
