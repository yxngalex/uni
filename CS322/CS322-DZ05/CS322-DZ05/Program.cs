using System;

namespace cs322_dz05
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            first();
            second();

        }

        private static void first() 
        {
            Console.Write("Number: ");
            string numStr = Console.ReadLine();
            Console.Write("Power: ");
            string expStr = Console.ReadLine();
            if (long.TryParse(numStr, out long num) && long.TryParse(expStr, out long exp))
            {
                long res = Power(num, exp);
                Console.WriteLine("Result: {0}", res);
            }
        }
        private static void second() 
        {
            Visitor v = new Visitor();
            v.FirstName = Helper.GetRandStr();
            v.LastName = Helper.GetRandStr();
            v.TicketNum = Helper.GetRandInt();

            Visitor v2 = new Visitor();
            v2.FirstName = Helper.GetRandStr();
            v2.LastName = Helper.GetRandStr();
            v2.TicketNum = Helper.GetRandInt();

            Console.WriteLine(v);
            Console.WriteLine(v2);


        }
        private static long Power(long num, long exp)
        {
            if (num == 0)
                throw new ArgumentException("Number is a zero!");

            if (exp < 0)
                throw new ArgumentException("Power has to be positive or 0");

            return (long)Math.Pow(num, exp);
        }

    }

    internal class Visitor
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public int TicketNum { get; set; }

        public override string ToString()
        {
            return $"Visitor: {FirstName} {LastName}, has a ticket with number: {TicketNum}";
        }
    }

    internal static class Helper
    {
        public static string GetRandStr()
        {
            string res = "";
            Random random = new Random();
            for (int i = 0; i < 8; i++)
            {
                res += (char)random.Next('a', 'z');
            }

            return res.Substring(0, 1).ToUpper() + res.Substring(1);
        }

        public static int GetRandInt()
        {
            Random rand = new Random();
            return rand.Next(1, 200);
        }
    }
}