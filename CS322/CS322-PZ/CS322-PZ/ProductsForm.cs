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
    public partial class ProductsForm : Form
    {
        private static string dataSource = "datasource=localhost;database=cs322;port=3306;username=root;password=;";
        private MySqlConnection conn;
        private MySqlDataAdapter adapter;
        public int userId = 0;
        public ProductsForm()
        {
            InitializeComponent();

            conn = new MySqlConnection(dataSource);
        }

        private void ProductsForm_Load(object sender, EventArgs e)
        {
            try
            {
                MySqlCommand command = null;
                MySqlDataReader reader = null;
                conn.Open();
                adapter = new MySqlDataAdapter();
                string Query = "SELECT * FROM product";
                command = new MySqlCommand(Query, conn);
                List<Product> products = new List<Product>();

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
                    ShopItem shopItem = new ShopItem();
                    shopItem.itemId = product.Id;
                    shopItem.itemUserId = userId;
                    shopItem.itemName = product.Name;
                    shopItem.itemDescription = product.Description;
                    shopItem.itemPrice = Convert.ToString(product.Price);

                    flowLayoutPanel1.Controls.Add(shopItem);
                }


            }
            catch (Exception ex)
            {
                conn.Close();
                MessageBox.Show("An error occured: " + ex.Message, "", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Login login = new Login();
            this.Hide();
            login.ShowDialog();
            this.Close();
        }

        private void shopItem1_Load(object sender, EventArgs e)
        {

        }
    }
}
