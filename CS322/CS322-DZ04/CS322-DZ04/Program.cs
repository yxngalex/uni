using System;
using System.Diagnostics.CodeAnalysis;

namespace cs322_dz04
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            // 1, 2, 3, 4, 5 = 1 + 3 + 5 = 9
            first(5);
            second();
            third();
            
        }

        private static void first(int n)
        {
            int sum = 0;
            for (int i = 1; i <= n; i++)
            {
                if (i % 2 != 0)
                {
                    sum += i;
                }
            }

            Console.WriteLine(sum);
        }

        private static void second()
        {
            int sum = 0;
            for (int i = 8; i <= 16; i++)
            {
                sum += i;
            }

            sum *= 2;

            Console.WriteLine(Reverse(sum.ToString()));

        }
        private static void third() {
            string input = Console.In.ReadLine();
            bool isValid = true;
            if (int.TryParse(input, out int num))
            {
                if (num >= 1_000_000_000)
                {
                    Console.WriteLine("Broj nije validan");
                    return;
                }

                string numAsStr = num.ToString();
                for (int i = 0; i < numAsStr.Length - 1; i++)
                {
                    if (numAsStr[i] >= numAsStr[i + 1])
                    {
                        isValid = false;
                        break;
                    }
                }
            }
            else
            {
                Console.WriteLine("Broj nije validan");
                return;
            }

            Console.WriteLine(isValid ? "{0} ima strogo rastuce cifre" : "{0} nema strogo rastuce cifre", num);
        }

        private static string Reverse(string s)
        {
            char[] charArray = s.ToCharArray();
            Array.Reverse(charArray);
            return new string(charArray);
        }

    }
}
