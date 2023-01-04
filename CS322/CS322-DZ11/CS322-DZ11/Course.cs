using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS322_DZ11
{
    class Course : IComparable<Course>
    {
        public string CourseName { get; set; }
        public int ClassFund { get; set; }
        public string MaxReg { get; set; }

        public Course(string name, int fund, string maxRegistration)
        {
            this.CourseName = name;
            this.ClassFund = fund;
            this.MaxReg = maxRegistration;
        }

        public Course() { }

        public int CompareTo(Course course)
        {
            if (this.ClassFund > course.ClassFund)
            {
                return 1;
            }
            else if (this.ClassFund == course.ClassFund)
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
    }
}
