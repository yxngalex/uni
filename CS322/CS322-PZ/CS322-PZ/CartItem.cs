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
    public partial class CartItem : UserControl
    {
        private static string dataSource = "datasource=localhost;database=cs322;port=3306;username=root;password=;";
        private MySqlConnection conn;
        private MySqlDataAdapter adapter;
        public CartItem()
        {
            InitializeComponent();
            conn = new MySqlConnection(dataSource);
        }

        #region Properties

        private int productId;
        private int userId;
        private Image image;
        private string name;
        private string description;
        private string price;

        [Category("Data")]
        public int itemId
        {
            get { return productId; }

            set { productId = value; }
        }
        [Category("Data")]
        public int itemUserId
        {
            get { return userId; }

            set { userId = value; }
        }
        [Category("Data")]
        public Image itemImage
        {
            get { return image; }

            set { image = value; pictureBox1.Image = Image.FromFile(System.Environment.GetFolderPath(System.Environment.SpecialFolder.MyPictures) + @value); }
        }

        [Category("Data")]
        public string itemName
        {
            get { return name; }

            set { name = value; label1.Text = value; }
        }

        [Category("Data")]
        public string itemDescription
        {
            get { return description; }

            set { description = value; label2.Text = value; }
        }

        [Category("Data")]
        public string itemPrice
        {
            get { return price; }

            set { price = value; label3.Text = value; }
        }

        #endregion
        private void flowLayoutPanel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            string query = "DELETE FROM cart WHERE user = " + userId + " AND product = " + productId + ";";
            MySqlCommand command = new MySqlCommand(query, conn);

            try
            {
                conn.Open();
                command.ExecuteNonQuery();
                conn.Close();
                MessageBox.Show("Item removed from the cart!");

            }
            catch (Exception ex)
            {
                conn.Close();
                MessageBox.Show("An error occured while removing an item!");
            }

        }
    }
}
