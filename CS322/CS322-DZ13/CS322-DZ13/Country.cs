using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS322_DZ13
{
    class Country : IEnumerable<City>
    {
        private IList<City> CityList;

        public Country()
        {
            CityList = new List<City>();
        }
        public void AddCity(City City)
        {
            CityList.Add(City);
        }
        public IEnumerator<City> GetEnumerator()
        {
            foreach (City city in CityList)
            {
                yield return city;
            }
        }
        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
    }
}
