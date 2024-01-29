using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CS322_DZ12
{
    public partial class Form1 : Form
    {
        private static string dataSource = "datasource=localhost;database=cs322dz12;port=3306;username=root;password=;";
        private MySqlConnection conn;
        private MySqlDataAdapter adapter;

        public Form1()
        {
            InitializeComponent();

            conn = new MySqlConnection(dataSource);
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            conn.Open();
            adapter = new MySqlDataAdapter();
            string q = "SELECT * FROM korisnik";
            adapter.SelectCommand = new MySqlCommand(q, conn);

            DataTable table = new DataTable();
            adapter.Fill(table);

            BindingSource bs = new BindingSource();
            bs.DataSource = table;

            dataGridView1.DataSource = bs;
            dataGridView1.AutoSizeRowsMode = DataGridViewAutoSizeRowsMode.AllCells;
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;

            conn.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string username = textBox1.Text;
            string password = textBox3.Text;
            string Query = "INSERT INTO korisnik (username, password) " +
                "VALUES ('" + username + "', '" + password + "');";
            MySqlCommand command = new MySqlCommand(Query, conn);

            try
            {
                conn.Open();
                command.ExecuteNonQuery();
                conn.Close();
                MessageBox.Show("Uspesno ste registrovali korisnika!");

            }
            catch (Exception ex)
            {
                conn.Close();
                MessageBox.Show("Desila se greska prilikom registracije!");
            }

            conn.Open();
            adapter = new MySqlDataAdapter();
            Query = "SELECT * FROM korisnik";
            adapter.SelectCommand = new MySqlCommand(Query, conn);

            DataTable table = new DataTable();
            adapter.Fill(table);

            BindingSource bs = new BindingSource();
            bs.DataSource = table;

            dataGridView1.DataSource = bs;
            dataGridView1.AutoSizeRowsMode = DataGridViewAutoSizeRowsMode.AllCells;
            dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;

            conn.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            openFileDialog1.ShowDialog();
            openFileDialog1.Title = "Browse Text Files";
            openFileDialog1.DefaultExt = "txt";
            openFileDialog1.Filter = "txt files (*.txt)|*.txt|All files (*.*)|*.*";

            MessageBox.Show(openFileDialog1.FileName);

            FileStream f = new FileStream("data.txt", FileMode.Create);
            StreamWriter s = new StreamWriter(f);

            using (FileStream fs = File.OpenRead(openFileDialog1.FileName))
            {
                byte[] b = new byte[1024];
                UTF8Encoding temp = new UTF8Encoding(true);
                while (fs.Read(b, 0, b.Length) > 0)
                {
                    s.WriteLine(temp.GetString(b));
                }
            }

            s.Close();
            f.Close();
        }
    }
}