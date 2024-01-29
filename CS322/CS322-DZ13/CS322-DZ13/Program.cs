using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace CS322_DZ13
{
    class Program
    {
        static void Main(string[] args)
        {
            Person p1 = new Person("Test1", "Testing1", 20);
            Person p2 = new Person("Test2", "Testing2", 19);
            Person p3 = new Person("Test3", "Testing3", 22);

            City city = new City("Nis");
            city.addPerson(p1);
            city.addPerson(p2);
            city.addPerson(p3);

            Person[] personList = new Person[] {p1, p2, p3};

            IEnumerable<Person> list = city.Where(data => String.Equals(data.FirstName, "Test3"));

            Console.WriteLine(list.Count() + "");

            foreach(Person p in list)
            {
                Console.WriteLine(p.FirstName);
            }

            Country c = new Country();
            c.AddCity(city);

            IEnumerable<City> os = c.Where(data => String.Equals(city.Name, "Nis"));

            Console.WriteLine(os.Count() + "");

            foreach (City o in os)
            {
                Console.WriteLine(o.Name);
            }


            Course c1 = new Course("CS322", "C# Programski Jezik", 3, 3);
            Course c2 = new Course("CS324", "Skripting Jezici", 3, 3);

            University uni = new University("Univerzitet Metropolitan");

            uni.AddCourse(c1);
            uni.AddCourse(c2);

            IEnumerable<Course> CourseList = uni.Where(d => String.Equals(d.Name, "Nis"));

            Console.WriteLine(os.Count() + "");

            foreach (Course co in CourseList)
            {
                Console.WriteLine(co.Name);
            }


            string mySqlConnectionString = "datasource=localhost;database=cs322dz13;port=3306;username=root;password=;";

            MySqlConnection conn = new MySqlConnection(mySqlConnectionString);
            MySqlCommand command = new MySqlCommand("INSERT INTO user(username, password, name) VALUES (@Username, @Password, @Name)", conn);
            command.Parameters.AddWithValue("@Username", "UsernameTest");
            command.Parameters.AddWithValue("@Password", "1234test");
            command.Parameters.AddWithValue("@Name", "test");
            conn.Open();
            object ob = command.ExecuteScalar();
            conn.Close();
        }
    }
}