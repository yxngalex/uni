using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Zadatak2
{
    internal class DataSource
    {
        private string Host = "localhost";
        private string Database = "cs322-januar";
        private string Username = "root";
        private string Password = "";
        private string Port = "3306";

        public string getDataSource()
        {
            return "datasource=" + Host + ";database=" + Database + ";port=" + Port + ";username=" + Username  + ";password=" + Password + ";";
        }

    }
}
