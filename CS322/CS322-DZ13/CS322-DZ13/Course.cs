using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS322_DZ13
{
    internal class Course
    {
        public string Code { get; set; }
        public string Name { get; set; }
        public int NumberOfClasses { get; set; }
        public int NumberOfExercises { get; set; }

        public Course(string Code, string Name, int NumberOfClasses, int NumberOfExercises)
        {
            this.Code = Code;
            this.Name = Name;
            this.NumberOfClasses = NumberOfClasses;
            this.NumberOfExercises = NumberOfExercises;
        }
    }
}
