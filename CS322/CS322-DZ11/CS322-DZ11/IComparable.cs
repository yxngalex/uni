using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS322_DZ11
{
    interface IComparable<T>
    {
        int CompareTo(T course);
    }
}
