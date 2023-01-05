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
    public partial class AddNewProductForm : Form
    {
        private static string dataSource = "datasource=localhost;database=cs322;port=3306;username=root;password=;";
        private MySqlConnection conn;
        private MySqlDataAdapter adapter;
        private Product product = new Product();

        public AddNewProductForm()
        {
            InitializeComponent();

            conn = new MySqlConnection(dataSource);
        }

        private void AddNewProductForm_Load(object sender, EventArgs e)
        {
            if (product != null)
            {
                label1.Text = "Update product: " + product.Name;
                textBox1.Text = product.Name;
                richTextBox1.Text = product.Description;
                textBox2.Text = product.Price.ToString();
            }
            else
            {
                label1.Text = "Add a new Product";
            }
        }

        public void setProduct(Product product)
        {
            this.product = product;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            AdminForm adminF = new AdminForm();
            this.Hide();
            adminF.ShowDialog();
            this.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (product != null)
            {
                Product newProd = new Product();
                newProd.Name = textBox1.Text;
                newProd.Description = richTextBox1.Text;
                newProd.Price = Convert.ToDouble(textBox2.Text);
                newProd.Image = "default";
                string query = "UPDATE product SET name = '" + newProd.Name + "', description = '" + newProd.Description + "', price = '" + newProd.Price +
                    "' WHERE id = '" + product.Id + "'";
                MySqlCommand command = new MySqlCommand(query, conn);

                try
                {
                    conn.Open();
                    command.ExecuteNonQuery();
                    conn.Close();
                    MessageBox.Show("Product updated successfully!");

                } catch (Exception ex)
                {
                    conn.Close();
                    MessageBox.Show("An error occured while updating a product!");
                }

                AdminForm adminF = new AdminForm();
                this.Hide();
                adminF.ShowDialog();
                this.Close();
            }
            else
            {
                Product newProd = new Product();
                newProd.Name = textBox1.Text;
                newProd.Description = richTextBox1.Text;
                newProd.Price = Convert.ToDouble(textBox2.Text);
                newProd.Image = "default";
                string query = "INSERT INTO product (name, description, price) " +
                    "VALUES ('" + newProd.Name + "', '" + newProd.Description + "', '" + newProd.Price + "');";
                MySqlCommand command = new MySqlCommand(query, conn);

                try
                {
                    conn.Open();
                    command.ExecuteNonQuery();
                    conn.Close();
                    MessageBox.Show("Product Added successfully!");

                } catch (Exception ex)
                {
                    conn.Close();
                    MessageBox.Show("An error occured while adding a product!");
                }

                AdminForm adminF = new AdminForm();
                this.Hide();
                adminF.ShowDialog();
                this.Close();
            }
        }

        private void textBox2_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.Handled = !char.IsDigit(e.KeyChar))
            {

            }
        }
    }
}
