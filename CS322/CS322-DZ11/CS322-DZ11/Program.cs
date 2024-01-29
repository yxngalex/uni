using System;
using System.Collections;
using System.Collections.Generic;

namespace CS322_DZ11
{
    class Program
    {
        static void Main(string[] args)
        {
            Course c1 = new Course("Test", 12, "22");
            Course c2 = new Course("Test2", 125, "22");
            Course c3 = new Course("Test3", 123, "22");

            List<Course> list = new List<Course>();
            list.Add(c1);
            list.Add(c2);
            list.Add(c3);

            list.Sort((k1, k2) => k1.CompareTo(k2));

            foreach (Course c in list)
            {
                Console.WriteLine(c.ClassFund);
            }

            Student s = new Student("Test", "Test", 4173, "12345678", "Male");
            Professor p = new Professor("Test2", "Test2", "Software Engineer", "12345678",  "Female");

            Console.WriteLine(s.info());
            Console.WriteLine(s.gender());
            Console.WriteLine(p.info());
            Console.WriteLine(p.gender());
        }
    }
}