using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BugFixTaskManager
{
    public interface IPrinter { void Print(string path); }
    public class Printer: IPrinter
    {

        public void Print(string path)
        {
            System.Console.WriteLine($"Printing .....{path}");
        }
    }
}
