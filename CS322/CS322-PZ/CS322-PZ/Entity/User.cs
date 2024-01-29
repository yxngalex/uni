using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS322_PZ.Entity
{
    public class User
    {
        public int Id { get; set; }
        public string Username { get; set; }
        public string Password { get; set; }
        public Role Role { get; set; }

        public User(int id, string username, string password, Role role)
        {
            Id = id;
            Username = username;
            Password = password;
            Role = role;
        }

        public User() { }

    }

    public class Role
    {
        public string Name { get; set; }

        public Role(string name)
        {
            Name = name;
        }
    }
}
