namespace CS322_DZ09
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        public int[] global_arr = { 4, 2, 1, 3, 5, 8, 7, 6, 9, 10 };

        private void button1_Click(object sender, EventArgs e)
        {
            int sum = 0;
            for (int i = 0; i <= 3000; i++)
            {
                sum += 1;
            }

            MessageBox.Show("Zadatak 1: " + sum);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            int count = 100;
            int sum = 0;
            int i = 1;
            while (count-- > 0)
            {
                if (i % 2 == 0)
                {
                    sum += i;
                }

                i++;
            }

            MessageBox.Show("Zadatak 2: " + sum);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            int sum = 0;
            for (int i = 21; i < 99; i++)
            {
                if (i % 2 == 0)
                {
                    sum += i;
                }
            }

            MessageBox.Show("Zadatak 3: " + sum);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            int len = global_arr.Length;

            int sum = global_arr.Sum();

            float average = sum / (float)len;

            foreach (int elem in global_arr)
            {
                listBox1.Items.Add(elem);
            }

            MessageBox.Show("Zadatak 4; suma: " + sum + ", srednja vrednost: " + average);

        }

        private void button5_Click(object sender, EventArgs e)
        {
            int len = global_arr.Length;

            Array.Sort(global_arr);
            int min = global_arr[0];
            int max = global_arr[len - 1];

            foreach (int elem in global_arr)
            {
                listBox2.Items.Add(elem);
            }

            MessageBox.Show("Zadatak 5; min: " + min + ", max: " + max);

        }

    }
}