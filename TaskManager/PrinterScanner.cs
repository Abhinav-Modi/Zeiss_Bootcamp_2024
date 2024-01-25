using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BugFixTaskManager
{
    public class PrintScanner: IPrinter, IScanner
    {
        public void Print(string path)
        {
            System.Console.WriteLine($"PrinterScanner Printing .....{path}");
        }

        public void Scan(string path)
        {
            System.Console.WriteLine($"PrinterScanner Scanning .....{path}");
        }
    }
}
