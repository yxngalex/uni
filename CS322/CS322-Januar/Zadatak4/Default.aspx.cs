using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Zadatak4
{
    public partial class _Default : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Unnamed2_Click(object sender, EventArgs e)
        {
            string uInput = TextBox1.Text;
            int n = Convert.ToInt32(TextBox1.Text);
            int prod = 1;
            try
            {
                if (n <= 0)
                {
                    throw new Exception("Broj ne moze da bude negativan ili 0");
                }
                else
                {
                    for(int i = 0; i < uInput.Length; i++)
                    {
                        prod *= n % 10;
                        n /= 10;
                    }
                    Label1.Text = "Proizvod cifara unetog broja je: " + prod;
                }
            } catch (FormatException ex)
            {
                Label1.Text = "Input ne sme da sadrzi slova ili da bude prazan";
            }
            catch (Exception ex)
            {
                Label1.Text = ex.Message;
            }

        }
    }
}