using CS322_PZ.Entity;
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
    public partial class Login : Form
    {

        private static string dataSource = "datasource=localhost;database=cs322;port=3306;username=root;password=;";
        private MySqlConnection conn;

        public Login()
        {
            InitializeComponent();

            conn = new MySqlConnection(dataSource);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string Username = textBox1.Text;
            string Password = textBox2.Text;

            MySqlCommand command = null;
            MySqlDataReader reader = null;

            if (Username != "" && Password != "")
            {
                {
                    string Query = "SELECT * FROM user WHERE username = '"
                                        + Username + "' AND password LIKE '" + Password + "';";
                    command = new MySqlCommand(Query, conn);
                    conn.Open();

                    reader = command.ExecuteReader();

                    int userId = 0;
                    string username = "";
                    string password = "";
                    string roleName = "";
                    int roleId = 0;

                    if (reader.HasRows)
                    {
                        while (reader.Read())
                        {
                            userId = reader.GetInt16("id");
                            username = reader.GetString("username");
                            password = reader.GetString("password");
                            roleId = reader.GetInt16("role");
                        }
                    }
                    reader.Close();

                    string roleQuery = "SELECT * FROM role WHERE role.id = " + roleId + ";";
                    command = new MySqlCommand(roleQuery, conn);

                    reader = command.ExecuteReader();

                    if (reader.HasRows)
                    {

                        while (reader.Read())
                        {
                            roleName = reader.GetString("name");
                        }

                    } 
                    else
                    {
                        MessageBox.Show("User credentials are not valid");
                    }

                    reader.Close();

                    Role role = new Role(roleName);
                    User user = new User(userId, username, password, role);

                    if (user.Role.Name == "admin")
                    {
                        // Go to Admin page
                        AdminForm adminpage = new AdminForm();
                        adminpage.Username = user.Username;
                        this.Hide();
                        adminpage.ShowDialog();
                        this.Close();
                    } 
                    else if (user.Role.Name == "user")
                    {
                        // Go to User page
                        ProductsForm productsForm = new ProductsForm();
                        this.Hide();
                        productsForm.userId = user.Id;
                        productsForm.ShowDialog();
                        this.Close();
                    }
                    conn.Close();

                }
            }
            else
            {
                MessageBox.Show("Username and/or Password are empty!");
            }

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }
    }
}