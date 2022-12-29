using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CS322_PZ
{
    public partial class AdminForm : Form
    {
        private static string dataSource = "datasource=localhost;database=cs322;port=3306;username=root;password=;";
        private MySqlConnection conn;
        private MySqlDataAdapter adapter;

        public AdminForm()
        {
            InitializeComponent();

            conn = new MySqlConnection(dataSource); 
        }

        internal void AdminData(string username, string password)
        {

        }
    }
}
