namespace CS322_DZ01
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            int fnameLen = textBox1.Text.Split(' ').Length;
            int lnameLen= textBox2.Text.Split(' ').Length;
            int addressLen = textBox3.Text.Split(' ').Length;

            if (fnameLen != 1)
            {
                errorLab.Text = "Ime mora biti duzine 1";
            }
            else if (addressLen < 2)
            {
                errorLab.Text = "Adresa mora biti najmanje 1 rec";
            }
            else
            {

                String msg = textBox1.Text + " " + textBox2.Text + " " + textBox3.Text + " ";

                MessageBox.Show(msg);

                FileStream f = new FileStream("data.txt", FileMode.Create);
                StreamWriter s = new StreamWriter(f);

                s.WriteLine(msg);
                s.Close();
                f.Close();
            }

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            hidden_label.Text = "";
        }

        private void label4_Click_1(object sender, EventArgs e)
        {

        }

        private void color_green_Click(object sender, EventArgs e)
        {
            this.BackColor = System.Drawing.Color.Green;
        }

        private void color_red_Click(object sender, EventArgs e)
        {
            this.BackColor = System.Drawing.Color.Red;
        }
    }
}