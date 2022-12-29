using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS322_PZ.Entity
{
    internal class User
    {
        public string Username { get; set; }
        public string Password { get; set; }
        public Role Role { get; set; }

        public User(string username, string password, Role role)
        {
            Username = username;
            Password = password;
            Role = role;
        }

    }

    internal class Role
    {
        public string Name { get; set; }

        public Role(string name)
        {
            Name = name;
        }
    }
}
