using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS322_DZ13
{
    class City : IEnumerable<Person>
    {
        private IList<Person> PersonList;
        public string Name { get; set; }
        public City(string Name)
        {
            PersonList = new List<Person>();
            this.Name = Name;
        }

        public void addPerson(Person person)
        {
            PersonList.Add(person);
        }

        public IEnumerator<Person> GetEnumerator()
        {
            foreach (Person person in PersonList)
            {
                yield return person;
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
    }
}
