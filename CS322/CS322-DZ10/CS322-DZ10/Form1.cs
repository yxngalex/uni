using System.Collections;
using System.Windows.Forms;

namespace CS322_DZ10
{
    public partial class Form1 : Form
    {
        ArrayList arr = new ArrayList();
        Stack<int> stack = new Stack<int>();
        Queue<int> queue = new Queue<int>();

        public Form1()
        {
            InitializeComponent();

            for (int i = 1; i <= 100; i++)
            {
                arr.Add(i);
                stack.push(i);
                queue.enqueue(i);
            }
            listBox1.DataSource = arr;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Random rand = new Random();
            int n = rand.Next(1, 100);
            arr.Add(n);
            listBox1.DataSource = null;
            listBox1.DataSource = arr;
            MessageBox.Show("Dodat je broj: " + n);

        }

        private void button2_Click(object sender, EventArgs e)
        {

            object selected = listBox1.SelectedItem;
            arr.Remove(selected);
            // listBox1.Refresh();
            listBox1.DataSource = null;
            listBox1.DataSource = arr;
        }

    }
}

public class Stack<T>
{
    private T[] _data;
    private int _index;
    private int _size = 16;

    public Stack()
    {
        _data = new T[_size];
        _index = -1;
    }

    public Stack(List<T> initial)
    {
        _data = initial.ToArray().Clone() as T[] ?? new T[16];
        _index = _data.Length - 1;
        _size = _data.Length;
    }

    public Stack(T[] initial)
    {
        // clone rather than reference
        _data = initial.Clone() as T[] ?? new T[16];
        _index = _data.Length - 1;
        _size = _data.Length;
    }

    public Stack(Stack<T> stack) : this(stack._data)
    {
    }

    public T peek()
    {
        return _data[_index - 1];
    }

    public void push(T val)
    {

        if (_index + 1 == _size)
        {
            _size *= 2;
            T[] newArr = new T[_size];
            _data.CopyTo(newArr, 0);
            _data = newArr;
        }
        _data[++_index] = val;
    }

    public T pop()
    {
        return _data[_index--];
    }
    public bool isEmpty()
    {
        return _index == -1;
    }

    public override string ToString()
    {
        return string.Join(", ", _data[..(_index + 1)]);
    }
}

public class Queue<T>
{
    private T[] _data;
    private int _frontIndex;
    private int _backIndex;
    private int _size = 16;

    public Queue()
    {
        // initial size
        _data = new T[_size];
        _frontIndex = -1;
        _backIndex = -1;
    }

    public T peekFront()
    {
        return _data[_frontIndex];
    }

    public void enqueue(T val)
    {

        if (_backIndex + 1 == _size)
        {
            _size *= 2;
            T[] newArr = new T[_size];
            _data.CopyTo(newArr, 0);
            _data = newArr;
        }
        _data[++_backIndex] = val;
    }

    public T poll()
    {
        return _data[++_frontIndex];
    }

    public bool isEmpty()
    {
        return _frontIndex == _backIndex;
    }

    public override string ToString()
    {
        return string.Join(", ", _data[_frontIndex.._backIndex]);
    }
}