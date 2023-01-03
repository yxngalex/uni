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
    public partial class AdminForm : Form
    {
        private static string dataSource = "datasource=localhost;database=cs322;port=3306;username=root;password=;";
        private MySqlConnection conn;
        private MySqlDataAdapter adapter;
        public string Username = "";

        public AdminForm()
        {
            InitializeComponent();

            conn = new MySqlConnection(dataSource);
        }

        private void AdminForm_Load(object sender, EventArgs e)
        {
            try
            {
                label2.Text = Username;
                conn.Open();
                adapter = new MySqlDataAdapter();
                string q = "SELECT * FROM product";
                adapter.SelectCommand = new MySqlCommand(q, conn);

                DataTable table = new DataTable();
                adapter.Fill(table);

                BindingSource bSource = new BindingSource();
                bSource.DataSource = table;

                dataGridView1.DataSource = bSource;
                dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
                dataGridView1.AutoSizeRowsMode = DataGridViewAutoSizeRowsMode.AllCells;
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
            AddNewProductForm addProductF = new AddNewProductForm();
            this.Hide();
            addProductF.setProduct(null);
            addProductF.ShowDialog();
            this.Close();

        }

        private void button4_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count == 1)
            {
                DataGridViewSelectedCellCollection DSCL = dataGridView1.SelectedCells;

                Product product = new Product();
                product.Id = DSCL[0].Value.ToString();
                product.Name = DSCL[1].Value.ToString();
                product.Description = DSCL[2].Value.ToString();
                product.Price = (double)DSCL[3].Value;

                AddNewProductForm addProductF = new AddNewProductForm();
                this.Hide();
                addProductF.setProduct(product);
                addProductF.ShowDialog();
                this.Close();
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count == 1)
            {
                DataGridViewSelectedCellCollection DSCL = dataGridView1.SelectedCells;

                Product product = new Product();
                product.Id = DSCL[0].Value.ToString();

                string query = "DELETE FROM product WHERE id = " + product.Id ;
                MySqlCommand command = new MySqlCommand(query, conn);

                try
                {
                    conn.Open();
                    command.ExecuteNonQuery();
                    conn.Close();
                    MessageBox.Show("Product Deleted successfully!");

                } catch (Exception ex)
                {
                    conn.Close();
                    MessageBox.Show("An error occured while deleting a product!");
                }

                AdminForm adminF = new AdminForm();
                this.Hide();
                adminF.ShowDialog();
                this.Close();
            }

        }
    }
}
