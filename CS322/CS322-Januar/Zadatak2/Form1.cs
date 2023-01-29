using System;
using System.Data;
using System.DirectoryServices.ActiveDirectory;
using System.Drawing;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace Zadatak2
{
    public partial class Form1 : Form
    {
        private static DataSource dataSource = new DataSource();
        private static MySqlConnection conn;
        private static MySqlCommand comm;
        private static MySqlDataAdapter adapter;
        public Form1()
        {
            conn = new MySqlConnection(dataSource.getDataSource());
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            try
            {
                conn.Open();
                string q = "SELECT * FROM knjiga";
                adapter = new MySqlDataAdapter();
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
            catch(Exception ex){
                MessageBox.Show(ex.Message);

            }   
            finally
            {
                conn.Close();
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                conn.Open();
                String query = "INSERT INTO knjiga(naziv, opis, kategoriju, cenu) VALUES('" +
                    textBox1.Text + "', '" +
                    textBox2.Text + "', '" +
                    textBox4.Text + "', " +
                    Convert.ToDouble(textBox3.Text) + ");";
                comm = new MySqlCommand(query, conn);
                comm.ExecuteNonQuery();
                conn.Close();
                this.Form1_Load(sender, e);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                conn.Close();
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            int id = Convert.ToInt32(dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
            try
            {
                conn.Open();
                String query = "Update knjiga SET " +
                    "naziv = '" + textBox1.Text + "', " +
                    "opis = '" + textBox2.Text + "', " +
                    "cenu = " + Convert.ToDouble(textBox3.Text) + ", " +
                    "kategoriju = '" + textBox4.Text + "' WHERE id = '" + id + "';";
                comm = new MySqlCommand(query, conn);
                comm.ExecuteNonQuery();
                conn.Close();
                this.Form1_Load(sender, e);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                conn.Close();
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            try
            {
                conn.Open();
                int id = Convert.ToInt32(dataGridView1.SelectedRows[0].Cells[0].Value.ToString());
                String query = "DELETE FROM knjiga WHERE id = " + id + ";";
                comm = new MySqlCommand(query, conn);
                comm.ExecuteNonQuery();
                conn.Close();
                this.Form1_Load(sender, e);
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                conn.Close();
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {

        }
    }
}