using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using MySql.Data.MySqlClient;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.StartPanel;
using CS322_PZ.Entity;

namespace CS322_PZ
{
    public partial class CartForm : Form
    {
        private static string dataSource = "datasource=localhost;database=cs322;port=3306;username=root;password=;";
        private MySqlConnection conn;
        private MySqlDataAdapter adapter;
        public int userId = 0;
        private double totalPrice = 0d;
        private List<Product> products = null;

        public CartForm()
        {
            InitializeComponent();
            conn = new MySqlConnection(dataSource);
        }

        private void CartForm_Load(object sender, EventArgs e)
        {
            try
            {
                MySqlCommand command = null;
                MySqlDataReader reader = null;
                conn.Open();
                string q = "SELECT p.id, p.name, p.description, p.price FROM cart AS c INNER JOIN product AS p on c.product = p.id WHERE user = " + userId + ";";
                command = new MySqlCommand(q, conn);
                products = new List<Product>();
                List<int> productIds = new List<int>();

                reader = command.ExecuteReader();

                if (reader.HasRows)
                {
                    while (reader.Read())
                    {
                        Product product = new Product();
                        product.Id = reader.GetInt16("id");
                        product.Name = reader.GetString("name");
                        product.Description = reader.GetString("description");
                        product.Price = reader.GetDouble("price");
                        products.Add(product);
                    }
                }
                reader.Close();

                foreach (Product product in products)
                {
                    CartItem cartItem = new CartItem();
                    cartItem.itemId = product.Id;
                    cartItem.itemUserId = userId;
                    cartItem.itemName = product.Name;
                    cartItem.itemDescription = product.Description;
                    cartItem.itemPrice = Convert.ToString(product.Price);
                    totalPrice += product.Price;

                    flowLayoutPanel1.Controls.Add(cartItem);
                }

                label2.Text = string.Format("{0:00.0}", totalPrice);


                conn.Close();
            }
            catch (Exception ex)
            {
                conn.Close();
                MessageBox.Show("An error occured: " + ex.Message, "", MessageBoxButtons.OK, MessageBoxIcon.Error);

            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Login login = new Login();
            this.Hide();
            login.ShowDialog();
            this.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (products != null && products.Count > 0)
            {
                string query = "DELETE FROM cart WHERE user = " + userId + ";";
                MySqlCommand command = new MySqlCommand(query, conn);

                try
                {
                    conn.Open();
                    command.ExecuteNonQuery();
                    conn.Close();
                    MessageBox.Show("Thank you for your order! Your total price: " + string.Format("{0:00.0}", totalPrice));

                    ProductsForm pf = new ProductsForm();
                    this.Hide();
                    pf.userId = userId;
                    pf.ShowDialog();
                    this.Close();
                }
                catch (Exception ex)
                {
                    conn.Close();
                    MessageBox.Show("An error occured while ordering");
                }
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            ProductsForm pf = new ProductsForm();
            this.Hide();
            pf.userId = userId;
            pf.ShowDialog();
            this.Close();
        }
    }
}
