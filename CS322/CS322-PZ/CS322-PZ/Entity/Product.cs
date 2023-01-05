using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS322_PZ.Entity
{
    public class Product
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public double Price { get; set; }

        public Product(int id, string name, string description, double price)
        {
            this.Id = id;
            this.Name = name;
            this.Description = description;
            this.Price = price;
        }

        public Product() { }

    }
}
