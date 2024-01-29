using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using System.Windows.Forms;

namespace CS322_DZ07
{
	public partial class Form1 : Form
	{

		private static string mySqlConnectionString = "datasource=localhost;port=3306;username=root;passowrd=;Integrated Security=True;";
		private static string databaseName = "users";
		private static string databaseQuery = "CREATE DATABASE IF NOT EXISTS " + databaseName + ";";
		private static string createQuery =
			" CREATE TABLE IF NOT EXISTS " + databaseName + ".user(" +
			" id INT NOT NULL AUTO_INCREMENT," +
			" name VARCHAR(127) NOT NULL," +
			" surname VARCHAR(127) NOT NULL," +
			" birthdate VARCHAR(127) NOT NULL," +
			" sex VARCHAR(127) NOT NULL," +
			" student BOOLEAN NOT NULL," +
			" PRIMARY KEY (id)" +
			" );";

		private MySqlConnection mySqlConnection;
		private MySqlDataAdapter mySqlDataAdapter;

		public Form1()
		{
			InitializeComponent();

			mySqlConnection = new MySqlConnection(mySqlConnectionString);
			izvrsiUpit(mySqlConnection, databaseQuery);
			izvrsiUpit(mySqlConnection, createQuery);
		}

		private void label1_Click(object sender, EventArgs e)
		{

		}

		private void radioButton1_CheckedChanged(object sender, EventArgs e)
		{

		}

		private void izvrsiUpit(MySqlConnection connection, string query)
		{
			MySqlCommand mySqlCommand = new MySqlCommand(query, connection);
			try
			{
				connection.Open();
				mySqlCommand.ExecuteNonQuery();
				connection.Close();
				MessageBox.Show("Success");
			}
			catch (Exception ex)
			{
				connection.Close();
				MessageBox.Show("Error!");
			}
		}

		private void button1_Click(object sender, EventArgs e)
		{
			string name = textBox1.Text;
			string surname = textBox2.Text;
			string birthDate = textBox3.Text;
			bool Male = radioButton1.Checked;
			bool Female = radioButton2.Checked;

			int student = checkBox1.Checked == true ? 1 : 0;

			if (name.Length == 0 || surname.Length == 0 || birthDate.Length == 0)
			{
				MessageBox.Show("Input fields can't be empty");
				return;
			}

			string pol = (radioButton1.Checked == true) ? "Male" : "Female";

			string query = "INSERT INTO " + databaseName + ".user(name, surname, birthdate, sex, student) " +
				"VALUES ('" + name + "', '" + surname + "', '" + birthDate + "', '" 
				+ pol + "', '" + student + "');";
			izvrsiUpit(mySqlConnection, query);
			MessageBox.Show("User is created!");
		}

		private void button2_Click(object sender, EventArgs e)
		{
			mySqlConnection.Open();
			mySqlDataAdapter = new MySqlDataAdapter();
			string query = "SELECT * FROM " + databaseName + ".user as u;";
			mySqlDataAdapter.SelectCommand = new MySqlCommand(query, mySqlConnection);

			DataTable table = new DataTable();
			mySqlDataAdapter.Fill(table);

			BindingSource bs = new BindingSource();
			bs.DataSource = table;

			dataGridView1.DataSource = bs;
			dataGridView1.AutoSizeRowsMode = DataGridViewAutoSizeRowsMode.AllCells;
			dataGridView1.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;

			mySqlConnection.Close();
		}
	}
}
